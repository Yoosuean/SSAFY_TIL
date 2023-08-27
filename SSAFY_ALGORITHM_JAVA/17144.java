package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17144 {
	static int R, T, C;
	static int[][] map;
	static int[][] sMap;
	static int air = 0;
	static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws IOException {
		/** 입력 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		map = new int[R][C];

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				int temp = Integer.parseInt(st.nextToken());
				map[i][j] = temp;
				if (map[i][j] == -1)
					air = i; // 공기청정기 위치 저장
			}
		}

		/** 구현 */ 
		for (int tc = 1; tc <= T; tc++) {
			sMap = new int[R][C];
			sMap[air][0] = -1;
			sMap[air - 1][0] = -1;

			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (map[i][j] > 0) spread(i, j); // 미세먼지 확산
				}
			}
			for (int i = 0; i < R; i++) {
				map[i] = sMap[i].clone();
			}
			clean(); // 공기청정기 가동
		}
		
		/** 출력 */
		int res = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] > 0)
					res += map[i][j];
			}
		}
		System.out.println(res);
	}

	
	// 미세먼지 확산
	private static void spread(int r, int c) {
		int x = r;
		int y = c;
		int cnt = 0;

		for (int i = 0; i < 4; i++) {
			int nx = x + dir[i][0];
			int ny = y + dir[i][1];

			if (nx >= R || nx < 0 || ny >= C || ny < 0 || map[nx][ny] == -1) continue;

			sMap[nx][ny] += map[x][y] / 5;
			cnt++;
		}

		sMap[x][y] += map[x][y] - (map[x][y] / 5) * cnt;
	}

	// 공기청정기 가동
	private static void clean() {
		// 오른쪽으로 이동
		for (int i = 1; i < C - 1; i++) {
			map[air - 1][i + 1] = sMap[air - 1][i];
			map[air][i + 1] = sMap[air][i];
		}
		map[air - 1][1] = 0;
		map[air][1] = 0;

		// 위로 이동
		for (int i = air - 1; i > 0; i--) {
			map[i - 1][C - 1] = sMap[i][C - 1];
		}

		// 아래로 이동
		for (int i = air; i < R - 1; i++) {
			map[i + 1][C - 1] = sMap[i][C - 1];
		}

		// 왼쪽으로 이동
		for (int i = C - 1; i > 0; i--) {
			if (sMap[0][i - 1] == -1) break;
			if (sMap[R - 1][i - 1] == -1) break;
			map[0][i - 1] = sMap[0][i];
			map[R - 1][i - 1] = sMap[R - 1][i];
		}

		// 공기청정기로
		for (int i = 0; i < air - 1; i++) {
			if (sMap[i + 1][0] == -1) break;
			map[i + 1][0] = sMap[i][0];

		}
		for (int i = R - 1; i > air; i--) {
			if (sMap[i - 1][0] == -1) break;
			map[i - 1][0] = sMap[i][0];
		}

	}

}
