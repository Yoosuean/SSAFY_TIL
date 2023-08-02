import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class BOJ_2810 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(in.readLine());
		String seats=in.readLine();
		int res=0;
		// 배열로 입력받기
		//String [] seats = in.readLine().split("");
		
		int c_seat=0;
		for (String seat : seats.split("")) {
			if(seat.equals("L")) c_seat+=1;
		}
		res=N+1-(c_seat/2);
		if(res>N) System.out.println(N);
		else System.out.println(res);
	}

}
