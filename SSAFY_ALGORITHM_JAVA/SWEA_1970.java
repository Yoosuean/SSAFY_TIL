package SSAFY_ALGORITHM_JAVA;

import java.util.Scanner;

public class SWEA_1970 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		
		int[] m = new int[8];
		for(int i=1; i<=T; i++) {
			int cnt = 50000;
			int N = scan.nextInt();
			
			for(int j=0; j<m.length; j++) {
				m[j] = N / cnt;	//
				N %= cnt;
				if(j%2 == 0)	cnt/= 5;
				else			cnt/= 2;
				
			}
			
			System.out.println("#" + i);
			for(int j=0; j<m.length; j++) {
				System.out.print(m[j] + " ");
			}
			System.out.println();
		}

	}

}
