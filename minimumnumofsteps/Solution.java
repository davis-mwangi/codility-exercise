package minimumnumofsteps;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
https://leetcode.com/discuss/interview-question/3819090/MICROSOFT-OA

There is a string S of length N consisting of lowercase English letters(the letters are numbered 1 to N)
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(solution("aabcbe", new int[]{1,3, 2})); // result 2 a$abcbe -> a$ab$cba -> a$a$b$cbe
        System.out.println(solution("aad", new int[]{1,2})); // result 2
        System.out.println(solution("aaboddcb", new int[]{2, 2, 3})); // result 3
        System.out.println(solution("wkwk", new int[]{-1})); // result -1
        System.out.println(solution("aabcddcb", new int[]{3,5,1,4,7})); // result -1


    }

    public  static int solution( String S, int[] c){
        int steps  = 2;
        StringBuilder sb =  new StringBuilder(S);
       for(int i : c){
            //Check if i is a valid index within the string S
            if(i  < 1 || i >= sb.length()){
                return  -1; //Invalid index, return -1
            }

            //Insert an '$' character at index i in string S
            sb.insert(i, '$');

           System.out.println(sb);

            //Check if, after the insertion, every two occurrences of the sames letter in S have  and '$' in between
            for(int j = 1; j < sb.length() - 1; ++j){

                //If three consecutive characters are identical, increment steps and break out of the loop
                if(sb.charAt(j) == sb.charAt( (j-1) ) &&  sb.charAt(j) == sb.charAt(j+1)){
                    steps += 1;
                    break;
                }
            }
       }
        return  steps;
    }
}
