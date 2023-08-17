package swea_algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1873 {
	static char[][] map;
	static char[] input; // 상하좌우
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int curDir; // 상하좌우
	static int H, W;
	static Node curNode;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			boolean flag = false; // 초기값 설정 확인

			// 맵 입력
			map = new char[H][W];
			for (int i = 0; i < H; i++) {
				String str = br.readLine();
				map[i] = str.toCharArray();
				if (!flag) {
					int tmp = 0;
					if (str.contains("^")) {
						curDir = 0;
						tmp = str.indexOf("^");
					} else if (str.contains("v")) {
						curDir = 1;
						tmp = str.indexOf("v");
					} else if (str.contains("<")) {
						curDir = 2;
						tmp = str.indexOf("<");
					} else if (str.contains(">")) {
						curDir = 3;
						tmp = str.indexOf(">");
					}
					curNode = new Node(i, tmp);
					map[i][tmp] = '.';
					flag = true;
				}
			}

			// 사용자 입력
			int N = Integer.parseInt(br.readLine());
			input = new char[N];
			input = br.readLine().toCharArray();

			// 구현
			for (char in : input) {
				if (in == 'S') {
					shoot(curNode.x, curNode.y);
					continue;
				}
				if (in == 'U')
					curDir = 0;
				else if (in == 'D')
					curDir = 1;
				else if (in == 'L')
					curDir = 2;
				else if (in == 'R')
					curDir = 3;
				move(curNode.x, curNode.y);
			}

			if (curDir == 0)
				map[curNode.x][curNode.y] = '^';
			if (curDir == 1)
				map[curNode.x][curNode.y] = 'v';
			if (curDir == 2)
				map[curNode.x][curNode.y] = '<';
			if (curDir == 3)
				map[curNode.x][curNode.y] = '>';

			System.out.print("#" + tc + " ");
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}

		}
	}

	static private void move(int x, int y) {
		int nx = x + dir[curDir][0];
		int ny = y + dir[curDir][1];

		if (nx >= H || nx < 0 || ny >= W || ny < 0)
			return;

		if (map[nx][ny] == '.') {
			curNode.x = nx;
			curNode.y = ny;
			return;
		}

	}

	static private void shoot(int x, int y) {
		while (true) {
			int nx = x + dir[curDir][0];
			int ny = y + dir[curDir][1];
			if (nx >= H || nx < 0 || ny >= W || ny < 0)
				return;
			if (map[nx][ny] == '*') {
				map[nx][ny] = '.';
				return;
			}
			if (map[nx][ny] == '#')
				return;
			x = nx;
			y = ny;
		}
	}

}

class Node {
	public int x;
	public int y;

	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
