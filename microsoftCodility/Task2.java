package microsoftCodility;

public class Task2 {


    public static void main(String[] args) {
        System.out.println(solution(new int[]{3,4,6}, new int[]{6,5,4}));
        System.out.println(solution(new int[]{1, 2, 1,1,1,4}, new int[]{1,1,1,3,1,1}));
    }
    static int[] min = new int[1];
    public static  int solution(int[] A, int [] B){

        int [][] C = new int[2][A.length];

        for(int i =0; i < A.length; i++){
            C[0][i] = A[i];
            C[1][i] = B[1];
        }
        min[0] = C[1][A.length-1];

        dfs(C, 1, A.length -1);

        return min[0];
    }

    private static void dfs(int[][]C, int row, int col){

        if(row == 0 && col == 0){
            //We compare last value with current min
            min[0] = Math.max( C[row][col], min[0]);
            return;
        }

        // Check Base Cases
        if(row < 0 || col < 0 || row >= C.length  || col > C[0].length ){
            // return  a small number not to be considered
            return;
        }

        int left = (col- 1)  < 0 ? (int) Math.pow(10,9) : C[row][col-1];
        int up =   (row -1 ) < 0 ? (int) Math.pow(10,9) : C[row-1][col];

        System.out.println("left:: "+ left +" up:: "+ up);

        min[0] = Math.max(min[0], Math.min(left, up));

        if(left < up){
            dfs(C, row, col -1);
        }else{
            dfs(C, row -1, col);
        }
    }
}
