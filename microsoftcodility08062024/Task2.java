package microsoftcodility08062024;

public class Task2 {
    public static void main(String[] args) {
        System.out.println("7 => " + solution(10, 21)); //Expected 7
        System.out.println("5 => " +solution(13, 11)); //Expected 5
        System.out.println("2 => " +solution(1, 8)); //Expected  2
        System.out.println("0 => " +solution(2, 1)); //Expected  0

    }
    //Time Complexity : O( (A+B) / 4)
    //Space Complexity : O(1)
    public static int solution (int A, int B){
        int left = 1;
        int right = (A+B)/ 4;
        int res = 0;
        while(left <= right){
            int mid = (right + left) / 2;
            if(canFormSquare(mid,A, B)){
                left =  mid + 1;
                res = mid;
            }else{
                right = mid  - 1;
            }
        }
        return res;
    }
    public static int solution1 (int A, int B){
        for(int len = (A+B)/ 4; len > 0; len--){
            if(canFormSquare(len, A, B)){
                return len;
            }
        }
        return 0;
    }
    private static boolean canFormSquare(int cutLength, int A, int B){
        int sticks = (A/cutLength) + (B / cutLength);
        if(sticks >= 4){
            return  true;
        }
        return  false;
    }
}
