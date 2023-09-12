import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14712 {
    static int n, m, res;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n + 1][m + 1];

        dfs(0);
        System.out.println(res);
    }

    static void dfs(int cnt) {
        if (res == n * m) {
            ans++;
            return;
        }
        int y = cnt / m + 1;
        int x = cnt % m + 1;

        if (map[y - 1][x] == 1 && map[y][x - 1] == 1 && map[y - 1][x - 1] == 1) {
            dfs(cnt + 1);
        } else {
            dfs(cnt + 1); 
            map[y][x] = 1;
            dfs(cnt + 1);
            map[y][x] = 0;
        }

    }
}
