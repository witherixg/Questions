import java.util.*;

public class AvoidNumber{
	
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		int avoid = 0;
		while(avoid < 2){
			System.out.print("需要避开的数字：");
			avoid = s.nextInt();
		}
		System.out.print("开始的数字：");
		int start = s.nextInt();
		while(true){
			while(test(avoid, start)){
				start += 1;
			}
			System.out.print(start); //输出
			s.nextLine();
			start += 1;
		}
	}
	
	public static boolean test(int avoidNum, int thisNum){
		String thisString = String.valueOf(thisNum);
		return (thisNum % avoidNum == 0)
		       || (thisString.contains(String.valueOf(avoidNum)));
	}
}
