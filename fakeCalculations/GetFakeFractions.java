import java.util.*;

public class GetFakeFractions{
	
	public static int NUM1 = 1;
	public static int NUM2 = 2;
	
	public static void main(String[] args){
		System.out.println("Enter an area: ");
		Scanner sc = new Scanner(System.in);
		int area = sc.nextInt();
		getFakeFractions(area);
	}
	
	public static void getFakeFractions(int area){
		for(int i = 1; i <= area; i++){
			//check if i and doubled i are the same(except for the order of the characters)
			if(isSame(Integer.toString(i), Integer.toString(i * 2))){
				System.out.println(i + "/" + i * 2 + " = " + NUM1 + "/" + NUM2 + " is a fake true fraction.");
			}
		}
	}
	
	//check if 2 strings are the same(except for the order of the characters)
	public static boolean isSame(String s1, String s2){
		if(s1.length() != s2.length()){
			return false;
		}else{
			ArrayList<Character> chars1 = charArrayToList(s1.toCharArray());
			ArrayList<Character> chars2 = charArrayToList(s2.toCharArray());
			Collections.sort(chars1);
			Collections.sort(chars2);
			for(int i = 0; i < chars1.size(); i++){
				if(Objects.equals(String.valueOf(chars1.get(i)), String.valueOf(NUM1))){
					chars1.remove(i);
					break;
				}
			}
			for(int i = 0; i < chars2.size(); i++){
				if(Objects.equals(String.valueOf(chars2.get(i)), String.valueOf(NUM2))){
					chars2.remove(i);
					break;
				}
			}
			return chars1.toString().equals(chars2.toString());
		}
	}
	
	//char array to list
	public static ArrayList<Character> charArrayToList(char[] chars){
		ArrayList<Character> list = new ArrayList<>();
		for(char c : chars){
			list.add(c);
		}
		return list;
	}
}
