import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_1260 {
	static int N;
	static int[][] graph=new int[1001][1001];
	static boolean[] visited= new boolean[1001];
	
	public static void dfs(int s) {
		visited[s]=true;
		System.out.print(s+" ");
		
		if(s==graph.length) return;
		for(int i=1; i<=N; i++) {
			if(graph[s][i]==1&&visited[i]==false) dfs(i);
		}
	}
	

	
	public static void bfs(int s) {
		LinkedList<Integer> q=new LinkedList<Integer>();
		q.offer(s);
		visited[s]=true;
		System.out.print(s+" ");
		
		while(!q.isEmpty()) {
			int tmp=q.poll();
			
			for(int i=1; i<graph.length; i++) {
				if(graph[tmp][i]==1&&visited[i]==false) {
					q.offer(i);
					visited[i]=true;
					System.out.print(i+" ");
				}
			}
		}
		
		
		
	}

	public static void main(String[] args) throws IOException {
		/** 입력 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		int V=Integer.parseInt(st.nextToken());
		
		for(int i=0; i<M; i++) {
			st=new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			// 연결된 노드를 1로 설정
			graph[a][b]=graph[b][a]=1; 
		}
		
		/** 구현 */
		dfs(V);
		// visited 배열초기화
		Arrays.fill(visited, false);
		System.out.println();
		bfs(V);
		

	}

}
