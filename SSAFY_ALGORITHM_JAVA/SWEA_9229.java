package swea_algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_9229 {
	static int[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tcNum = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=tcNum; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N=Integer.parseInt(st.nextToken());
			int M=Integer.parseInt(st.nextToken());
			
			st=new StringTokenizer(br.readLine());
			arr = new int[N];
			for(int i=0; i<N; i++) {
				arr[i]=Integer.parseInt(st.nextToken());
			}
			
			int max = -1;
			
			for(int i=0; i<N-1; i++) {
				for(int j=i+1; j<N; j++) {
					int sum=0;
					sum+=arr[i]+arr[j];			
					if(sum<=M) {
						max=Math.max(max, sum);
					}
				}
			}
			
			System.out.println("#"+tc+" "+max);
		}
	}

}
