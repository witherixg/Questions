import java.math.BigInteger;

public class Factorial{
	
	public static String factorial(long num){
		String value = String.valueOf(num);
		BigInteger i = new BigInteger(value);
		if(i.equals(new BigInteger("1"))){
			return "1";
		}else{
			return i.multiply(new BigInteger(factorial(i.subtract(new BigInteger("1")).longValue()))).toString();
		}
	}
	public static void main(String[] args){
		System.out.println(factorial(0));
	}
}
