import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17952 {
	static int[] A_arr; // 업무의 점수를 저장하는 배열
	static int[] T_arr; // 업무를 해결 시간을 저장하는 배열
	static int N; // 몇 분인지를 나타내는 정수 N

	public static void main(String[] args) throws IOException {
		input(); // 입력
		System.out.println(runTask(N)); // 구현 및 출력
	}
	
	// 입력 함수
	static private void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		A_arr = new int[N];
		T_arr = new int[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			if (Integer.parseInt(st.nextToken()) == 1) {
				A_arr[i] = Integer.parseInt(st.nextToken()); // 업무의 점수
				T_arr[i] = Integer.parseInt(st.nextToken()); // 업무를 해결 시간
			}
		}
	}

	
	// 업무시간 계산 함수
	static private int runTask(int n) {
		int time = 0; // 여유시간
		int score = 0; // 누적점수
		for (int i = (n - 1); i >= 0; i--) { // 배열을 거꾸로 돌며 탐색
			if (A_arr[i] == 0) { // 해당 시점에는 업무가 주어지지 않음
				time++; // 여유시간 +1
				continue;
			}

			T_arr[i]--; // 업무를 받으면 바로 시작
			T_arr[i]-=time; // 여유시간 차감
			if (T_arr[i] <= 0) {
				if (T_arr[i] != 0) time = Math.abs(T_arr[i]); // (업무시간 - 여유시간)이 0보다 작을경우 해당 여유시간 재저장
				else time=0; // (업무시간-여유시간)이 0일 경우 여유시간 초기화
				score += A_arr[i]; // 점수 누적
			}
			else time=0; // 여유시간 초기화
		}
		return score;
	}
}
