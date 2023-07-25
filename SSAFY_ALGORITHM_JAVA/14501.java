import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt();
		
		int[][] data=new int[N+1][2];
		int[] dp=new int[N+1];

		for (int i=N; i>0; i--){
			int T=sc.nextInt();
			int P=sc.nextInt();
			data[i][0]=T;
			data[i][1]=P;
		}
		
		for(int i=1; i<N+1; i++){
			if(data[i][0]>i){
				dp[i]=dp[i-1];
			} else {
				dp[i]=Math.max(dp[i-1],data[i][1]+dp[i-data[i][0]]);
			}
		}
		System.out.println(dp[N]);
	}
}
