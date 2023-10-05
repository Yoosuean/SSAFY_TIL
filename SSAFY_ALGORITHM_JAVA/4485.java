import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_4485_녹색옷입은애가젤다지 {
	static int[][] map;
	static int N,res;
	static StringTokenizer st=null;
	static BufferedReader br=null;
	static int[][] dir = {{1,0},{-1,0},{0,-1},{0,1}};
	
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int cnt=1;
        
        while(true) {
        	res=0;
        	N=Integer.parseInt(br.readLine());
            if(N==0) {
                break;
            }           
            map=new int[N][N];
            for(int i=0; i<N; i++) {
            	st=new StringTokenizer(br.readLine());
            	for(int j=0; j<N; j++) {
            		map[i][j]=Integer.parseInt(st.nextToken());
            	}
            }
            res=solution();
            System.out.println("Problem "+cnt+": "+res);
            cnt++;
        }
    }

    
    
    private static int solution() {
    	Queue<Node> q=new PriorityQueue<>();
    	boolean[][] visit=new boolean[N][N];
    	int[][] costArr=new int[N][N];
    	visit[0][0]=true;
    	q.add(new Node(0,0,map[0][0]));
    	
    	while(!q.isEmpty()) {
    		Node curr=q.poll();
    		for(int i=0; i<4; i++) {
    			int nx=curr.x+dir[i][0];
    			int ny=curr.y+dir[i][1];
    			
    			if(nx<0||nx>=N||ny<0||ny>=N) continue;
    			if(!visit[nx][ny]) {
    				visit[nx][ny]=true;
    				costArr[nx][ny]=curr.cost+map[nx][ny];
    				q.add(new Node(nx,ny,curr.cost+map[nx][ny]));    				
    			}
    		}
    	}
    	return costArr[N-1][N-1];
    }

}


class Node implements Comparable<Node>{
	int x;
	int y;
	int cost;
	public Node(int x, int y, int cost) {
		this.x = x;
		this.y = y;
		this.cost=cost;
	}
	@Override
	public int compareTo(Node o) {
		return this.cost-o.cost;
	}
	
}
