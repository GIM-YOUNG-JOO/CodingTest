import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Main {
	static Map<Integer, Integer> map;
	static int[] board;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		board = new int[101];

		for (int i = 0; i <= 100; i++) {
			board[i] = 100;
		}

		map = new HashMap<Integer, Integer>();

		String[] str = br.readLine().split(" ");

		int ladder = Integer.parseInt(str[0]);
		int snake = Integer.parseInt(str[1]);
		for (int i = 0; i < ladder + snake; i++) {
			str = br.readLine().split(" ");
			map.put(Integer.parseInt(str[0]), Integer.parseInt(str[1]));
		}

		visited = new boolean[101];

		game();

		System.out.println(board[100]);
	}

	private static void game() {
		int count = 0;
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(1);
	    visited[1] = true;  // 시작점 방문 처리

	    while (!queue.isEmpty()) {
	        int size = queue.size(); // 현재 레벨의 노드 수
	        count++;

	        for (int s = 0; s < size; s++) { // 같은 레벨의 노드들 처리
	            int pos = queue.poll();

	            for (int i = 1; i <= 6; i++) {
	                int newPos = pos + i;

	                if (newPos > 100 || visited[newPos])
	                	continue;

	                visited[newPos] = true;

	                if (map.containsKey(newPos)) {
	                    newPos = map.get(newPos);
	                }

	                board[newPos] = Math.min(board[newPos], count);

	                // 도착하면 탐색 종료
	                if (newPos == 100) {
	                    return;
	                }

	                queue.add(newPos); // 큐에 추가
	            }
	        }
	    }
	}
}