package swea_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_2805 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static int res;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T=Integer.parseInt(in.readLine());
		
		for(int tc=0; tc<T; tc++) {
			N=Integer.parseInt(in.readLine());
			res=0;
			
			// 배열 입력받기
			int arr[][]=new int[N][N];
			for(int i=0; i<N; i++) {
				String[] str=in.readLine().split("");
				for(int j=0; j<N; j++) {
					arr[i][j]=Integer.parseInt(str[j]);
				}	
			}
			
			// 수확할 농작물 계산
			getCost(arr);

			// 결과 값 출력
			System.out.println("#"+(tc+1)+" "+res);
		}
	}
	
	private static void getCost(int arr[][]) {
		// 농장의 중앙 값
		int tmp=N/2;
		// 시작 값 s, 종료 값 e
		int s=tmp;
		int e=tmp+1;
		
		// N이 1일 때
		if (N==1) {
			res+=arr[0][0];
			return;
		}
		
		// 마름모 내의 수확물 계산
		for(int i=0; i<N; i++) {
			for(int j=s; j<e; j++) {
				res+=arr[i][j];
			}
	
			// 중앙 값을 넘어서면 계산할 농작물의 구간이 줄어듬
			if(i<tmp) {
				s--;
				e++;
			} else {
				s++;
				e--;
			}
		}
	}
}
