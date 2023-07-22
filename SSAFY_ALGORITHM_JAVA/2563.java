package SSAFY_ALGORITHM_JAVA;
import java.util.*;

class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] board = new int[100][100];

        int cnt=0;
        for (int i=0; i<N; i++){
            int X=sc.nextInt();
            int Y=sc.nextInt();

            for (int j=X; j<X+10; j++){
                for (int k=Y; k<Y+10; k++){
                    board[j][k]=1;
                }
            }
        }

        for (int i=0; i<100; i++){
            for (int j=0; j<100; j++){
                if(board[i][j]==1) cnt++;
            }
        }

    }
}
