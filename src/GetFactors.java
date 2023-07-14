import java.util.*;

public class GetFactors{
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number: ");
		int num = sc.nextInt();
		Map<Integer, Integer> factors = getFactors(num);
		System.out.println("The factors of " + num + " are: ");
		for(Integer i: factors.keySet()){
			if(factors.get(i) == 1){
				System.out.print("" + i + ' ');
			}else{
				System.out.print("" + i + '^' + factors.get(i) + ' ');
			}
		}
	}
	
	
	public static int getLastPrimeNumber(int i){
		int j = i;
		while(!isPrime(j)){
			j--;
		}
		return j;
	}
	
	private static boolean isPrime(int j){
		if(j <= 1){
			return false;
		}
		for(int i = 2; i <= j / 2; i++){
			if(j % i == 0){
				return false;
			}
		}
		return true;
	}
	
	public static Map<Integer, Integer> getFactors(int i){
		List<Integer> factors = new ArrayList<>();
		int pointer = i;
		int j;
		while(pointer != 1){
			j = getLastPrimeNumber(pointer);
			if(i % j == 0){
				factors.add(j);
				i /= j;
			}else{
				pointer = j;
				pointer--;
			}
		}
		Map<Integer, Integer> factorsMap = new HashMap<>();
		for(Integer factor : factors){
			if(factorsMap.containsKey(factor)){
				factorsMap.put(factor, factorsMap.get(factor) + 1);
			}else{
				factorsMap.put(factor, 1);
			}
		}
		return factorsMap;
	}
}
