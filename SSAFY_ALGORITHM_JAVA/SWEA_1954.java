package swea_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1954 {
	static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	static int N,T;
	static int[][] map;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		T=Integer.parseInt(br.readLine());
		
		/** 달팽이 모양으로 배열 입력 */
		for(int tc=0; tc<T; tc++ ) {
			N=Integer.parseInt(br.readLine());
			map=new int[N][N];
			snail();
			/** 출력 */
			System.out.println("#"+(tc+1));
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					System.out.print(map[i][j]+" ");
				}
				System.out.println();
			}
		}

	}
	
    private static void snail() {
    	// 방문체크
    	boolean[][] visited= new boolean [N][N];
    	int num=1;
        int [][] deltas = {{0, 1},{1, 0},{0, -1},{-1, 0}};
        for(int d=0, r=0, c=-1;;) {
        	int nr = r + deltas[d][0];
            int nc = c + deltas[d][1];
            if(!isIn(nr, nc) || visited[nr][nc]) {
            	d = (d+1)%4;
            	continue;
            	}else {
            		map[nr][nc]=num;
            		visited[nr][nc]=true;
                   r = nr;
                   c = nc;
                   num++;
                   if((num-1)==N*N) {
                       break;
                   }
               }
           }
         
       }
    
    private static boolean isIn(int r, int c) {
        return 0<=r && r<N && 0<=c && c<N;
    }

}
