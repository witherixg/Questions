import java.util.*;


public class MatchDivide{
	
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		int num = 0;
		while(num < 1){
			num = s.nextInt();
		}
		for(int i = 1; i < num; i++){
			if((getMatchCountOfNumber(num)-getMatchCountOfNumber(i) == ((double)num/i))){
				System.out.printf("%d/%d=%d\n", num, i, num/i);
			}
		}
		//test
		/*int num = 0;
		Scanner s = new Scanner(System.in);
		while(true){
			num = s.nextInt();
			System.out.println(getMatchCountOfNumber(num));
			System.out.println(getEachNum(num));
		}*/
	}
	
	public static int sum(List<Integer> list){
		int ret = 0;
		for(int i : list){
			ret += i;
		}
		return ret;
	}
	
	public static int getMatchCountOfNumber(int n){
		List<Integer> nums = getEachNum(n);
		List<Integer> list = new ArrayList<>();
		final Map<Integer, Integer> map = new HashMap<>();
		map.put(0, 6);
		map.put(1, 2);
		map.put(2, 5);
		map.put(3, 5);
		map.put(4, 4);
		map.put(5, 5);
		map.put(6, 6);
		map.put(7, 3);
		map.put(8, 7);
		map.put(9, 6);
		for(int i : nums){
			list.add(map.get(i));
		}
		int ret = 0;
		for(int i : list){
			ret += i;
		}
		return ret;
	}
	
	public static List<Integer> getEachNum(int n){
		n = Math.abs(n);
		String str = String.valueOf(n);
		int len = str.length();
		List<Integer> list = new ArrayList<>();
		char[] chars = str.toCharArray();
		for(int i = 0; i < len; i++){
			list.add(chars[i] - '0');
		}
		return list;
	}
}
