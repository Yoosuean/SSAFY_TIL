import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
    static boolean visited[];
    static int[][] point;
    static int[] output;
    static int N;
    static int res;
     
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        int T = Integer.parseInt(br.readLine());
 
        for (int tc = 1; tc <= T; tc++) {
            res=Integer.MAX_VALUE;
            N = Integer.parseInt(br.readLine());
 
            point = new int[N+2][2];
            output= new int[N+2];
            visited=new boolean[N+2];
            StringTokenizer st = new StringTokenizer(br.readLine());
             
             
            // 회사와 집의 좌표
            point[0][0]=Integer.parseInt(st.nextToken());
            point[0][1]=Integer.parseInt(st.nextToken());
            point[N+1][0]=Integer.parseInt(st.nextToken());
            point[N+1][1]=Integer.parseInt(st.nextToken());
             
             
            for(int i=1; i<N+1; i++) {
                point[i][0]=Integer.parseInt(st.nextToken());
                point[i][1]=Integer.parseInt(st.nextToken());
            }
             
            // 구현
            permutation(1);
            System.out.println("#"+tc+" "+res);
        }
    }
     
     
    // 순열함수 
    public static void permutation(int depth) {
        if(depth==N+1) {
            int distance=0;
            for(int i=0; i<N+1; i++) {
                distance+=Math.abs(point[output[i]][0]-point[output[i+1]][0]) + 
                        Math.abs(point[output[i]][1]-point[output[i+1]][1]);
            }
            res=Math.min(res, distance);
            return;
            }
         
        // 집과 회사 방문처리 
        visited[0]=true;
        visited[N+1]=true;
        output[0]=0;
        output[N+1]=N+1;
         
        for(int i=1; i<N+1; i++) {
            if(!visited[i]) {
                visited[i]=true;
                output[depth]=i;
                permutation(depth+1);
                visited[i]=false;
            }
        }
         
    }
 
}
