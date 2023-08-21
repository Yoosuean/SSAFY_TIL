package boj_algorithm;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class BOJ_10026 {
    static int N;
    static char[][] map;
    static boolean[][] visit;
    static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 } }; // 상하좌우
    static int cnt1=0,cnt2=0;
    public static void main(String[] args) throws IOException {
        input(); // 입력
        count(); // 구현
        System.out.println(cnt1+" "+cnt2); // 출력
    }

    // 입력
    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map=new char[N][N];
        for (int i = 0; i < N; i++) {
            map[i] = (br.readLine()).toCharArray();
        }
    }

    // 적록색약에게 보여지는 맵
    static void changeMap() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 'R')
                    map[i][j] = 'G';
            }
        }
    }
    
    // BFS 탐색
    static void bfs(int x, int y) {
        Deque<Point> dq = new LinkedList<>();
        dq.add(new Point(x, y));
        visit[x][y] = true;
        char cur = map[x][y]; // 현재 위치의 색상
        
        while (!dq.isEmpty()) {
            Point curPoint = dq.poll();
            x = curPoint.x;
            y = curPoint.y;
            for (int i = 0; i < 4; i++) {
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];
                if (nx < 0 || nx >= N || ny < 0 || ny >= N)
                    continue;
                if (!visit[nx][ny]&&map[nx][ny] == cur) { // 현재 위치의 색상과 같을 때만 탐색해줌.
                    visit[nx][ny] = true;
                    dq.add(new Point(nx, ny));
                }
            }
        }
    }

    
    // 맵의 영역 count
    static void count() {
        visit = new boolean[N][N];
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(!visit[i][j]) {
                    bfs(i,j);
                    cnt1++;
                }
            }
        }
        
        changeMap(); // 적록색약 맵으로 변경
        
        visit = new boolean[N][N]; // visit 배열 초기화
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(!visit[i][j]) {
                    bfs(i,j);
                    cnt2++;
                }
            }
        }
    }

}
