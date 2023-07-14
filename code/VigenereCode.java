import java.util.*;

public class VigenereCode{
	
	public static final VigenereCode INSTANCE = new VigenereCode();
	
	private VigenereCode(){
	
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
		System.out.println("Enter the key:");
		String key = sc.nextLine();
		System.out.println("The encoded string is: ");
		System.out.println(encode(s, key));
	}
	private  void decode(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the string you want to decode:");
		String s = sc.nextLine();
		System.out.println("Enter the key:");
		String key = sc.nextLine();
		System.out.println("The decoded string is: ");
		System.out.println(decode(s, key));
	}
	
	private  String encode(String message, String key){
		if(key.length() == 0){
			throw new IllegalArgumentException("Key is empty");
		}
		if(message.length() == 0){
			return "";
		}
		List<Character> list = charArrayToList(key.toCharArray());
		while(list.size() < message.length()){
			list.addAll(list);
		}
		List<Character> messageList = charArrayToList(message.toCharArray());
		//let the characters in the messageList be encrypted with the characters in the keyList
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < messageList.size(); i++){
			sb.append(letterRightMove(messageList.get(i), letterToInt(list.get(i))));
		}
		return sb.toString();
	}
	
	private  String decode(String message, String key){
		if(key.length() == 0){
			throw new IllegalArgumentException("Key is empty");
		}
		if(message.length() == 0){
			return "";
		}
		List<Character> list = charArrayToList(key.toCharArray());
		while(list.size() < message.length()){
			list.addAll(list);
		}
		List<Character> messageList = charArrayToList(message.toCharArray());
		//let the characters in the messageList be decrypted with the characters in the keyList
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < messageList.size(); i++){
			sb.append(letterLeftMove(messageList.get(i), letterToInt(list.get(i))));
		}
		return sb.toString();
	}
	
	private static List<Character> charArrayToList(char[] array){
		List<Character> list = new ArrayList<>();
		for(char c : array){
			list.add(c);
		}
		return list;
	}
	
	private static int letterToInt(char c){
		if(!Character.isLetter(c)){
			throw new IllegalArgumentException("Not a letter");
		}
		if(Character.isUpperCase(c)){
			return c - 'A';
		}else{
			return c - 'a';
		}
	}
	
	private static char letterLeftMove(char c, int n){
		int i = letterToInt(c);
		i = (i - n + 26) % 26;
		if(Character.isUpperCase(c)){
			return (char)(i + 'A');
		}
		else{
			return (char)(i + 'a');
		}
	}
	
	private static char letterRightMove(char c, int n){
		int i = letterToInt(c);
		i = (i + n) % 26;
		if(Character.isUpperCase(c)){
			return (char)(i + 'A');
		}else{
			return (char)(i + 'a');
		}
	}
}
