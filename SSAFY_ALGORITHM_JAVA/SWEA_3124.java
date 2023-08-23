package swea_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SWEA_3124 {
	static ArrayList<Edge>[] graph;
	static long total=0;
	static int cnt=0;

	static class Edge implements Comparable<Edge> {
		int node; // 간선 들어오는 정점
		int cost; // 간선 가중치

		public Edge(int node, int cost) {
			this.node = node;
			this.cost = cost;
		}

		// 간선 오름차순 정렬
		@Override
		public int compareTo(Edge o) {
			return this.cost - o.cost;
		}
	}

	
	// 프림 알고리즘
	public static void prim(int start, int v) {
		boolean[] visit = new boolean[v+1];

		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(start, 0));

		total = 0;
		cnt=0;
		while (!pq.isEmpty()) {
			Edge edge = pq.poll();
			
			// 방문했다면 continue;
			if(visit[edge.node]) continue;
			
			visit[edge.node]=true;
			
			// 가중치 누적합
			total+=edge.cost;
			
			// 모든 정점을 순회하면 탈출
			if(++cnt==v) break;
			
			// 그래프에 연결된 노드를 돌면서 방문하지 않았다면 pq에 넣어줌
			for(int i=0; i<graph[edge.node].size(); i++) {
				Edge next = graph[edge.node].get(i);
				if(visit[next.node]) continue;
				pq.add(next);
			}
		}
		
	}

	public static void main(String[] args) throws IOException {
		// 그래프 입력, 저장
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());


			// 그래프 선언, 간선리스트로 표현
			graph = new ArrayList[V+1];
			for (int i = 0; i <= V; i++)
				graph[i] = new ArrayList<>();

			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());

				graph[A].add(new Edge(B,cost));
				graph[B].add(new Edge(A,cost));
			}
			prim(1, V);
			System.out.println("#" + tc + " " + total);
		}
	}

}
