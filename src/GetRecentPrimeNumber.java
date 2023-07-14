public class GetRecentPrimeNumber{
	public static int getRecentPrimeNumber(int i){
		int j = i;
		while(!isPrime(j)){
			j++;
		}
		return j;
	}
	
	private static boolean isPrime(int j){
		for(int i = 2; i <= j / 2; i++){
			if(j % i == 0){
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args){
		System.out.println(getRecentPrimeNumber(1000000000));
	}
}
