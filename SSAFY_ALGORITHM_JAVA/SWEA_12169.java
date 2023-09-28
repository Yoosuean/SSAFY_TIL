import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
 
public class Solution {
    static int N;
    static int[] nums;
    static LinkedList<Integer> lis;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T=Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++) {
            lis=new LinkedList<>();
            N=Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            nums = new int[N];
             
            for(int i=0; i<N; i++) {
                nums[i]=Integer.parseInt(st.nextToken());
            }
             
            sb.append("#").append(tc).append(" ").append(lis()).append("\n");
         
        }
        System.out.println(sb);
    }
     
    static int lis() {
        lis.add(nums[0]);
        for(int i=1; i<N; i++) {
            // lis의 마지막 수 보다 i번째 수가 크다면 그냥 뒤에 삽입
            if(nums[i]>lis.getLast()) {
                lis.add(nums[i]);
            }
             
            // i번째 수에 대해, lis 벡터 내에서 그 수의 위치를 찾는다.
            int pos = binary_search(0,lis.size(),nums[i]);
            lis.set(pos, nums[i]);
        }
        return lis.size();
    }
     
    static int binary_search (int start, int end, int element) {
        // 이분탐색으로 lis에서 element 위치를 반환
        // lis 내에서만 탐색
        while(start<end) {
            int mid =(start+end)/2;
            if(element>lis.get(mid)) start = mid+1;
            else end=mid;
        }
        return end;
    }
}
