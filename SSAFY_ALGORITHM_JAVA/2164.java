package boj_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2164 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		
		Queue<Integer> queue = new LinkedList<Integer>();
		for(int i=1; i<N+1; i++) {
			queue.add(i);
		}
		
		while(queue.size()>1) {
			queue.poll();
			queue.add(queue.poll());
		}	
		System.out.println(queue.peek());
	}

}
