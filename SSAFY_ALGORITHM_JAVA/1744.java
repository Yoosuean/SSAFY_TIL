package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1744 {
	static int N, res, cnt;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		res=0;
		
		
		// 양수묶기 
		positive();
		
		// 음수묶기
		negative();

		System.out.println(res);
		
	}
	
	private static void positive() {
		cnt=N-1;
		while(cnt>=0) {
			
			// 음수일 때
			if(arr[cnt]<1) {
				N=cnt+1;
				return;
			}
			
			// N이 1일 때
			if(N==1) {
				res+=arr[0];
				return;
			}
			
			// 마지막 수일 때
			if(cnt==0) {
				res+=arr[cnt];
				N=0;
				return;
			}
			
			if(arr[cnt]==1||arr[cnt-1]==1) {
				res+=arr[cnt]; 
				cnt--;
				continue;
			}
			
			if(arr[cnt-1]<1) {
				res+=arr[cnt];
				cnt--;
				continue;
			}
			
			res+=arr[cnt]*arr[cnt-1];
			cnt-=2;
			

			if(cnt<=0) N=0;

		}

		
	}

	
	private static void negative() {
		cnt=0;
		while(cnt<N) {
			// N이 1일 때
			if(N==1) {
				res+=arr[0];
				return;
			}
			
			// 마지막 수일 때
			if(cnt==N-1) {
				res+=arr[cnt];
				return;
			}
			
			
			res+=arr[cnt]*arr[cnt+1];
			cnt+=2;
		}
	}
}
