import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		System.out.println(bfs(n, k));
	}

	private static int bfs(int n, int k) {
		Deque<Integer> deque = new LinkedList<Integer>();

		int[] dist = new int[100001];
		Arrays.fill(dist, -1);
		dist[n] = 0;
		deque.add(n);

		while (!deque.isEmpty()) {
			int cur = deque.poll();

			if (cur == k) {
				return dist[cur];
			}

			if (cur * 2 <= 100000) {
				if (dist[cur * 2] == -1 || dist[cur * 2] > dist[cur]) {
					dist[cur * 2] = dist[cur];
					deque.addFirst(cur * 2);
				}
			}

			if (cur + 1 < 100000) {
				if (dist[cur + 1] == -1 || dist[cur + 1] > dist[cur] + 1) {
					dist[cur + 1] = dist[cur] + 1;
					deque.addLast(cur + 1);
				}
			}

			if (cur - 1 >= 0) {
				if (dist[cur - 1] == -1 || dist[cur - 1] > dist[cur] + 1) {
					dist[cur - 1] = dist[cur] + 1;
					deque.addLast(cur - 1);
				}
			}

		}

		return -1;
	}
}
