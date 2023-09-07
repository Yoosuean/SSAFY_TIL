import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9466 {
	static int T,N,cycle,team;
	static int[] arr;
	static boolean[] visit;
	static boolean[] dfsVisit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T=Integer.parseInt(br.readLine());
		
		for(int tc=0; tc<T; tc++) {
			N=Integer.parseInt(br.readLine());
			
			arr=new int[N+1];
			visit=new boolean[N+1];
			dfsVisit=new boolean[N+1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=1; i<N+1; i++) {
				arr[i]=Integer.parseInt(st.nextToken());
			}
			
			team=0;
			cycle=-1;
			for(int i=1; i<N+1; i++) {
				if(visit[i]) continue;
				dfs(i);
			}
			
			int res=N-team;
			sb.append(res).append("\n");
		}
		
		System.out.println(sb);

	}
	private static void dfs(int x){
		if(visit[x]) return;
		
		if(dfsVisit[x]) {
			cycle=x;
			return;
		}
		
		dfsVisit[x]=true;
		dfs(arr[x]);
		
		if(cycle>-1) {
			team++;
			if(cycle==x) {
				cycle=-1;
			}
		}
		
		dfsVisit[x]=false;
		visit[x]=true;
		
	}
 
}
