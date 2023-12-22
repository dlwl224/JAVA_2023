interface ArrayProcessing{
	double apply(double[] array);
}
public class LambdaTest {
	public static final ArrayProcessing maxer=array->{
		if (array.length == 0) return 0; // Handle empty array
        double max = array[0];
        for (double num : array) {
            max = Math.max(max, num);
        }
        return max;
	};
	public static final ArrayProcessing miner=array->{
		if (array.length == 0) return 0; // Handle empty array
        double min = array[0];
        for (double num : array) {
            min = Math.min(min, num);
        }
        return min;
		
	};
	public static final ArrayProcessing sumer=array->{
		if (array.length == 0) return 0; // Handle empty array
        double sum = 0;
        for (double num : array) {
            sum += num;
        }
        return sum / array.length;
	};

	public static void main(String[] args) {
double[] numbers = {1.5, 2.0, 3.5, 2.8, 4.2};
        
        double max = maxer.apply(numbers);
        double min = miner.apply(numbers);
        double average = sumer.apply(numbers);
        
        System.out.println("Max: " + max);
        System.out.println("Min: " + min);
        System.out.println("Average: " + average);
    }
		

}


