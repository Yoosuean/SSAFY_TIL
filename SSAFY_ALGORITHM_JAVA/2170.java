import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;



public class BOJ_2170 {
	static int N,res;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N=Integer.parseInt(br.readLine());
		line[] lines= new line[N];
		
		for(int i=0; i<N; i++) {
			st=new StringTokenizer(br.readLine());
			int s=Integer.parseInt(st.nextToken());
			int e=Integer.parseInt(st.nextToken());
			lines[i]=new line(s,e);
		}
		
		Arrays.sort(lines); // 1. 시작점 기준 오름차순 2. 끝점 기준 오름차순
		
		int left=lines[0].s;
		int right=lines[0].e;
		
		for(int i=1; i<N; i++) {
			if(lines[i].s>right) { // 다음 시작점이 선보다 크면 
				res+=right-left; // 현재 선의 길이 저장
				left=lines[i].s; // 새로운 시작점
				right=lines[i].e; // 새로운 끝점
			} else if(lines[i].s<=right) 
				right=Math.max(right, lines[i].e);  // 현재 선의 길이와 다음 선의 길이의 끝 값이 더 큰 값으로 결
		}
		
		System.out.println(res+(right-left)); 

	}
	
	static class line implements Comparable<line>
	{
		int s;
		int e;
			
		public line(int s, int e) { 
			this.s = s;
			this.e = e;
		}

		@Override
		public int compareTo(line o) { 
			if(this.s==o.s) return this.e-o.e; // 시작점이 같으면 끝점 오름차순 정렬
			return this.s-o.s; // 시작점 오름차순 정렬
		}
		
		
	}
}
