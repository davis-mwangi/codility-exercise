package challenge1;

public class Solution {
    public static void main(String[] args) {

    }

    int [] largest = new int[1];
    public static int solution(int[][] A ){
        int rows = A.length;
        int cols = A[0].length;

        int [][] visited = new int[rows][cols];

        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
               if(visited[r][c] == 0){

                   dfs(r, c, rows, cols, A, A[r][c]);
               }
            }
        }
        return 0;
    }

    private static  void dfs(int r, int c, int rows, int cols, int[][] A, int minVal){

    }
}
