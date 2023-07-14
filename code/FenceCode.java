import java.util.*;

public class FenceCode{
	
	public static final FenceCode INSTANCE = new FenceCode();
	
	private FenceCode(){
	
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		while(true){
			System.out.println("Enter the command(encode/decode):");
			String s = sc.next();
			switch(s){
				case "encode" -> INSTANCE.encode();
				case "decode" -> INSTANCE.decode();
				case "exit" -> {
					System.out.println("Bye!");
					System.exit(0);
				}
				default -> System.out.println("Invalid command!");
			}
		}
	}
	
	private  void encode(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the string you want to encode:");
		String s = sc.nextLine();
		System.out.println("Enter the column:");
		int column = sc.nextInt();
		System.out.println("The encoded string is: ");
		System.out.println(encode(s, column));
	}
	
	private  void decode(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the string you want to decode:");
		String s = sc.nextLine();
		System.out.println("Enter the column:");
		int column = sc.nextInt();
		System.out.println("The decoded string is: ");
		System.out.println(decode(s, column));
	}
	
	private  String encode(String s, int column){
		StringBuilder result = new StringBuilder();
		for(int i = 0; i < column; i++){
			for(int j = 0; i + j * column < s.length(); j++){
				result.append(s.charAt(i + j * column));
			}
		}
		return result.toString();
	}
	
	private  String decode(String s, int column){
		StringBuilder temp = new StringBuilder();
		StringBuilder result = new StringBuilder();
		int indexWhiteList = (s.length() - (s.length() / column) * column) * divideUp(s.length(), column);
		char[] chars = s.toCharArray();
		for(int i = 0; i < chars.length; i++){
			if(indexWhiteList != 0 && i > indexWhiteList && (i - indexWhiteList) % (divideUp(s.length(), column) - 1) == 0){
				temp.append(' ');
			}
			temp.append(chars[i]);
		}
		int deleteLength = temp.length() - s.length();
		String tempString = temp.toString();
		for(int i = 0; i < divideUp(s.length(), column); i++){
			for (int j = 0; j < column; j++){
				if(j * divideUp(s.length(), column) + i < tempString.length()){
					result.append(tempString.charAt(j * divideUp(s.length(), column) + i));
				}
			}
		}
		result.delete(result.length() - deleteLength, result.length());
		return result.toString();
	}
	
	private  int divideUp(int x, int y){
		if(x % y == 0){
			return x / y;
		}else{
			return x / y + 1;
		}
	}
}