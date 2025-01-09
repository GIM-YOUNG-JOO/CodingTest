import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		long[] answer = new long[n];

		for (int i = 0; i < n; i++) {
			String[] str = br.readLine().split(" ");
			int start = Integer.parseInt(str[0]);
			int end = Integer.parseInt(str[1]);

			answer[i] = dslr(start, end);
		}


		for (long dab : answer) {
			StringBuilder tempSb = new StringBuilder();
			while (dab > 0) {
				long temp = dab % 10;

				if (temp == 1)
					tempSb.append("D");
				else if (temp == 2)
					tempSb.append("S");
				else if (temp == 3)
					tempSb.append("L");
				else if (temp == 4)
					tempSb.append("R");
				dab /= 10;
			}
			sb.append(tempSb.reverse()).append("\n");
		}

		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}

	private static long dslr(int start, int end) {
		boolean[] visited = new boolean[10000];
		Queue<long[]> queue = new LinkedList<long[]>();
		queue.add(new long[] { start, 0 });
		while (!queue.isEmpty()) {
			for (int i = 0; i < queue.size(); i++) {
				long[] num = queue.poll();

				if (num[0] == end) {
					return num[1];
				}

				num[1] *= 10;

				// D Case
				int dCase = (int) (num[0] * 2) % 10000;
				if (!visited[dCase]) {
					visited[dCase] = true;
					queue.add(new long[] { dCase, num[1] + 1 });
				}

				int sCase = (int) num[0] - 1;
				if (sCase < 0)
					sCase = 9999;

				if (!visited[sCase]) {
					visited[sCase] = true;
					queue.add(new long[] { sCase, num[1] + 2 });
				}

				int lCase = lCase(num[0]);
				if (!visited[lCase]) {
					visited[lCase] = true;
					queue.add(new long[] { lCase, num[1] + 3 });
				}

				int rCase = rCase(num[0]);
				if (!visited[rCase]) {
					visited[rCase] = true;
					queue.add(new long[] { rCase, num[1] + 4 });
				}
			}
		}
		return 0;
	}

	private static int lCase(long num) {
		if (num == 0)
			return 0;
		else if (num * 10 >= 10000) {
			long temp = num / 1000;
			num = (num * 10) % 10000;
			return (int) (num + temp);
		} else {
			return (int) (num * 10);
		}
	}

	private static int rCase(long num) {
		if (num == 0)
			return 0;
		else {
			long temp = num % 10;
			num /= 10;
			return (int) (num + temp * 1000);
		}
	}
}