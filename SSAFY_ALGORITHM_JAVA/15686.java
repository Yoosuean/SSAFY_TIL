package SSAFY_ALGORITHM_JAVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_15686 {
	static List<int[]> house;
	static List<int[]> chicken;
	static int[][] combChicken;
	static int res = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str=br.readLine();
		StringTokenizer st= new StringTokenizer(str);
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		
		// 삽입, 삭제가 많을시 LinkedList
		 house = new LinkedList<>();
		 chicken = new LinkedList<>();

		for(int i=0; i<N;i++) {
			str=br.readLine();
			st= new StringTokenizer(str);
			for(int j=0; j<N; j++) {
				int tmp=Integer.parseInt(st.nextToken());
				//map[i][j]=Integer.parseInt(st.nextToken());
				
				if(tmp==1) {
					int[] point= {i,j};
					house.add(point);
				}
				if(tmp==2) {
					int[] point= {i,j};
					chicken.add(point);
				}
			}
		}
		
		// 치킨집 조합 리스트
		combChicken= new int[chicken.size()][2];
		
		
		// 구현
		comb(0,0,M);
		System.out.println(res);
		
		
	}
	
	// 백트래킹을 이용한 조합구하는 함수
	public static void comb(int cnt, int s, int m) {
		if(cnt==m) {
			calc(m);
			return;
		}
		
		for(int i=s; i<chicken.size(); i++) {
			combChicken[cnt][0]=chicken.get(i)[0];
			combChicken[cnt][1]=chicken.get(i)[1];
			comb(cnt+1,i+1,m);	
		}
		
		
	}
	
	// 치킨집과 집의 거리계산 함수
	public static void calc(int m) {
		int min_sum=0;
		
		for(int i=0; i<house.size(); i++) {
			int min=Integer.MAX_VALUE;
			for(int j=0; j<m; j++) {
				min = Math.min(min,  Math.abs(combChicken[j][0]-house.get(i)[0])+
						Math.abs(combChicken[j][1]-house.get(i)[1]));
			}
			min_sum+=min;
		}
		res=Math.min(res,min_sum);
		return;
		
	}
	

}
