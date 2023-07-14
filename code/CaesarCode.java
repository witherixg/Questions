import java.util.*;

public class CaesarCode{
	
	public static final CaesarCode INSTANCE = new CaesarCode();
	
	private CaesarCode(){
	}
	
	public static void main(String... args){
		Scanner sc = new Scanner(System.in);
		while(true){
			System.out.println("Enter the command(encode/decode):");
			String s = sc.next();
			switch(s){
				case "encode" -> INSTANCE.encode();
				case "decode" -> INSTANCE.decode();
				case "exit" -> {
					sc.close();
					System.out.println("Bye!");
					System.exit(0);
				}
				default -> System.out.println("Invalid command!");
			}
		}
	}
	
	private void encode(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the string you want to encode:");
		String s = sc.nextLine();
		System.out.println("Enter the offset:");
		int offset = sc.nextInt();
		System.out.println("The encoded string is: ");
		System.out.println(encode(s, offset));
		sc.close();
	}
	
	private void decode(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the string you want to decode:");
		String s = sc.nextLine();
		System.out.println("Enter the offset:");
		int offset = sc.nextInt();
		System.out.println("The decoded string is: ");
		System.out.println(decode(s, offset));
		sc.close();
	}
	
	private String encode(String s, int offset){
		char[] characters = s.toCharArray();
		for(int i = 0; i < characters.length; i++){
			for(int j = 0; j < offset; j++){
				if(characters[i] == 'z'){
					characters[i] = 'a';
				}else if(characters[i] == 'Z'){
					characters[i] = 'A';
				}else if((characters[i] >= 'a' && characters[i] <= 'z') ||
				         (characters[i] >= 'A' && characters[i] <= 'Z')){
					characters[i]++;
				}
			}
		}
		return new String(characters).intern();
	}
	
	private String decode(String s, int offset){
		char[] characters = s.toCharArray();
		for(int i = 0; i < characters.length; i++){
			for(int j = 0; j < offset; j++){
				if(characters[i] == 'a'){
					characters[i] = 'z';
				}else if(characters[i] == 'A'){
					characters[i] = 'Z';
				}else if((characters[i] >= 'a' && characters[i] <= 'z') ||
				         (characters[i] >= 'A' && characters[i] <= 'Z')){
					characters[i]--;
				}
			}
		}
		return new String(characters).intern();
	}
}
