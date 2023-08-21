import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10162 {

	public static void main(String[] args) throws IOException {
		/** 입력 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int a = 0, b = 0, c = 0; // A, B, C 카운트를 위한 초기화

		/** 구현 */
		// 큰 수부터 차례로 나눠줌
			if (T / 300 > 0) { // 버튼 A를 눌렀을 경우
				a += T / 300;
				T %= 300;
			}
			if (T / 60 > 0) { // 버튼 B를 눌렀을 경우
				b += T / 60;
				T %= 60;
			}
			if (T / 10 > 0) { // 버튼 C를 눌렀을 경우
				c += T / 10;
				T %= 10;
			}
			
			/** 출력 */
			// T가 0일 경우 a,b,c의 카운트 출력, 0이 아닐 경우 -1 출력
			if (T == 0) System.out.println(a + " " + b + " " + c);
			else System.out.println(-1);
	}
}
