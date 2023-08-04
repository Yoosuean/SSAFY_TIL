package swea_algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class SWEA_1218 {
    static char[] brackets;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder("");
        Stack<Character> stack = new Stack<Character>();
        
        for (int tc = 1; tc <= 10; tc++) {
            
            /** 입력 */
            int N = Integer.parseInt(br.readLine());
            brackets = new char[N];
            brackets = br.readLine().toCharArray();
            stack.push(brackets[0]);
            
            /** 구현 */
            int answer = 1;
            // 괄호 유효성 검사
            for (int i = 1; i < N; ++i) {
                // brackets 배열을 돌면서 괄호 검사
                if (brackets[i] == ')') {
                    // stack의 최상단에 여는 괄호가 없을 시 유효성 검사 실패
                    if (stack.peek() != '(') {
                        answer = 0;
                        break;
                    }
                    // stack의 최상단에 여는 괄호가 있으면 스택에서 제거
                    else {
                        stack.pop();
                        continue;
                    }
                }
                else if (brackets[i] == ']') {
                    if (stack.peek() != '[') {
                        answer = 0;
                        break;
                    }
                    else {
                        stack.pop();
                        continue;
                    }
                }
                else if (brackets[i] == '}') {
                    if (stack.peek() != '{') {
                        answer = 0;
                        break;
                    }
                    else {
                        stack.pop();
                        continue;
                    }
                }
                else if (brackets[i] == '>') {
                    if (stack.peek() != '<') {
                        answer = 0;
                        break;
                    }
                    else {
                        stack.pop();
                        continue;
                    }
                }
                // 닫는 괄호가 아닐시에 스택에 넣기
                else {
                    stack.push(brackets[i]);
                }
            }
            
            // 스택이 비어있지 않아도 문자열은 유효하지 않음.
            if (!stack.isEmpty()) {
                answer = 0;
            }
      
            
            // 다음 테스트를 위해 stack 초기화
            stack.clear();
                    
            
            sb.append("#").append(tc).append(" ").append(answer);
            System.out.println(sb);
            sb.setLength(0);
        }
    }
}
