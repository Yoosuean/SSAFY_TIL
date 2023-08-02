package boj_algorithm;

import java.util.Scanner;

public class BOJ_11659 {
    public static void main(String[] args) {
    	/** 입력 */
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = input.nextInt();
        }
        
        /** 구간합 배열 */
        // 구간합 배열 생성
        int[] nums_sum = new int[n + 1];
        int sum = 0;
        
        // 0부터 i까지 합을 구한 후 nums_sum에 순서대로 저장
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            nums_sum[i + 1] = sum;
        }
        
        /** 구간 계산 */
        for (int i = 0; i < m; i++) {
            int start = input.nextInt();
            int end = input.nextInt();
            // 구간합 배열에서 end idx의 값에서 start idx값을 빼서 구간합 출력
            System.out.println(nums_sum[end] - nums_sum[start - 1]);
        }
    }
}
