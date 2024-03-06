package balancedboard;

import java.util.HashMap;
import java.util.Map;

/*
? R W ? W R
? W R ? R W

row1=W ? W R ?
row2=R ? ? W R

R R ?
? R ?

Algorithm:
 get char and its frequency row 1 {W:2, R:1 ,?: 2 }
                            row 2 {W:1, R:1, ?: 3}

*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(solution("W?WR?","R??W?")); //result 3 => W?WRR == R?RWW
//        System.out.println(solution("R?R??","??W??"));// result 5 r1= R?RWW, r2= W?WRR
//        System.out.println(solution("RR?","?R?"));// result -1
//        System.out.println(solution("WWW??","RRR??"));// result -1
//        System.out.println(solution("?RW?WR","?WR?RW"));// result 0

    }
    public static int solution(String row1, String row2){
       int replacements = 0;
       int n = row1.length();
       StringBuilder sb1 = new StringBuilder(row1);
       StringBuilder sb2 = new StringBuilder(row2);

       Map<Character,Integer>map1 = new HashMap<>();
       Map<Character,Integer>map2 = new HashMap<>();

       //Match the columns and obtains replacements needed.
       for(int i = 0; i < n; i++){
           //Case when row 1 has ? and row has W or R
           if(sb1.charAt(i) == '?' && sb2.charAt(i) != '?'){
               replacements += 1;
               sb1.setCharAt(i, (sb2.charAt(i) == 'R' ? 'W' : 'R')) ;
           }else if(sb2.charAt(i) == '?' && sb1.charAt(i) != '?'){
               replacements +=  1;
               sb2.setCharAt(i, (sb1.charAt(i) == 'R' ? 'W' : 'R'));
           }else if(row1.charAt(i) != '?' && row1.charAt(i) == row2.charAt(i)){//If we get RW and RW then no match
               return  -1;
           }
           map1.put(sb1.charAt(i), map1.getOrDefault(sb1.charAt(i), 0) + 1);
           map2.put(sb2.charAt(i), map2.getOrDefault(sb2.charAt(i), 0) + 1);
       }

        System.out.println(sb1);
        System.out.println(sb2);
        System.out.println("******************");
        System.out.println(map1);
        System.out.println(map2);

       //Replacements require
        int movesNeededInRow1 = Math.abs(map1.getOrDefault('W',0) - map1.getOrDefault('R',0));
        int movesNeededInRow2 = Math.abs(map2.getOrDefault('W',0) - map2.getOrDefault('R',0));

        //Try make ro number of W == number of R
        if(movesNeededInRow1 > map1.getOrDefault('?',0) &&  movesNeededInRow1 > 0 ||
            movesNeededInRow2  > map2.getOrDefault('?',0) && movesNeededInRow2 > 0){
            return  -1;
        } else {
           int absDiff = map1.getOrDefault('R',0) - map2.getOrDefault('R',0);
           replacements +=  2 * absDiff;
        }
        return replacements;
    }
}
