import java.lang.Math;
import java.util.*;

public class MostPopularNumber {
    public static void main(String args[]) {
        String word = new String("abccfg");
        
        int[] arr = {34, 31, 34, 77, 82};

        mostPopularNumber(arr, 5);
    }
    
    public static void mostPopularNumber(int[] arr, int size) {
        Hashtable<Integer, Integer> ht = new Hashtable<Integer, Integer>();
        
        for(int i = 0; i < arr.length; i++) {
            if(ht.containsKey(arr[i])) {
                ht.put(arr[i], ht.get(arr[i]) + 1);
            } else {
                ht.put(arr[i], 1);
            }
        }
        
        int mostOcurrences = 0;
        int mostOcurrencesKey = 0;
        for(Map.Entry m: ht.entrySet()) {
            System.out.println( m.getKey() + " : " + m.getValue() );
            if((int)m.getValue() > mostOcurrences) {
                mostOcurrences = (int)m.getValue();
                mostOcurrencesKey = (int)m.getKey();
            }
        }
        
        System.out.println(ht.get(mostOcurrencesKey));
    }
}
