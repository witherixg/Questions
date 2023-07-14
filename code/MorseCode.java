import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class MorseCode{
	
	public static final MorseCode INSTANCE = new MorseCode();
	
	private MorseCode(){
	}
	
	private final Map<Character, String> codes = new HashMap<>();
	private String defaultKeyword;
	// the morse code for each character
	{
		try{
			Properties properties = new Properties();
			properties.load(new FileReader("D:\\IdeaProject\\Questions\\src\\properties\\morse_code.properties"));
			defaultKeyword = properties.getProperty("defaultKeyword");
		}catch(IOException e){
			e.printStackTrace();
		}
		codes.put('a', ".-");
		codes.put('b', "-...");
		codes.put('c', "-.-.");
		codes.put('d', "-..");
		codes.put('e', ".");
		codes.put('f', "..-.");
		codes.put('g', "--.");
		codes.put('h', "....");
		codes.put('i', "..");
		codes.put('j', ".---");
		codes.put('k', "-.-");
		codes.put('l', ".-..");
		codes.put('m', "--");
		codes.put('n', "-.");
		codes.put('o', "---");
		codes.put('p', ".--.");
		codes.put('q', "--.-");
		codes.put('r', ".-.");
		codes.put('s', "...");
		codes.put('t', "-");
		codes.put('u', "..-");
		codes.put('v', "...-");
		codes.put('w', ".--");
		codes.put('x', "-..-");
		codes.put('y', "-.--");
		codes.put('z', "--..");
		codes.put('1', ".----");
		codes.put('2', "..---");
		codes.put('3', "...--");
		codes.put('4', "....-");
		codes.put('5', ".....");
		codes.put('6', "-....");
		codes.put('7', "--...");
		codes.put('8', "---..");
		codes.put('9', "----.");
		codes.put('0', "-----");
		codes.put('!', "-.-.--");
		codes.put('@', ".--.-.");
		codes.put('#', "-...--");
		codes.put('$', "...-..-");
		codes.put('%', "-..-.-");
		codes.put('^', "-.----.");
		codes.put('&', ".-...");
		codes.put('*', "-.-.-.");
		codes.put('(', "-.--.");
		codes.put(')', "-.--.-");
		codes.put('_', "..--.-");
		codes.put('-', "-....-");
		codes.put('=', "-...-");
		codes.put('+', ".-.-.");
		codes.put('[', "-.--.--");
		codes.put(']', "-.---.-");
		codes.put('{', "----.--");
		codes.put('}', "-----.-");
		codes.put(';', "-.-.-.");
		codes.put(':', "---...");
		codes.put('\'', ".----.");
		codes.put('"', ".-..-.");
		codes.put('\\', "-.---..");
		codes.put('|', "-----..");
		codes.put('<', "----..");
		codes.put(',', "--..--");
		codes.put('>', "-----.");
		codes.put('.', ".-.-.-");
		codes.put('?', "..--..");
		codes.put('/', "-..-.");
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
					System.out.println("Bye!");
					System.exit(0);
				}
				default -> System.out.println("Invalid command!");
			}
		}
	}
	
	//get the key to the value in the map
	public static Character getKey(Map<Character, String> map, String value){
		for(Character key : map.keySet()){
			if(map.get(key).equals(value)){
				return key;
			}
		}
		return null;
	}
	
	private void encode(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the string you want to encode:");
		String s = sc.nextLine();
		System.out.println("Enter the dit, dah, and spilt:");
		String input = sc.nextLine();
		while(!(input.length() >= 3 || defaultKeyword.equals(input))){
			System.out.println("Please continue to enter the dit, dah, and spilt:");
			input += sc.nextLine();
		}
		char dit;
		char dah;
		char spilt;
		if(defaultKeyword.equals(input)){
			dit   = '.';
			dah   = '-';
			spilt = '/';
		}else{
			dit   = input.charAt(0);
			dah   = input.charAt(1);
			spilt = input.charAt(2);
		}
		System.out.println("The encoded string is:");
		System.out.println(encode(s, dit, dah, spilt));
	}
	
	private void decode(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the string you want to decode:");
		String s = sc.nextLine();
		System.out.println("Enter the dit, dah, and spilt:");
		String input = sc.nextLine();
		while(!(input.length() >= 3 || defaultKeyword.equals(input))){
			System.out.println("Please continue to enter the dit, dah, and spilt:");
			input += sc.nextLine();
		}
		char dit;
		char dah;
		char spilt;
		if(defaultKeyword.equals(input)){
			dit   = '.';
			dah   = '-';
			spilt = '/';
		}else{
			dit   = input.charAt(0);
			dah   = input.charAt(1);
			spilt = input.charAt(2);
		}
		System.out.println("Do you want to insert spaces?(y/n)");
		boolean b = sc.next().charAt(0) == 'y';
		System.out.println("The decoded string is:");
		System.out.println(decode(s, dit, dah, spilt, b));
	}
	
	private String encode(String s, char dit, char dah, char spilt){
		if(s.isEmpty()){
			return "";
		}
		//get each character in the string
		s = s.toLowerCase();
		String[] characters = s.split("");
		String defaultCode;
		StringBuilder sb = new StringBuilder();
		//encode each character
		for(String character : characters){
			defaultCode = codes.get(character.charAt(0));
			if(defaultCode == null){
				sb.append("<unknown : ").append(character).append(">");
				continue;
			}
			for(int i = 0; i < defaultCode.length(); i++){
				if(defaultCode.charAt(i) == '.'){
					sb.append(dit);
				}else if(defaultCode.charAt(i) == '-'){
					sb.append(dah);
				}
			}
			sb.append(spilt);
		}
		if(sb.charAt(sb.length() - 1) == spilt){
			sb.deleteCharAt(sb.length() - 1);
		}
		return sb.toString();
	}
	
	private String decode(String s, char dit, char dah, char spilt, boolean insertSpace){
		if(s.isEmpty()){
			return "";
		}
		String[] customCodes = s.split(String.valueOf(spilt));
		StringBuilder defaultCode = new StringBuilder();
		StringBuilder sb = new StringBuilder();
		for(String code : customCodes){
			for(char c : code.toCharArray()){
				if(c == dit){
					defaultCode.append(".");
				}else if(c == dah){
					defaultCode.append("-");
				}else{
					break;
				}
			}
			Character c;
			if(Objects.equals((c = getKey(codes, defaultCode.toString())), null)){
				sb.append("<unknown : ").append(code).append(">");
			}else{
				sb.append(c);
			}
			if(insertSpace){
				sb.append(" ");
			}
			defaultCode = new StringBuilder();
		}
		if(insertSpace){
			sb.deleteCharAt(sb.length() - 1);
		}
		return sb.toString();
	}
}
