package swea_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_1228 {
	static String[] N_str;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int tc=1; tc<=10; tc++) {
			int N = Integer.parseInt(br.readLine());
			N_str=new String[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<10; i++) {
				N_str[i]=st.nextToken();
			}
			
			
			
			int M = Integer.parseInt(br.readLine());
			st= new StringTokenizer(br.readLine());
			ArrayList<String> N_arrList=new ArrayList<>(Arrays.asList(N_str));
      // 데이터가 많을시에는 LinkedList 사용
			for(int i=0; i<M; i++) {
				st.nextToken(); // "I"
				int x=Integer.parseInt(st.nextToken());
				int y=Integer.parseInt(st.nextToken());
				for(int j=x; j<x+y; j++) {
					if(j<N) N_arrList.add(j, st.nextToken());
					else st.nextToken();
				}
			}
			
			sb.append("#"+tc+" ");
			for(int i=0; i<10; i++) {
				sb.append(N_arrList.get(i)+" ");
			}
			
			System.out.println(sb);
			sb.setLength(0);
			
		}
		
		
		
		

	}

}
