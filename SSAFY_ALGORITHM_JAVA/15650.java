import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_15650 {
	static int numbers[], N, M;

	public static void main(String[] args) throws IOException {
		
		/** 입력 받기 */
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String[] input=br.readLine().split(" ");
		N=Integer.parseInt(input[0]); // 1부터 N까지의 자연수 
		M=Integer.parseInt(input[1]); // 길이가 M인 수열
		numbers= new int[M];
		
		combi(0,1);
	}
	
	/** 조합함수 실행 */
	private static void combi(int cnt, int start) {
		// 종료조건 : M번 반복하면 출력 후 종료
		if(cnt==M) {
			for(int i=0; i<numbers.length; i++) {
				System.out.println(numbers[i]);
			}
			return;
		}
		// 수열 생성
		for(int i=start; i<=N; i++) {
			numbers[cnt]=i;
			combi(cnt+1,i+1);
		}
	}

}
