package swea_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1861 {
	static int[][] map;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			/** 입력 */
			int N = Integer.parseInt(br.readLine());
			int maxRoom = Integer.MIN_VALUE;
			int minMap = Integer.MAX_VALUE;
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			/** 구현 */
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int tmp = bfs(i, j, N);
					// 방 이동수가 같을 때
					if (maxRoom == tmp) {
						maxRoom = tmp;	
						// 방에 적힌 숫자 비교
						if (minMap > map[i][j]) {
							minMap = map[i][j];
						}
					} 	
					// 방 이동수가 클 때
					if (maxRoom < tmp) {
						maxRoom=tmp;
						minMap=map[i][j];
					}

				}
			}
			/** 출력 */
			System.out.println("#" + tc + " " +minMap+ " " + maxRoom);
		}

	}

	static public int bfs(int x, int y, int N) {
		Queue<Node> q = new LinkedList<>();
		int cnt = 1;
		q.offer(new Node(x, y));


		while (!q.isEmpty()) {
			Node node = q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = dx[i] + node.x;
				int ny = dy[i] + node.y;
				
				if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
				if (map[node.x][node.y] + 1 != map[nx][ny]) continue;
				q.offer(new Node(nx, ny));
				cnt++;
			}
		}
		return cnt;
	}
	
	
	// Node Class
	static public class Node {
		int x;
		int y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
