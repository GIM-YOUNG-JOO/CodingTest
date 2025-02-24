import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Node implements Comparable<Node> {
	int target;
	int distance;

	public Node(int node, int dist) {
		this.target = node;
		this.distance = dist;
	}

	@Override
	public int compareTo(Node o) {
		return Integer.compare(this.distance, o.distance);
	}
}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String[] str = br.readLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);

		int point = Integer.parseInt(br.readLine());

		List<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();

		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<Node>());
		}

		for (int i = 0; i < m; i++) {
			str = br.readLine().split(" ");
			int start = Integer.parseInt(str[0]);
			int end = Integer.parseInt(str[1]);
			int w = Integer.parseInt(str[2]);
			graph.get(start).add(new Node(end, w));
		}

		int[] answer = dijkstra(graph, point);
		
		for(int i = 1; i <= n; i++) {
			if(answer[i] < Integer.MAX_VALUE)
				sb.append(answer[i] + "\n");
			else
				sb.append("INF" + "\n");
		}
		
		sb.setLength(sb.length()-1);
		System.out.println(sb.toString());
	}

	private static int[] dijkstra(List<ArrayList<Node>> graph, int start) {
		int n = graph.size();
		int[] dist = new int[n];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;

		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		pq.add(new Node(start, 0));

		 while (!pq.isEmpty()) {
			Node pn = pq.poll();
			int target = pn.target;

			if (pn.distance > dist[target]) {
				continue;
			}

			for (Node node : graph.get(target)) {
				int link = node.target;
				int newDistance = pn.distance + node.distance;

				if (newDistance < dist[link]) {
                    dist[link] = newDistance;
                    pq.add(new Node(link, newDistance));
                }
			}
		}

		return dist;
	}
}