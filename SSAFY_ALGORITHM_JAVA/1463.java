
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_!463 {
	static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int X=Integer.parseInt(br.readLine());
		dp= new int[X+1];
		for(int i=2; i<X+1; i++) {
			dp[i]=dp[i-1]+1;
			if(i%3==0) { // X가 3으로 나누어지는 경우
				dp[i]=Math.min(dp[i], dp[i/3]+1);
			}
			if(i%2==0) { // X가 2으로 나누어지는 경우
				dp[i]=Math.min(dp[i], dp[i/2]+1);
			}
		}
		System.out.println(dp[X]);
	}

}
