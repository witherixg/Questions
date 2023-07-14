public class Daffodil{
	// 135
	// 1 3 5
	// 1^3 +^3  3+ 5^3 = 135
	public static void daffodil(){
		int d1;
		int d2;
		int d3;
		for(int i = 100; i <= 999; i++){
			d1 = i % 10;
			d2 = (i / 10) % 10;
			d3 = (i / 100) % 10;
			if(Math.pow(d1, 3) + Math.pow(d2, 3) + Math.pow(d3, 3) == i){
				System.out.println(i);
			}
		}
	}
	public static void main(String[] args) {
		daffodil();
	}
}
