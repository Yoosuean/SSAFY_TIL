package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_3055_탈출 {
	static int R,C, time;
	static char[][] map;
	static Node start= new Node(0,0);
	static ArrayList<Node> waterList = new ArrayList<>();
	static int[][] dir = {{1,0},{-1,0},{0,-1},{0,1}};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
	
		for(int i=0; i<R; i++) {
			String str=br.readLine();
			for(int j=0; j<C; j++) {
				map[i][j]=str.charAt(j);
				if(map[i][j]=='S') {
					start.x=i;
					start.y=j;
				}
				if(map[i][j]=='*') {
					waterList.add(new Node(i,j));
				}
			}
		}
		
		
		int res=moveGosm(start.x, start.y);
		System.out.println(res==0?"KAKTUS":res);
		

	}
	
	static private int moveGosm(int x, int y) {
		boolean[][] visited = new boolean[R][C];
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(x,y,0));
		visited[x][y]=true;
		int cnt=0;
		spreadWater();
		
		while(!q.isEmpty()) {
			Node curNode=q.poll();
			while(cnt<curNode.cnt) {
				spreadWater();
				cnt=curNode.cnt;
			}
		
		
			for(int i=0; i<4; i++) {
				int nx=curNode.x+dir[i][0];
				int ny=curNode.y+dir[i][1];
				
				if(!checkRange(nx,ny)) continue;
				if(map[nx][ny]=='D') {
					return curNode.cnt+1;
				}
				if(map[nx][ny]=='.'&&!visited[nx][ny]) {
					q.add(new Node(nx,ny,curNode.cnt+1));
					visited[nx][ny]=true;
				}
			}
		}
		return 0;
		
	}
	
	static private void spreadWater() {
		int len=waterList.size();
		for(int i=0; i<len; i++) {
			Node curNode=waterList.get(i);
			for(int j=0; j<4; j++) {
				int nx=curNode.x+dir[j][0];
				int ny=curNode.y+dir[j][1];
				if (!checkRange(nx,ny)) continue;
				if(map[nx][ny]=='.') {
					map[nx][ny]='*';
					waterList.add(new Node(nx,ny));
				}
			}
		}
	}
	
	static private boolean checkRange(int nx, int ny) {
		return (nx<R&&nx>=0&&ny<C&&ny>=0); 
	}
	

}


class Node {
	int x;
	int y;
	int cnt;
	
	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Node(int x, int y, int cnt) {
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}
}
