package swea_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1233 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb= new StringBuilder();
		
		for(int tc=1; tc<=10; tc++) {
			int N = Integer.parseInt(br.readLine());
			int res=1;
			for(int i=0; i<N; i++) {
				String[] nodes=br.readLine().split(" ");
				
				// node가 리프노드가 아니고 숫자이면 + node가 리프노드이고 숫자가 아니면
				if(nodes.length>2&&nodes[1].charAt(0)>='0' || nodes.length<=2 && nodes[1].charAt(0)<'0') {
					// 유효성 검사 실패
					res=0;
					
					// 남은 입력 받아주기
					for(int j=i+1; j<N; j++) {
						br.readLine();
					}
					break;
				} 
			}
			sb.append("#").append(tc).append(" ").append(res).append("\n");
		}
		System.out.println(sb);
	}
}
