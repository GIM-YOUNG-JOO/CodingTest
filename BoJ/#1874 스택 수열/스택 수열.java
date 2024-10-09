import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int cnt = 0;
		Stack<Integer> num = new Stack<Integer>();
		Stack<Integer> st = new Stack<Integer>();
		int[] seq = new int[n];
		for (int i = 0; i < n; i++) {
			num.push(n - i);
			seq[i] = Integer.parseInt(br.readLine());
		}

		while (cnt < n) {
			int a = seq[cnt];

			if (!num.isEmpty() && a >= num.peek()) {
				st.push(num.pop());
				sb.append("+\n");
			} else if (a == st.peek()) {
				st.pop();
				sb.append("-\n");
				cnt++;
			} else if (a < st.peek()) {
				sb.setLength(0);
				sb.append("NO");
				break;
			}
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}