import java.util.*;

public class ChangeLettersOrder{
    
    static final Order alphabet = new Order("alphabet",
                                            new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19,
                                                      20, 21, 22, 23, 24, 25, 26});
    static final Order keyboard = new Order("keyboard",
                                            new int[]{11, 24, 22, 13, 3, 14, 15, 16, 8, 17, 18, 19, 26, 25, 9, 10, 1, 4,
                                                      12, 5, 7, 23, 2, 21, 6, 20});
    static final Order reversed = new Order("reversed",
                                            new int[]{26, 25, 24, 23, 22, 21, 20, 19, 18, 17, 16, 15, 14, 13, 12, 11,
                                                      10, 9, 8, 7, 6, 5, 4, 3, 2, 1});
    static Map<Integer, Order> map = new TreeMap<>();
    static{
        map.put(1, alphabet);
        map.put(2, keyboard);
        map.put(3, reversed);
    }
    
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter the string whose order you want to change:");
        String str = s.next();
        if(str.length() != 26){
            return;
        }
        System.out.println("Please choose the \"from order\" and the \"to order\"(like: 12)");
        for(int i = 1; i <= map.size(); i++){
            Order o = map.get(i);
            System.out.printf("[%d]:%s\n", i, o.getName());
        }
        int orders = s.nextInt();
        int from = orders / 10;
        int to = orders % 10;
        Order fromOrder = map.get(from);
        Order toOrder = map.get(to);
        System.out.println(change(str, fromOrder, toOrder));
    }
    
    protected static String change(String s, Order fromO, Order toO){
        if(s == null || fromO == null || toO == null){
            return null;
        }
        if("".equals(s)){
            return "";
        }
        if(fromO.equals(toO)){
            return s;
        }
        StringBuilder sb = new StringBuilder(s);
        int[] fromIndexes = fromO.getIndexes();
        int[] toIndexes = toO.getIndexes();
        for(int i = 0; i <= 25; i++){
            sb.setCharAt(toIndexes[i] - 1, s.charAt(fromIndexes[i] - 1));
        }
        return sb.toString();
    }
    
    protected record Order(String name, int[] indexes){
        
        public String getName(){
            return this.name;
        }
        
        public int[] getIndexes(){
            return this.indexes;
        }
    }
}
