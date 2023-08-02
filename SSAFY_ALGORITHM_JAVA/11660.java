package boj_algorithm;

import java.util.Scanner;

public class BOJ_11660 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        int[][] nums = new int[n][n];
        for (int i = 0; i < n; i++) {
        	for(int j=0; j<n; j++) {
        		nums[i][j]=input.nextInt();	
        	}
        }
        
        int[][] nums_sum = new int[n+1][n+1];
        for (int i = 1; i <=n; i++) {
            for(int j=1; j<=n; j++) {
            	nums_sum[i][j]=nums[i-1][j-1]+nums_sum[i-1][j]+nums_sum[i][j-1]-nums_sum[i-1][j-1];
            }
        }
        
        for(int i=0; i<m; i++) {
        	int x1=input.nextInt();
        	int y1=input.nextInt();
        	int x2=input.nextInt();
        	int y2=input.nextInt();
        	
        	int res=0;
        	res=nums_sum[x2][y2]+nums_sum[x1-1][y1-1]-nums_sum[x2][y1-1]-nums_sum[x1-1][y2];
        	System.out.println(res);
        }
        
    }
}
