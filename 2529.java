import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_2529 {
    static int k;
    static String[] arr;
    static String[] num ={"0","1","2","3","4","5","6","7","8","9"};
    static boolean[] visit= new boolean[10];
    static LinkedList<String> res= new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k=Integer.parseInt(br.readLine());
        arr=new String[k];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<k; i++){
            arr[i]= st.nextToken();
        }
        permutation(0,"");
        System.out.println(res.getLast());
        System.out.println(res.get(0));
    }

    private static void permutation(int idx, String str) {
        if (idx == k + 1) {
            if(check(str)){
                res.add(str);
            }
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (!visit[i]) {
                visit[i] = true;
                permutation(idx + 1, str + num[i]);
                visit[i]=false;
            }
        }
    }
    private static boolean check(String str2){
        for(int i=0; i<k; i++){
            int a=str2.charAt(i)-'0';
            int b=str2.charAt(i+1)-'0';

            if(arr[i].equals(">")&&a<b) return false;
            if(arr[i].equals("<")&&a>b) return false;
        }
        return true;
    }
}

