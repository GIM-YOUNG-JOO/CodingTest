import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] str = br.readLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int k = Integer.parseInt(str[1]);

		Queue<Integer> list = new LinkedList<Integer>();
		
		for(int i = 1; i <= n; i++) {
			list.add(i);
		}

		sb.append("<");
		while (!list.isEmpty()) {
			for (int i = 1; i < k; i++) {
				list.add(list.poll());
			}

			sb.append(list.poll() + ", ");
		}
		sb.setLength(sb.length()-2);
		sb.append(">");

		System.out.println(sb.toString());
	}
}