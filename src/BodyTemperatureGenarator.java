import java.util.*;

public class BodyTemperatureGenarator{
	
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		Random r = new Random();
		int count = 0;
		while(count < 1){
			System.out.print("输入体温数量：");
			count = s.nextInt();
		}
		for(int i = 0; i < count; i++){
			System.out.printf("(%d)->36.%d°C\n", i + 1, r.nextInt(7) + 3);
		}
	}
}
