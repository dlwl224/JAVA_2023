package application;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GalagaGame extends Application {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    private Image playerImage;
    private Image enemyImage;

    private double playerX = WIDTH / 2;
    private double playerY = HEIGHT - 50;
    private double playerSpeed = 5;

    private double enemyX = Math.random() * (WIDTH - 50);
    private double enemyY = 0;
    private double enemySpeed = 2;

    private boolean gameOver = false;
    private boolean bulletFired = false;
    private double bulletX;
    private double bulletY;
    private double bulletSpeed = 5;

    private int score = 0;

    private Button restartButton;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Galaga Game");

        playerImage = new Image("player.png");
        enemyImage = new Image("enemy.png");

        Canvas canvas = new Canvas(WIDTH, HEIGHT);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        StackPane root = new StackPane();
        root.getChildren().add(canvas);

        restartButton = new Button("Restart Game");
        restartButton.setOnAction(e -> restartGame());
        restartButton.setVisible(false); // 초기에는 보이지 않도록 설정

        root.getChildren().addAll(restartButton);

        Scene scene = new Scene(root, WIDTH, HEIGHT);
        scene.setOnKeyPressed(e -> handleKeyPress(e.getCode()));

        primaryStage.setScene(scene);
        primaryStage.show();

        new AnimationTimer() {
            @Override
            public void handle(long currentNanoTime) {
                if (!gameOver) {
                    update();
                    render(gc);
                }
            }
        }.start();
    }

    private void handleKeyPress(KeyCode code) {
        if (gameOver) {
            return; // 게임 오버 시 키 입력 무시
        }

        if (code == KeyCode.LEFT && playerX > 0) {
            playerX -= playerSpeed;
        } else if (code == KeyCode.RIGHT && playerX < WIDTH - 50) {
            playerX += playerSpeed;
        } else if (code == KeyCode.SPACE && !bulletFired) {
            bulletX = playerX + 25;
            bulletY = playerY;
            bulletFired = true;
        }
    }

    private void update() {
        if (gameOver) {
            return; // 게임 오버 시 업데이트 중지
        }

        enemyY += enemySpeed;

        if (enemyY > HEIGHT) {
            enemyY = 0;
            enemyX = Math.random() * (WIDTH - 50);
        }

        if (bulletFired) {
            bulletY -= bulletSpeed;
            if (bulletY < 0) {
                bulletFired = false;
            }
        }

        if (isCollision()) {
            gameOver = true;
            restartButton.setVisible(true); // 게임 오버 시 버튼 표시
        }

        // Check collision with enemy and remove enemy
        if (bulletFired && bulletX < enemyX + 50 && bulletX + 2 > enemyX &&
                bulletY < enemyY + 50 && bulletY + 10 > enemyY) {
            bulletFired = false;
            enemyY = 0;
            enemyX = Math.random() * (WIDTH - 50);
            score += 10;
        }
    }

    private boolean isCollision() {
        return playerX < enemyX + 50 && playerX + 50 > enemyX &&
                playerY < enemyY + 50 && playerY + 50 > enemyY;
    }

    private void render(GraphicsContext gc) {
        gc.clearRect(0, 0, WIDTH, HEIGHT);

        // 플레이어 그리기
        gc.drawImage(playerImage, playerX, playerY, 50, 50);

        // 적 그리기
        gc.drawImage(enemyImage, enemyX, enemyY, 50, 50);

        // 총알 그리기
        if (bulletFired) {
            gc.setFill(Color.RED);
            gc.fillRect(bulletX, bulletY, 2, 10);
        }

        // 점수 표시
        gc.setFill(Color.BLACK);
        gc.fillText("score: " + score, 10, 20);

        // 게임 오버 메시지 표시
        if (gameOver) {
        	gc.setFill(Color.BLACK);
            gc.fillText("Game over", WIDTH / 2 - 30, HEIGHT / 2 - 20);
        }
    }

    private void restartGame() {
        // 게임 변수 초기화
        gameOver = false;
        score = 0;
        playerX = WIDTH / 2;
        playerY = HEIGHT - 50;
        enemyX = Math.random() * (WIDTH - 50);
        enemyY = 0;

        // 총알 초기화
        bulletFired = false;

        // 재시작 버튼 숨기기
        restartButton.setVisible(false);
    }
}
