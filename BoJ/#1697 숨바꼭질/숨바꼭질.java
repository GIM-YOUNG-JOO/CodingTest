import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] str = br.readLine().split(" ");
		int[] pos = new int[200001];
		boolean[] visit = new boolean[200001];

		int n = Integer.parseInt(str[0]);
		int k = Integer.parseInt(str[1]);

		pos[n] = 0;
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(n);

		while (!queue.isEmpty()) {
			n = queue.remove();

			if (n == k) {
				break;
			}

			if (n + 1 <= 100000 && !visit[n + 1]) {
				visit[n + 1] = true;
				pos[n + 1] = pos[n] + 1;
				queue.add(n + 1);
			}

			if (n - 1 >= 0 && !visit[n - 1]) {
				visit[n - 1] = true;
				pos[n - 1] = pos[n] + 1;
				queue.add(n - 1);
			}

			if (n * 2 <= 100000 && !visit[n * 2]) {
				visit[n * 2] = true;
				pos[n * 2] = pos[n] + 1;
				queue.add(n * 2);
			}
		}

		System.out.println(pos[k]);
	}
}