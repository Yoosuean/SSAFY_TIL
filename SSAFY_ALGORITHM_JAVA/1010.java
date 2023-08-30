import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class BOJ_1010 {
	static int[][] dp;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		dp = new int[30][30]; 
		int T = Integer.parseInt(br.readLine()); 
		for(int i = 0; i < T; i++) {
			StringTokenizer st= new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
		 
				sb.append(combi(M,N)).append("\n");
			}
		System.out.println(sb);
		}
		 
		private static int combi(int n, int r) {
			if(dp[n][r]!=0) { // 탐색했을 경우
				return dp[n][r];
			}

			if(n == r || r == 0) { // nCn, nC0 
				return dp[n][r] = 1;
			}

			return dp[n][r]=combi(n - 1, r - 1) + combi(n - 1, r); // nCr= n-1Cr-1 + n-1Cr
		}
	}




//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.math.BigInteger;
//import java.util.StringTokenizer;
//
//public class Main {
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int T =Integer.parseInt(br.readLine());
//        for(int tc=0; tc<T; tc++) {
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            int N=Integer.parseInt(st.nextToken());
//            int M=Integer.parseInt(st.nextToken());
//            BigInteger temp=factorial(M-N);
//            BigInteger temp2=factorial(N).multiply(temp);
//            BigInteger res=factorial(M).divide(temp2);
//            System.out.println(res);
//        }
//    }
//
//    private static BigInteger factorial(int n) {
//        BigInteger p = new BigInteger("1");
//        for (int i=1; i<=n; i++) {
//            p = p.multiply(new BigInteger(String.valueOf(i)));
//        }
//        return p;
//    }
//
//}
