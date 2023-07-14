import java.math.BigInteger;
import java.util.*;

public class Fibonacci{
	
	private static final TreeMap<Integer, BigInteger> values = new TreeMap<>();
	static {
		values.put(1, new BigInteger("1"));
		values.put(2, new BigInteger("1"));
	}
	public static String fibonacci(int i){
		if(values.containsKey(i)){
			return values.get(i).toString();
		}
		if(values.containsKey(i - 1)){
			values.put(i, new BigInteger(values.get(i - 1).toString())
					.add((values.get(i - 2))));
		}
		return new BigInteger(fibonacci(i - 1))
				.add(new BigInteger(fibonacci(i - 2))).toString();
	}
	
	public static void main(String[] args){
		System.out.println(fibonacci(0));
	}
}
