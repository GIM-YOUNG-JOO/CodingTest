import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer a, Integer b) {
				int abs1 = Math.abs(a);
				int abs2 = Math.abs(b);

				if (abs1 == abs2) {
					return a - b;
				}
				return abs1 - abs2;
			}
		});

		int tc = Integer.parseInt(br.readLine());

		for (int i = 0; i < tc; i++) {
			int temp = Integer.parseInt(br.readLine());

			if (temp == 0) {
				if (pq.isEmpty())
					sb.append(0 + "\n");
				else
					sb.append(pq.poll() + "\n");
			} else {
				pq.add(temp);
			}
		}

		sb.setLength(sb.length() - 1);

		System.out.println(sb.toString());
	}
}
