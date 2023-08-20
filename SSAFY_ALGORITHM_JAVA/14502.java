package boj.silver;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_14502 {
	static int[][] dir = {{1,0},{-1,0},{0,-1},{0,1}}; // 상하좌우
	static int N,M;
	static int[][] map;
	static int[][] copyMap;
	static int res=0;

	public static void main(String[] args) throws IOException {
		input(); // 입력
		dfs(0); // 구현
		System.out.println(res); // 출력
	}
	
	/**
	 * 입력받기
	 * @throws IOException
	 */
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		map=new int[N][M];
		for(int i=0; i<N; i++) {
			map[i]=Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
	}
	
	/**
	 * 벽 세우기
	 * @param cnt
	 */
	static void dfs(int cnt) {
		if(cnt==3) {
			countVirus();
			return;
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j]==0) {
					map[i][j]=1;
					dfs(cnt+1);
					map[i][j]=0;
				}
			}
		}
	}
	
	
	/**
	 * 바이러스 전파
	 * @param x
	 * @param y
	 */
	static void bfs(int x, int y) {
		Deque<Point> dq=new LinkedList<>();
		
		dq.add(new Point(x,y));
		
		while(!dq.isEmpty()) {
			Point cur=dq.poll();
			
			for(int i=0; i<4; i++) {
				int nx=cur.x+dir[i][0];
				int ny=cur.y+dir[i][1];
				
				if (nx<0||nx>=N||ny<0||ny>=M) continue;
				if (copyMap[nx][ny]==0) {
					copyMap[nx][ny]=3;
					dq.add(new Point(nx,ny));
				}
			}
		}
		
	
		
	}

	
	/**
	 * 안전영역 카운팅
	 */
	static void countVirus() {
		copyMap=new int[N][M];
		for(int i=0; i<N; i++) {
			copyMap[i]=Arrays.copyOf(map[i], M);
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(copyMap[i][j]==2)  bfs(i,j);
			}
		}
		
		int cnt = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(copyMap[i][j]==0) cnt++;
			}
		}
		res=Math.max(cnt, res);
	}
	
}

