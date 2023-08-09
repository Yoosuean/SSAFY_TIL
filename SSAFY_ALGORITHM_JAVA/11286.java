package boj_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class BOJ_11286 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		// 우선순위 큐의 정렬 기준 변경
		Queue<Integer> minHeap = new PriorityQueue<>((o1,o2)->{
			int abs1=Math.abs(o1);
			int abs2=Math.abs(o2);
			
			if(abs1==abs2) return o1-o2;
			return abs1-abs2;
		});

		for (int i = 0; i < N; i++) {
			int x = Integer.parseInt(br.readLine());
			if (x == 0) {
				if (minHeap.isEmpty()) {
					System.out.println("0");
				} else {
					System.out.println(minHeap.poll());
				}
			} else {
				minHeap.add(x);
			}
		}
	}
}
