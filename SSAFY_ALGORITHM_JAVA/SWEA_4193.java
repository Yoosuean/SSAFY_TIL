package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class SWEA_4193_수영대회결승전 {
	static int T,N;
	static int[][] map;
	static int[][] dir = {{1,0},{-1,0},{0,-1},{0,1}};
	static Node start = new Node(0,0);
	static Node end = new Node(0,0);

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		T=Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			N=Integer.parseInt(br.readLine());
			map=new int[N][N];
			
			//입력
			for(int i=0; i<N; i++) {
				st=new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			st=new StringTokenizer(br.readLine());
			start.x=Integer.parseInt(st.nextToken());
			start.y=Integer.parseInt(st.nextToken());
			st=new StringTokenizer(br.readLine());
			end.x=Integer.parseInt(st.nextToken());
			end.y=Integer.parseInt(st.nextToken());
			
			// 구현
			int res=swim(start.x,start.y);
			
			// 출력
			System.out.println("#"+tc+" "+res);		
		}
	}
	
	static private int swim(int x, int y) {
		Deque<Node> q= new LinkedList<>(); 
		boolean[][] visited = new boolean[N][N];
		q.add(new Node(x,y));
		int count=0;
		
		
		while(!q.isEmpty()) {
			int size=q.size(); // 현재 위치할 수 있는 위치 목록의 개수
				while(size-- >0) {
					Node curr=q.poll();
				for(int i=0; i<4; i++) {
					int nx=curr.x+dir[i][0];
					int ny=curr.y+dir[i][1];
					if(nx<0||nx>=N||ny<0||ny>=N) continue;
					if(map[nx][ny]==1||visited[nx][ny]) continue;
					if(map[nx][ny]==2) {
						if(count%3!=2) {
							q.add(curr);
							continue;
						}
					}
					if(nx==end.x&&ny==end.y) {
						return count+1;
					}
					
					q.add(new Node(nx,ny));
					visited[nx][ny]=true;
				}
			}
				count++;
		}	
		
		return -1;
	}

}

class Node {
	int x;
	int y;
	
	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}	
}
