package boj_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
	int index;
	int cost;

	public Node(int index, int cost) {
		this.index = index;
		this.cost = cost;
	}

	@Override
	public int compareTo(Node o) {
		return Integer.compare(this.cost, o.cost);
	}
}

public class BOJ_1753_PriorityQueue {
	static ArrayList<Node>[] graph;
	static int V, E, start;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		input();
		dijkstra(V, start);
		System.out.println(sb);
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();

		// 정점의 개수, 간선의 개수
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(br.readLine());

		graph = new ArrayList[V + 1];
		for (int i = 0; i <= V; i++)
			graph[i] = new ArrayList<>();

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			graph[u].add(new Node(v, w));
		}
	}

	private static void dijkstra(int n, int start) {
		boolean[] check = new boolean[n + 1];
		int[] dist = new int[n + 1];
		int INF = Integer.MAX_VALUE;

		Arrays.fill(dist, INF);
		dist[start] = 0;

		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));

		while (!pq.isEmpty()) {
			int nowVertex = pq.poll().index;

			if (check[nowVertex])
				continue;
			check[nowVertex] = true;

			// index의 연결된 정점 비교
			for (Node next : graph[nowVertex]) {
				if (dist[next.index] > dist[nowVertex] + next.cost) {
					dist[next.index] = dist[nowVertex] + next.cost;
					pq.offer(new Node(next.index, dist[next.index]));
				}
			}
		}

		for (int i = 1; i < dist.length; i++) {
			if (dist[i] == INF) {
				sb.append("INF").append("\n");
				continue;
			}
			sb.append(dist[i]).append("\n");
		}
	}
}

