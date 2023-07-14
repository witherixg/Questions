import java.util.*;

public class CompareStringInCharacters{
    
    public static void main(String[] args){
        while(true){
            Scanner s = new Scanner(System.in);
            String prompt = "Please input the %s string\n";
            System.out.printf(prompt, "first");
            String s1 = s.nextLine();
            System.out.printf(prompt, "second");
            String s2 = s.nextLine(); 
            handleCompare(s1, s2);
        }
    }
    
    private static char[] getComparedCharactersArray(String s){
        if(s == null){
            return null;
        }
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return chars;
    }
    
    private static char[] gCChA(String s){
        return getComparedCharactersArray(s);
    }
    
    private static void handleCompare(String s1,String s2){
        if(s1 == null || s2 == null){
            System.out.println("What the fuck did you type?");
            return;
        }
        if(s1.equals(s2)){
            System.out.println("They are the same in characters!");
        }else if(Arrays.equals(gCChA(s1), gCChA(s2))){
            System.out.println("They are the same in characters!");
        }else{
            System.out.println("Something is different.");
        }
    }
}
