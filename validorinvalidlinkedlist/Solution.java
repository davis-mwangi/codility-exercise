package validorinvalidlinkedlist;

import java.lang.reflect.Array;
import java.util.*;

/*
https://leetcode.com/discuss/interview-question/4627907/Microsoft-Screening-Question-(Software-Engineering-II)

A=10,  15,  20,  25
B= 1,  2,   3,   -1
   0   1    2     3

 */


public class Solution {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{10, 15,20, 25}, new int[]{1,2,3,-1}, 6));
    }

    public static String solution(int[] A, int [] B, int Z) {
        //Create and adjacency list
        int n = A.length;
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for(int  i = 0; i < n; i++){
            if(!adj.containsKey(i)){
                adj.put(i, new ArrayList<>());
            }
            int next = B[i];
            if(next != -1) {
                adj.get(i).add(new int[]{A[next], next});
            }else{
                adj.get(i).add(new int[]{Integer.MAX_VALUE, -1});
            }
        }
        for(int key : adj.keySet()){
            System.out.println(key +"  ==> " + Arrays.toString(adj.get(key).get(0)));
        }

        int[] inDegree =  new int[n]; //The last index will hold the  nodes with tails
        int multipleTails = 0;
        for(int node : adj.keySet()){
            for(int[] it : adj.get(node)){
                if(it[1]== -1 ){//points to tails, put in last node
                    multipleTails++;
                }else{
                    inDegree[it[1]]++;
                }
            }
        }
        System.out.println(Arrays.toString(inDegree));
        System.out.println(multipleTails);
        //Check if there are more than one values pointing to -1, that means there are multiple tails

        //check for multiple heads
        int multipleHeads = 0;
        for (int j : inDegree) {
            if (j == 0) {
                multipleHeads += 1;
            }
        }
        System.out.println(multipleHeads);
        if(multipleHeads > 1){
            return "INVALID";
        }

        if(multipleTails > 1){
            return "INVALID";
        }


        return "VALID";

    }
}
