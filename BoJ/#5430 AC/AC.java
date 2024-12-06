import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int tc = Integer.parseInt(br.readLine());

		for (int i = 0; i < tc; i++) {
			String p = br.readLine();
			Deque<String> deque = new ArrayDeque<String>();
			int n = Integer.parseInt(br.readLine());
			String temp = br.readLine();
			boolean reversOrder = false;
			String[] str = temp.substring(1, temp.length() - 1).split(",");
			for (int j = 0; j < n; j++) {
				deque.addLast(str[j]);
			}

			try {
				for (int j = 0; j < p.length(); j++) {
					if (p.charAt(j) == 'R') {
						reversOrder = !reversOrder;
					} else {
						if (reversOrder)
							deque.removeLast();
						else
							deque.removeFirst();
					}
				}
				if(!deque.isEmpty())
					sb.append(makeStr(deque.toArray(new String[deque.size()]), reversOrder) + "\n");
				else
					sb.append("[]\n");
			} catch (Exception e) {
				sb.append("error\n");
			}
		}

		sb.setLength(sb.length() - 1);

		System.out.println(sb.toString());
	}

	private static String makeStr(String[] str, boolean reverseOrder) {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		if (!reverseOrder) {
			for (int i = 0; i < str.length; i++) {
				sb.append(str[i] + ",");
			}
		} else {
			for (int i = str.length - 1; i >= 0; i--) {
				sb.append(str[i] + ",");
			}
		}

		sb.setLength(sb.length() - 1);
		sb.append("]");
		return sb.toString();
	}
}
