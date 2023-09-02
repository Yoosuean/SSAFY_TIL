import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

import java.util.StringTokenizer;

public class BOJ_2146 {
	
	static class Point{
		int x;
		int y;
		int cost;
		public Point(int x, int y, int cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}
	}
	
	
	static int N, result;
	static int[][] map;
	static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 } };
	static boolean[][] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		result=Integer.MAX_VALUE;

		map = new int[N][N];
		visit = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int cnt = 2;
		// 섬 영역나누기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1) {
					divIsland(i, j, cnt);
					cnt++;
				}
			}
		}
		
		
		// 다리 연결하기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j]>1) {
					visit=new boolean[N][N];
					makeBirdge(i,j);
				}
			}
		}
		
		System.out.println(result);

	}

	// bfs
	private static void divIsland(int x, int y, int cnt) {
		Deque<Point> q = new ArrayDeque<>();

		q.offer(new Point(x,y,0));
		map[x][y]=cnt;
		visit[x][y] = true;

		while (!q.isEmpty()) {
			Point curr=q.poll();
			x=curr.x;
			y=curr.y;
			for (int i = 0; i < 4; i++) {
				int nx = x + dir[i][0];
				int ny = y + dir[i][1];

				if (nx < 0 || nx >= N || ny < 0 || ny >= N)
					continue;
				if (!visit[nx][ny] && map[nx][ny] == 1) {
					visit[nx][ny] = true;
					//checkBorder(nx,ny,cnt);
					q.offer(new Point(nx,ny,0));
					map[nx][ny] = cnt;
				}
			}
		}
	}
	
	private static void makeBirdge(int x, int y) {
		Deque<Point> q = new ArrayDeque<>();

		q.offer(new Point(x,y,0));
		int currIsland=map[x][y];
		visit[x][y] = true;

		while (!q.isEmpty()) {
			Point curr=q.poll();
			x=curr.x;
			y=curr.y;
			for (int i = 0; i < 4; i++) {
				int nx = x + dir[i][0];
				int ny = y + dir[i][1];

				if (nx < 0 || nx >= N || ny < 0 || ny >= N)
					continue;
				if (!visit[nx][ny]&&currIsland!=map[nx][ny]) {
					if(map[nx][ny]==0) {
						q.offer(new Point(nx,ny,curr.cost+1));
						visit[nx][ny] = true;
					} else {
						result=Math.min(result,curr.cost);
						return;
					}
				}
			}
		}
	}
}
