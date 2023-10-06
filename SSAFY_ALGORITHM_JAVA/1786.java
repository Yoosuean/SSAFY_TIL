import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 문자열 T 입력
        String text = br.readLine();

        // 문자열 P 입력
        String pattern = br.readLine();

        // KMP 알고리즘 수행하여 매칭된 위치 찾기
        ArrayList<Integer> result = kmpSearch(text, pattern);

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        sb.append(result.size()).append('\n'); // 매칭된 횟수 출력
        for (int position : result) {
            sb.append(position).append(' '); // 매칭된 위치들 출력
        }
        System.out.println(sb);
    }

    // 실패 함수 계산
    private static int[] getFailureFunction(String pattern) {
        int m = pattern.length(); // 패턴의 길이
        int[] fail = new int[m]; // 실패 함수 배열

        int j = 0;
        for (int i = 1; i < m; i++) {
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                // 일치하지 않으면 j를 이전 일치한 위치로 되돌림
                j = fail[j - 1];
            }
            if (pattern.charAt(i) == pattern.charAt(j)) {
                // 일치할 경우, j를 증가시키고 현재 위치를 저장
                fail[i] = ++j;
            }
        }

        return fail;
    }

    // KMP 알고리즘으로 문자열 매칭 수행
    private static ArrayList<Integer> kmpSearch(String text, String pattern) {
        ArrayList<Integer> result = new ArrayList<>(); // 매칭된 위치를 저장할 리스트
        int n = text.length(); // 텍스트의 길이
        int m = pattern.length(); // 패턴의 길이
        int[] fail = getFailureFunction(pattern); // 실패 함수 계산

        int j = 0;
        for (int i = 0; i < n; i++) {
            while (j > 0 && text.charAt(i) != pattern.charAt(j)) {
                // 텍스트와 패턴이 일치하지 않으면 실패 함수를 이용하여 j를 갱신
                j = fail[j - 1];
            }
            if (text.charAt(i) == pattern.charAt(j)) {
                if (j == m - 1) {
                    // 패턴이 모두 일치한 경우, 매칭된 위치를 저장
                    result.add(i - m + 2);
                    // 다음 매칭을 위해 j를 실패 함수 값으로 갱신
                    j = fail[j];
                } else {
                    // 일치하는 경우, 다음 문자 비교를 위해 j를 증가
                    j++;
                }
            }
        }

        return result;
    }
}
