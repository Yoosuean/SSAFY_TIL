package SSAFY_ALGORITHM_JAVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1244 {
    
    public static void main(String[] args) throws NumberFormatException, IOException {
    	
    	/** 입력 */
    	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int S=Integer.parseInt(in.readLine());
        String[] str=in.readLine().split(" ");
        int num=Integer.parseInt(in.readLine());
        int[] s_list=new int[S+1];

        for(int i=1; i<s_list.length; i++) {
            s_list[i]=Integer.parseInt(str[i-1]);
        }
        
        /** 구현 */
        for(int i=0; i<num; i++) {
            String[] input = in.readLine().split(" ");
        	int students=Integer.parseInt(input[0]);
            int idx=Integer.parseInt(input[1]);
            int cnt1=1;
            int cnt2=1;
            
            // 남학생
            if(students==1) {
                while((idx*cnt1)<=S) {                	
                    s_list[idx*cnt1]=change(s_list[idx*cnt1]);
                    cnt1++;
                }
                
            }
            // 여학생
            else {
                s_list[idx]=change(s_list[idx]);
                while(true) {
                    if((idx+cnt2)<=S&&(idx-cnt2)>=0&&s_list[idx+cnt2]==s_list[idx-cnt2]) {
                        s_list[idx+cnt2]=change(s_list[idx+cnt2]);
                        s_list[idx-cnt2]=change(s_list[idx-cnt2]);
                        cnt2++;
                    } else {
                        break;
                    }
                    
                }
                
            }
        }
        
        /** 출력 */
        for(int i=1; i<s_list.length; i++) {
        	System.out.print(s_list[i]+" ");
        }
            
     }
    
    /** 0, 1 스위치함수 */
    private static int change(int curr) {
        if(curr==1) return 0;
        else return 1;
    }
}
