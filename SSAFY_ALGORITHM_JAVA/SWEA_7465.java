package SWEA;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class SWEA_7465_창용마을무리의개수 {
	static int T,N,M;
	static int[] parents;
	static HashSet<Integer> set;
	
	private static void make() {
		parents= new int[N];
		for(int i=0; i<N; i++) {
			parents[i]=i;
		}
	}
	
	private static int find(int x) {
		if(parents[x]==x) return x;
		return parents[x]=find(parents[x]);
	}
	
	private static void union(int a, int b) {
		int aRoot=find(a);
		int bRoot=find(b);
		
		if(aRoot==bRoot) {
			return;
		}
		
		parents[aRoot]=bRoot;
		
		
	}
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			make();
			
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				int a=Integer.parseInt(st.nextToken())-1;
				int b=Integer.parseInt(st.nextToken())-1;
				union(a,b);
			}
			
			set= new HashSet<Integer>();
			for(int i=0; i<N; i++) {
				set.add(find(i));	
			}
			
			System.out.println("#"+t+" "+set.size());
			
		}
		

	}
}
