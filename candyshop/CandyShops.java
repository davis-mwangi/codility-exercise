package candyshop;
import java.util.*;

public class CandyShops{
    public int solution (int[] A, int[] B){
        //Put the two arrays in a set to get rid off duplicates
        Set<Integer>setA = new HashSet<>();
        Set<Integer>setB = new HashSet<>();

        for(int num: A){
            setA.add(num);
        }
        for(int num: B){
            setB.add(num);
        }
        //Since we want maximun, we count the  size of the two sets,
        // then take the minimum count of the two, then multiply by 2 
        int uniqueA = setA.size();
        int uniqueB =  setB.size();

        int minCountUnique = Math.min(uniqueA, uniqueB);

        return minCountUnique *  2;
    }
     
}