package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class SWEA_6808 {
    static int[] gyu_cards;
    static int[] in_cards;
    static int[] output;
    static boolean[] visited;
    static List<int[]> outputList;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        gyu_cards = new int[9];
        in_cards = new int[9];

        // 규영이 카드 입력
        for (int tc = 0; tc < T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 9; i++) {
                gyu_cards[i] = Integer.parseInt(st.nextToken());
            }

            // 규영이 카드 중 없는 숫자
            int cnt = 0;
            for (int i = 1; i <= 18; i++) {
                if (!Arrays.stream(gyu_cards).boxed().collect(Collectors.toSet()).contains(i)) {
                    in_cards[cnt] = i;
                    cnt++;
                }
            }
            
            output = new int[9];
            visited = new boolean[9];
            outputList = new ArrayList<int[]>();

            int gyu_win = 0;
            int gyu_loose = 0;
            permutation(0, 9);

            for (int i = 0; i <outputList.size(); i++) {
                int tmp1=0; 
                int tmp2=0;
                for (int j = 0; j < 9; j++) {
                    if (gyu_cards[j] > outputList.get(i)[j]) {
                        tmp1+=gyu_cards[j]+outputList.get(i)[j];
                    } else {
                        tmp2+=gyu_cards[j]+outputList.get(i)[j];
                    }
                }
                if (tmp1>tmp2) gyu_win+=1;
                else gyu_loose+=1;
            }

            sb.append("#").append(tc + 1).append(" ").append(gyu_win).append(" ").append(gyu_loose);
            System.out.println(sb);
            sb.setLength(0);

        }

    }

    // 순열함수
    public static void permutation(int depth, int r) {
        if (depth == r) {
            outputList.add(output.clone());
            return;
        }

        for (int i = 0; i < in_cards.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = in_cards[i];
                permutation(depth + 1, r);
                visited[i] = false;
            }
        }
    }

}
