package boj_algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_2961 {
	
	static LinkedList<int[]> arr = new LinkedList<int[]>();
	static int N;
	static boolean isSelected[];
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		
		/** 입력 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		isSelected = new boolean[N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			arr.add(new int[] { S, B });
		}
		
	
		/** 구현 */
		generateSubset(0);
		
		/** 출력 */
		System.out.println(min);
	}

	/** 부분집합 생성 함수 */
	static void generateSubset(int cnt) {
		int sum = 0;
		int mul = 1;
		int fCnt = 0;
		
		// 부분집합의 신맛의 누적곱, 쓴맛의 누적합을 계산
		if (cnt == N) {
			for (int i = 0; i < N; i++) {
				if (isSelected[i]) {
					mul*=arr.get(i)[0];
					sum+=arr.get(i)[1];
				} else
					fCnt++;
			}
			// 공집합 제외
			if (fCnt != N) { 
				// 신맛과 쓴맛의 차이의 최소값
				min = Math.min(min, Math.abs(mul - sum));
			}
			return;
		}
		isSelected[cnt] = true;
		generateSubset(cnt + 1);
		isSelected[cnt] = false;
		generateSubset(cnt + 1);
	}

}
