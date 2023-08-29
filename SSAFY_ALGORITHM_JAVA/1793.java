package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BOJ_1793 {
	static BigInteger dp[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		dp = new BigInteger[251];
		
		dp[0]= new BigInteger("1"); // N이 0부터니까 0도 하나의 경우로 본다!!!!!!
		dp[1]= new BigInteger("1");
		dp[2]= new BigInteger("3");
		
		for(int i=3; i<=250; i++) {
			dp[i]=dp[i-1].add(dp[i-2].multiply(new BigInteger("2")));
		}
		
		String str=null;
		while((str=br.readLine())!=null) {
			int N=Integer.parseInt(str);
			System.out.println(dp[N]);
		}

	}
}
