package ibmhackerrank2024;

import java.util.ArrayList;
import java.util.List;

public class Question2 {
    /*
     Print all position of 1's in the binary of n
     print ans such that arr[0] = size of 1's
     position is 1 to k
     E.g n = 37
      [1  0  0  1  0  1 ]
       0  1  2  3  4  5

       1's => 3
       positions = [1, 4, 6]
     Output :
          3
          1
          4
          6
     */
    public static void main(String[] args) {
        List<Integer>ans = printOnes(4000);
        for(Integer x : ans){
            System.out.println(x);
        }
    }

    public static List<Integer> printOnes(int n){
        //Convert to binary
        String binary = intToBinaryString(n);
        List<Integer> positions = new ArrayList<>();
        positions.add(0);
        for(int i = 0;  i < binary.length(); i++){
            if(binary.charAt(i) == '1'){
                positions.set(0,  positions.get(0)+1);
                positions.add(i+1);
            }
        }

        return positions;
    }
    public static String intToBinaryString(int n){
        if(n == 0){
            return "0";
        }
        StringBuilder binaryStr = new StringBuilder();
        while(n > 0 ){
            binaryStr.insert(0, n % 2);
            n /= 2;
        }
        return binaryStr.toString();
    }
}
