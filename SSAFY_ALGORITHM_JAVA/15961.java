import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_15961 {
	static int N, d, k, c, res;
	static int[] sushi, eat;
	static Queue<Integer> queue;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		sushi = new int[N];
		eat = new int[d + 1];

		for (int i = 0; i < N; i++) {
			sushi[i] = Integer.parseInt(br.readLine());
		}
		eat[c]++;
		res = 1;

		queue = new LinkedList<>();
		for (int i = N - k; i < N; i++) {
			if (eat[sushi[i]] == 0) res++;
			eat[sushi[i]]++;
			queue.offer(sushi[i]);
		}

		int cnt = res;
		for (int i = 0; i < N - 1; i++) {
			int temp = queue.poll();
			eat[temp]--;
			if (eat[temp] == 0) cnt--;

			queue.add(sushi[i]);
			if (eat[sushi[i]] == 0) cnt++;
			eat[sushi[i]]++;
			res = Math.max(res, cnt);
		}

		System.out.println(res);
	}
}
