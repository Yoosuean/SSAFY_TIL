package boj_algorithm;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_2178 {
	static int N;
	static int M;
	static int[][] map;
	static int[][] dir= {{1,0},{-1,0},{0,-1},{0,1}}; // 상 하 좌 우

	public static void main(String[] args) throws IOException {
		input();
		System.out.println(bfs(0,0));
	}
	
	// 입력
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		map=new int[N][M]; 
		for(int i=0; i<N; i++) {
			String str=br.readLine();
			map[i]=Arrays.stream(str.split("")).mapToInt(Integer::parseInt).toArray();
		}
	}
	
	// bfs 탐색
	static int bfs(int x, int y) {
		Deque<Point> q=new LinkedList<Point>();
		q.offer(new Point(x,y));
		Point p = new Point(x,y);
		
		while(!q.isEmpty()) {
			p=q.poll();
			for(int i=0; i<4; i++) { // 사방탐색
				int nx=p.x+dir[i][0];
				int ny=p.y+dir[i][1];
				
				if(nx<0||nx>=N||ny<0||ny>=M) continue;
				if(map[nx][ny]==1) {
					map[nx][ny]=map[p.x][p.y]+1; // 배열을 탐색하며 누적합
					q.offer(new Point(nx,ny));
				}
				
			}
		}		
		return map[N-1][M-1]; // 누적된 값을 계산해서 결과값 반환 
	}
}
