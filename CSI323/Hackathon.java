
public class Hackathon{
    public static void main(String[] args){
        String pal = convertPal("abcd");
    }
    public static String convertPal(String s, int i){
        if(i<s.length()){
            if(s.equals(new StringBuilder(str).reverse().toString())){
                return str;
            }
            else{
                return s.charAt(i) + convertPal(str, i + 1);
            }
        }
    }
}