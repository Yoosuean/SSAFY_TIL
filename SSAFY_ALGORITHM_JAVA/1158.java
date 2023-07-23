import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		int N=sc.nextInt();
		int K=sc.nextInt();
		Queue<Integer> q = new LinkedList<>();
		
		for (int i=1; i<=N; i++) {
			q.offer(i);
		}
		
		StringBuilder sb=new StringBuilder();
		sb.append("<");
		
		while (q.size()>1) {
			for(int i=0; i<K-1; i++) {
				q.offer(q.poll());
			}
			sb.append(q.poll()).append(", ");
		}
		sb.append(q.poll()).append(">");
		System.out.println(sb);
		
	}

}
