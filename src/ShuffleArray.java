import java.util.*;

public class ShuffleArray{
	public static int[] shuffleArray(int[] array){
		int[] newArray = Arrays.copyOf(array, array.length);
		Random r = new Random();
		for(int i = 0; i < newArray.length; i++){
			int randomIndex = r.nextInt(newArray.length);
			int temp = newArray[i];
			newArray[i] = newArray[randomIndex];
			newArray[randomIndex] = temp;
		}
		return newArray;
	}
	
	public static void main(String[] args){
		System.out.println(Arrays.toString(shuffleArray(new int[]{1,2,3,4,5,6,7,8,9})));
	}
}
