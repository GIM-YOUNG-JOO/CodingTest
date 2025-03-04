import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
	int point, time;

	public Node(int point, int time) {
		this.point = point;
		this.time = time;
	}

	@Override
	public int compareTo(Node o) {
		return this.time - o.time;
	}
}

public class Main {
	static ArrayList<ArrayList<Node>> map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int max = Integer.MIN_VALUE;
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());

		map = new ArrayList<>();

		for (int i = 0; i <= n; i++) {
			map.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			map.get(Integer.parseInt(st.nextToken()))
					.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}

		for (int i = 1; i <= n; i++) {
			max = Math.max(max, dijkstra(i, x) + dijkstra(x, i));
		}

		System.out.println(max);
	}

	private static int dijkstra(int startTown, int destinationTown) {
		int n = map.size();
		int[] minTime = new int[n];
		Arrays.fill(minTime, Integer.MAX_VALUE);
		minTime[startTown] = 0;

		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(startTown, 0));

		while (!pq.isEmpty()) {
			Node current = pq.poll();
			int currentTown = current.point;

			if (currentTown == destinationTown)
				return minTime[destinationTown];

			if (current.time > minTime[currentTown])
				continue;

			for (Node neighbor : map.get(currentTown)) {
				int nextTown = neighbor.point;
				int travelTime = neighbor.time;

				if (minTime[nextTown] > minTime[currentTown] + travelTime) {
					minTime[nextTown] = minTime[currentTown] + travelTime;
					pq.add(new Node(nextTown, minTime[nextTown]));
				}
			}
		}
		return -1;
	}
}
