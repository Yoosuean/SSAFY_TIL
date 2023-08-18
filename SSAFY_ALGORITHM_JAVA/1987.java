package boj_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1987 {
	static int R, C, max;
	static char[][] map;
	static int[][] direction = { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 } };
	static boolean[] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		visit = new boolean[26];
	
		for (int i = 0; i < R; i++) {
			String str=br.readLine();
			map[i] = str.toCharArray();
		}
		dfs(0,0,0);
		System.out.println(max);
	}

	static void dfs(int x, int y, int cnt) {
		int tmp=map[x][y]-'A';
		if(visit[tmp]){
			max=Math.max(max, cnt);
			return;
		} else {
			visit[tmp]=true;
			for (int i = 0; i < 4; i++) {
				int nx = x + direction[i][0];
				int ny = y + direction[i][1];
				if (nx < 0 || nx >= R || ny < 0 || ny >= C)
					continue;
				dfs(nx,ny,cnt+1);
			} 
			visit[tmp]=false;
		}
	}
}
