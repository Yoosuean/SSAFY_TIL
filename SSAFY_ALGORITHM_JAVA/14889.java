import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	static int N;
	static int data[][];
	static int res;
	static int min=Integer.MAX_VALUE;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		data=new int[N][N];
		visited=new boolean[N];
		
		// 배열받기
		for(int i=0; i<N; i++) {
			String[] str = br.readLine().split(" ");
			for(int j=0; j<N; j++) {
				data[i][j]=Integer.parseInt(str[j]);
			}
		}
		
		dfs(0,0);
		System.out.println(min);

	}
	
	public static void dfs(int s, int depth) {
		if(depth==N/2) {
			min=Math.min(min,compare());
			return;
		}
		for (int i=s; i<N; i++) {
			if(!visited[i]) {
				visited[i]=true;
				dfs(i+1,depth+1);
				visited[i]=false;
				
			}
			
		}
		
	}
	
	public static int compare() {
		int startSum=0;
		int linkSum=0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				//스타트
				if(visited[i]&&visited[j]) {
					startSum+=data[i][j];
				}
				//링크 
				if(!visited[i]&&!visited[j]) {
					linkSum+=data[i][j];
				}
				
			}
		}
		return Math.abs(startSum-linkSum);
	}
	
}
