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

		int n = Integer.parseInt(br.readLine());
		int bus = Integer.parseInt(br.readLine());
		String[] str;
		
		// List의 인덱스 : 도시, ArrayList : 연결 된 도시
		List<ArrayList<Node>> list = new ArrayList<ArrayList<Node>>();

		for (int i = 0; i <= n; i++) {
			list.add(new ArrayList<Node>());
		}

		for (int i = 0; i < bus; i++) {
			str = br.readLine().split(" ");

			list.get(Integer.parseInt(str[0])).add(new Node(Integer.parseInt(str[1]), Integer.parseInt(str[2])));
		}

		str = br.readLine().split(" ");

		System.out.println(dijkstra(list, Integer.parseInt(str[0]), Integer.parseInt(str[1])));
	}

	private static int dijkstra(List<ArrayList<Node>> graph, int start, int end) {
		int n = graph.size();
		int[] dist = new int[n];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;

		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		pq.add(new Node(start, 0));

		while (!pq.isEmpty()) {
			Node pn = pq.poll(); // 우선순위 큐에서 poll
			int target = pn.target;
			
			if (target == end) {
	            return pn.distance;
	        }

			// 구해놓은 최단 거리보다 길다면 PASS
			if (pn.distance > dist[target]) {
				continue;
			}
			
			for(Node node : graph.get(target)) {
				int link = node.target;
                int distance = node.distance;

                if (dist[link] > dist[target] + distance) {
                	dist[link] = dist[target] + distance;
                	//System.out.println("삽입 노드 : " + link + "// 갱신 최단 거리 : " + dist[link]);
                    pq.add(new Node(link, dist[link]));
                }
			}
		}

		return dist[end];
	}
}