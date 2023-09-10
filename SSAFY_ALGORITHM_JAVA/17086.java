import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_17086 {
    static int N,M;
    static int res=Integer.MIN_VALUE;
    static int min=Integer.MAX_VALUE;
    static int[][] dir={{-1,0},{1,0},{0,-1},{0,1},{-1,-1},{1,-1},{1,1},{-1,1}};
    static int[][] map;
    static boolean[][] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visit=new boolean[N][M];

        for(int i=0; i<N; i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j]==0){
                	min=Integer.MAX_VALUE; 
                    visit = new boolean[N][M];
                    res=Math.max(bfs(i,j),res);
                }
            }
        }
        
        System.out.println(res);

    }


    private static int bfs(int x, int y){
        Deque<Point> q= new LinkedList<>();

        q.add(new Point(x, y, 1));
        visit[x][y]=true;
        
        while(!q.isEmpty()) {
        	Point curr=q.poll();
        	
        for(int i=0; i<8; i++){

            int nx=dir[i][0]+ curr.x;
            int ny=dir[i][1]+ curr.y;

            if(nx>=N||nx<0||ny>=M||ny<0) continue;
            if(visit[nx][ny]) continue;
            if(map[nx][ny]==0){
                q.add(new Point(nx,ny,curr.dis+1));
                visit[nx][ny]=true;
            } else {
                min=Math.min(min, curr.dis);
                return min;
            }

         }
       }
       return 0;
    }

}

class Point{
    int x;
    int y;
    int dis;

    public Point(int x, int y, int dis) {
        this.x=x;
        this.y = y;
        this.dis = dis;
    }
}
