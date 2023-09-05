import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16987 {
	static int N,max;
	static int[] duration; // 내구성
	static int[] weight; // 무게
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N=Integer.parseInt(br.readLine());
		max=Integer.MIN_VALUE;
		
		duration= new int[N]; // 내구성
		weight=new int[N]; // 무게
		for(int i=0; i<N; i++) {
			st= new StringTokenizer(br.readLine());
			duration[i]=Integer.parseInt(st.nextToken());
			weight[i]=Integer.parseInt(st.nextToken());
		}
		
		backTracking(0,0);
		System.out.println(max);
	
	}
	
	private static void backTracking(int idx, int cnt) {
		if(idx==N) { // 들고 있는 계란이 N일 경우
			max=Math.max(max, cnt);
			return;
		}
		
		if(duration[idx]<=0||cnt==N-1) { // 내구도가 0보다 작거나 계란을 N개 깼을 경우
			backTracking(idx+1,cnt);
		}
		
		int currCnt=cnt;
		// 0번부터 N번까지의 계란
		for(int i=0; i<N; i++) {
			// 내가 들고 있는 계란과 같을 때
			if(idx==i) continue; 
			// 내구도가  0 이하일 때
			if(duration[i]<=0) continue; //  수비계란의 내구도가 0보다 작을 때
			if(duration[idx]<=0) continue; // 공격계란의 내구도가 0보다 작을 때
			
			breakEgg(idx,i);
			
			if(duration[idx]<=0) cnt++; // 공격계란이 깨졌을 경우
			if(duration[i]<=0) cnt++; // 수비계란이 깨졌을 경우
			
			backTracking(idx+1,cnt);
			undo(idx,i); // 되돌리기
			cnt=currCnt;
		}
	}
	
	// 계란 깨는 함수
	private static void breakEgg(int forwardIdx, int defenseIdx) {
		duration[forwardIdx]-=weight[defenseIdx];
		duration[defenseIdx]-=weight[forwardIdx];
	}
	
	// 되돌리기 함수
	private static void undo(int forwardIdx, int defenseIdx) {
		duration[forwardIdx]+=weight[defenseIdx];
		duration[defenseIdx]+=weight[forwardIdx];	
	}

}
