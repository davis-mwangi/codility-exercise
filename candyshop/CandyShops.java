package candyshop;

import java.util.*;
/*
QUESTION : https://www.reddit.com/r/leetcode/comments/1b1bol4/candy_shops_coins_hard_greedy_apple/
SIMILAR LEETCODE QUSN: https://leetcode.com/problems/maximum-size-of-a-set-after-removals/solutions/4520894/java-solution-using-hashset/

A viable solution: https://www.youtube.com/watch?v=hHBAZrr7nPs

[1,2,3,4]  gold = n / 2
[3,3,3,7]  silver = n / 2


 */
public class CandyShops {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3, 4}, new int[]{3, 3, 3, 7}));
        System.out.println(solution(new int[]{7, 4, 2, 5, 1, 2}, new int[]{2, 2, 2, 2, 2, 2}));
    }

    public static int solution(int[] A, int[] B) {
        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();
        Set<Integer> setC = new HashSet<>();

        for (int num : A) {
            setA.add(num);
            setC.add(num);
        }

        for (int num : B) {
            setB.add(num);
            setC.add(num);
        }

        //Maximum we can get ,and we cannot go past N / 2
        int maxNums1 = Math.min(setA.size() , A.length / 2);

        //Maximum we can get, we cannot go past n/2 even if we have unique candies
        int maxNums2 = Math.min( setB.size(), B.length / 2 );

        //Maximum we can get is (N/2) + (N/2)
        int  max = maxNums1 + maxNums2;

        // In case we have  duplicates
        // we chose unique sets over what we are entitled to have
        // A=[1,2,1,2], B=[1,1,1,1] C= [1,2]
        return Math.min(max, setC.size() );


//        return Math.min(
//                Math.min(setA.size(), A.length / 2 ) + Math.min(setB.size(), B.length / 2 ),
//                   setC.size() );
    }

}