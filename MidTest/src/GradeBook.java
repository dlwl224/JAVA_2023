import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class GradeBook {
	private ArrayList<Student> list;
	
	public GradeBook() {
		this.list= new ArrayList<>();
	}
	
	public void saveStudent(Student student) {
		list.add(student);
		System.out.println(student.name+"학생이 저장되었습니다.");
		System.out.println("이름:"+student.getName());
		System.out.println("학번:"+student.getNumber());
		System.out.println("성적:"+student.getGrade());
	}
	
	public double averageGrade() {
		double sum=0;
		double avg=1.0;
		
		for(Student student: list) {
			sum+= student.getGrade();
			
		}
		avg=sum/list.size();
		return avg;
	}
	public void searchStudent(String number) {
		for(Student student: list) {
			if(student.getNumber().equals(number)) {
				System.out.println("학번이" +number+"인 학생을 찾았습니다.");	
			    System.out.println("이름:"+student.getName());
			    System.out.println("학번:"+student.getNumber());
			    System.out.println("성적:"+student.getGrade());
			    
				}
		}
		System.out.println("학번이"+number+"인 학생을 찾을 수 없습니다.");
		
	}
	public void showAllStu() {
		System.out.println("전체 학생은 총"+list.size()+"명이고 , 학생들의 전체 평균 점수는"+averageGrade()+"점입니다." );
		for(Student student : list) {
			System.out.println(student);
		}
		System.out.println();
		
	}
	public void printAllStu() {
		try(PrintWriter writer= new PrintWriter(new FileWriter("stu_out.txt"))){
			writer.println("현전체 학생은 총"+list.size()+"명이고, 학생들의 전체 평균은 "+averageGrade()+"점입니다.");
			for (Student student : list) {
				writer.println(student);
				
			}
			System.out.println("학생 정보가 파일이 저장되었습니다.");
			
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
