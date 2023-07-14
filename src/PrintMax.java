public class PrintMax{
	
	//print the max value in the 3 numbers
	public static void printMax(int a, int b, int c){
		System.out.println("The max value is: " + (a > b ? a : Math.max(b, c)));
	}
	
	public static void main(String[] args){
		printMax(1, 2, 3);
		printMax(3, 2, 1);
		printMax(2, 2, 2);
	}
}
