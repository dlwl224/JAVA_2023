import java.util.ArrayList;
import java.util.List;

enum Type{
	MEAT,FISH,OTHER
}
public class Test1 {

	public static void main(String[] args) {
		List<Food> buffetMenu = new ArrayList<>();
        buffetMenu.add(new Food("Salad", true, 150, Type.OTHER));
        buffetMenu.add(new Food("Steak", false, 500, Type.MEAT));
        buffetMenu.add(new Food("Grilled Vegetables", true, 250, Type.OTHER));
        buffetMenu.add(new Food("Fish Fillet", false, 280, Type.FISH));

        List<String> lowCalorieVegetarianFoods = new ArrayList<>();
        for (Food food : buffetMenu) {
            if (food.getCalories() <= 300 && food.isVege()) {
                lowCalorieVegetarianFoods.add(food.getName());
            }
        }

       
        System.out.println("Low-calorie vegetarian foods in the buffet menu: " + lowCalorieVegetarianFoods);
    

	}

}

