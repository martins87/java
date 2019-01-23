import java.lang.Math;

public class IsAlmostPalindrome {
    public static void main(String args[]) {
        String word = new String("abccfg");

        System.out.println(isAlmostPalindrome(word));
    }
    
    public static boolean isAlmostPalindrome(String word) {
        int differentLetters = 0;
        for(int i = 0; i < word.length()/2; i++) {
            if(word.charAt(i) != word.charAt(word.length() - i - 1)) {
                differentLetters++;
            }
            if(differentLetters >= 2) {
                return false;
            }
        }
        
        return true;
    }
}
