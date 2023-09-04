import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class Node{
	int x;
	int y;
	int dist;
	boolean breakWall;
	public Node(int x, int y, int dist, boolean breakWall) {
		super();
		this.x = x;
		this.y = y;
		this.dist = dist;
		this.breakWall=breakWall;
	}
	
}

public class BOJ_2206 {
	static int N, M, wallNum, res;
	static int[][] map;
	static boolean visit[][][]; 
	static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		res=Integer.MAX_VALUE;

		map = new int[N][M];
		visit = new boolean[N][M][2]; // 0: 벽 안깼을 때, 1: 벽 꺴을 때

		for (int i = 0; i < N; i++) {
			String str=br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j]=Integer.parseInt(String.valueOf(str.charAt(j)));
			}
		}

		bfs(0,0);
		
		System.out.println(res==Integer.MAX_VALUE?-1:res);

	}


	private static void bfs(int x, int y) {
		Deque<Node> q=new ArrayDeque<>();
		q.offer(new Node(x,y,1,false));
		
		while(!q.isEmpty()) {
			Node curr=q.poll();
			x=curr.x;
			y=curr.y;
			
			if(x==N-1&&y==M-1) { 
				res=Math.min(res, curr.dist);
				return;
			}
			
			for(int i=0; i<4; i++) {
		
				int nx=x+dir[i][0];
				int ny=y+dir[i][1];
				
				if(nx<0||nx>=N||ny<0||ny>=M) continue; // 범위가 넘으면
				if(!visit[nx][ny][0]&&!curr.breakWall) { // 방문X 벽X
					if(map[nx][ny]==1) {
						q.offer(new Node(nx,ny,curr.dist+1,true));
						visit[nx][ny][1]=true;
					} else {
						q.offer(new Node(nx,ny,curr.dist+1,false));
						visit[nx][ny][0]=true;
					}
					
				} else if (!visit[nx][ny][1]&&curr.breakWall) { // 방문X 벽O
					if(map[nx][ny]==0) {
						q.offer(new Node(nx,ny,curr.dist+1,true));
						visit[nx][ny][1]=true;
					}
				}
			}
		}
	}

}
