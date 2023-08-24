package swea_algorithm;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 간선클래스
class Edge implements Comparable<Edge> {
	int from, to; 
	long dis; // 가중치

	public Edge(int from, int to, long dis) {
		this.from = from;
		this.to = to;
		this.dis = dis;
	}

	@Override
	public int compareTo(Edge o) { // 가중치 기준 오름차순 정렬
		return Long.compare(this.dis, o.dis);
	}
}

public class SWEA_1251 {

	static BufferedReader br;
	static StringTokenizer st;
	static int N; // 섬의 수
	static double E; // 환경 부담 세율
	static Point[] coordinate; // 섬의 좌표
	static int[] parent; // 유니온파인드 사용시 최상위 노드
	static PriorityQueue<Edge> queue; // 간선 정보 가중치 기준 오름차순 정렬

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb= new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		//구현
		for (int tc = 1; tc <= T; tc++) {
			input();
			sb.append("#").append(tc).append(" ").append(kruskal()).append("\n");
		}
		
		//출력
		System.out.println(sb);

	}

	/** 입력 */
	private static void input() throws IOException {
		N = Integer.parseInt(br.readLine());
		coordinate = new Point[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) { // 섬의 x 좌표
			int temp = Integer.parseInt(st.nextToken());
			coordinate[i] = new Point(temp, 0);
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) { /// 섬의 y 좌표
			coordinate[i].y = Integer.parseInt(st.nextToken());
		}

		E = Double.parseDouble(br.readLine());

	}

	
	/** 크루스칼 알고리즘*/
	private static long kruskal() {
		queue = new PriorityQueue<>(); // 우선순위 큐 생성
		for(int i=0; i<N; i++) {
			for(int j=i+1; j<N; j++) { // 두 좌표사이의 거리를 계산해준 후 우선순위 큐에 삽입(우선순위 큐는 가중치 순으로 오름차순 정렬)
				int disX=Math.abs(coordinate[i].x-coordinate[j].x);
				int disY=Math.abs(coordinate[i].y-coordinate[j].y);
				queue.add(new Edge(i,j,getCost(disX,disY)));
			}
		}
		
		make(); // 서로소 집합 생성 
		
		int cnt=0;
		long sum=0;
		
		while(!queue.isEmpty()) {
			Edge curEdge=queue.poll();
			if(union(curEdge.from,curEdge.to)) { // 부분집합이 아니라면 집합을 합침
				sum+=curEdge.dis; // 거리 누적
				if(++cnt==N-1) break;
			}
		}
		
		return Math.round(sum*E); // 환경부담금 계산
	}

	
	/** 거리(가중치) 계산 함수*/
	private static long getCost(long disX, long disY) {
		return disX * disX + disY * disY;
	}

	

	/** 유니온파인드 */
	private static void make() {
		parent = new int[N];
		for (int i = 0; i < N; i++) {
			parent[i] = i;
		}
	}
	
	private static int find(int a) {
		if(a==parent[a]) return a;
		return parent[a]=find(parent[a]);
	}
	
	private static boolean union(int a, int b) {
		int aRoot=find(a);
		int bRoot=find(b);
		if(aRoot==bRoot) return false;
		parent[bRoot] =aRoot;
		return true;
	}

}
