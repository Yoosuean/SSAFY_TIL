import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1149 {
	static int N;
	static int[][] rgb;
	static int res;

	private static void dp() {
		for(int i =1; i<N; i++) {
			rgb[i][0]=Math.min(rgb[i-1][1],rgb[i-1][2])+rgb[i][0];
			rgb[i][1]=Math.min(rgb[i-1][0], rgb[i-1][2]) + rgb[i][1];
			rgb[i][2]=Math.min(rgb[i-1][0], rgb[i-1][1])+rgb[i][2];
		}
	}
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		
		rgb= new int[N][3];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<3; j++) {
				rgb[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		res=Integer.MAX_VALUE;
		dp();
		
		for(int i=0; i<3; i++) {
			res=Math.min(rgb[N-1][i],res);
		}
		System.out.println(res);
	}

}
