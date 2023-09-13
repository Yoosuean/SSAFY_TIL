import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17070 {
	static int N;
	static int[][] map;
	static int[][][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		dp = new int[N][N][3]; // 0: 가로, 1: 대각선, 2: 세로
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dp[0][1][0] = 1;
		System.out.println(dp());

	}

	private static int dp() {
		// 파이프를 놓을 수 있는 것은 2열부터임
		for (int i = 0; i < N; i++) {
			for (int j = 2; j < N; j++) {
				// 길이 막혀있으면 continue
				if (map[i][j] == 1)
					continue;

				// 가로 방향 파이프의 끝이 (i,j)인 경우의 수
				dp[i][j][0] = dp[i][j - 1][0] + dp[i][j - 1][1];

				// 맨 윗 줄일 경우 continue
				if (i == 0)
					continue;

				// 세로 방향 파이프의 끝이 (i,j)인 경우의 수
				dp[i][j][2] = dp[i - 1][j][1] + dp[i - 1][j][2];

				// (i,j) 기준 왼쪽, 위쪽이 막혀있으면 continue
				if (map[i - 1][j] == 1 || map[i][j - 1] == 1)
					continue;

				// 대각선 방향 파이프의 끝이 (i,j)인 경우의 수
				dp[i][j][1] = dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2];

			}
		}

		return dp[N - 1][N - 1][0] + dp[N - 1][N - 1][1] + dp[N - 1][N - 1][2];

	}

}
