package swea_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_2001 {
	static int max;
	static int[][] map;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		/** 입력 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T= Integer.parseInt(br.readLine());
		
		for(int tc=0; tc<T; tc++) {
			String[] input=br.readLine().split(" ");
			int N=Integer.parseInt(input[0]);
			int M=Integer.parseInt(input[1]);
			max=Integer.MIN_VALUE;
			map=new int[N][N];
			// 배열 생성
			for(int i=0; i<N; i++) {
				input=br.readLine().split(" ");
				for(int j=0; j<N; j++) {
					map[i][j]=Integer.parseInt(input[j]);
				}
			}
	
			
			/** 구현 */
			// 파리 잡는 함수
			getFly(N,M);
			
			
			/** 출력 */
			System.out.println("#"+(tc+1)+" "+max);
		
		}		
	}
	
	private static void getFly(int n, int m) {
		for(int i=0; i<n-m+1; i++) {
			for(int j=0; j<n-m+1; j++) {
				int sum=0;
				for(int x=0; x<m; x++) {
					for (int y=0; y<m; y++) {
						sum+=map[i+x][j+y];
					}
				}
				max=Math.max(max, sum);
			}	
		}
	}
	

}
