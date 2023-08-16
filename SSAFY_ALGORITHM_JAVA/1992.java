package boj.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1992 {
	static int N;
	static String[][] map;
	static String res="";

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		map=new String[N][N];
		for(int i=0; i<N; i++) {
			String[] str=br.readLine().split("");
			for(int j=0; j<N; j++) {
				map[i][j]=str[j];

			}
		}
		
		calc(0,0,N);
		System.out.println(res);
	}
	
	public static void calc(int i, int j, int size) {
		if (check(i, j, size)) {
			res = res + map[i][j];
			return;
		} else {
			size = size/2;
			res = res + '(';
			calc(i, j, size);  // 제1사분면
			calc(i, j + size, size);  // 제2사분면
			calc(i + size, j, size);  // 제3사분면
			calc(i + size, j + size, size);  // 제4사분면
			res = res + ')';
			
		}
	}
	
    // 0 or 1만 있는지 검사
	public static boolean check(int i, int j, int size) {
		String c = map[i][j];
		int dx, dy;
		for (int x = 0; x < size; x++) {
			for (int y = 0; y < size; y++) {
				dx = i + x;
				dy = j + y;
				if (!c.equals(map[dx][dy])) {
					return false;
				}
			}
		}
		return true;
	}

}
