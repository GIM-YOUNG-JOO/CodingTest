import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int[] dx = { -2, -1, 1, 2, 2, 1, -1, -2 };
	static int[] dy = { 1, 2, 2, 1, -1, -2, -2, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input;
		StringBuilder sb = new StringBuilder();

		int tc = Integer.parseInt(br.readLine());

		for (int t = 0; t < tc; t++) {
			int l = Integer.parseInt(br.readLine());
			input = br.readLine().split(" ");
			int knightX = Integer.parseInt(input[0]);
			int knightY = Integer.parseInt(input[1]);
			input = br.readLine().split(" ");
			int targetX = Integer.parseInt(input[0]);
			int targetY = Integer.parseInt(input[1]);

			sb.append(bfs(l, new int[] { knightX, knightY }, new int[] { targetX, targetY }) + "\n");
		}

		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}

	private static int bfs(int boardSize, int[] knight, int[] goal) {
		boolean[][] visited = new boolean[boardSize][boardSize];

		Queue<int[]> queue = new LinkedList<int[]>();
		visited[knight[0]][knight[1]] = true;
		queue.offer(knight);
		int count = 0;

		while (!queue.isEmpty()) {
			int qs = queue.size();
			for (int i = 0; i < qs; i++) {
				int[] temp = queue.poll();
				
				if (Arrays.equals(temp, goal))
					return count;

				int knightX = temp[0];
				int knightY = temp[1];

				for (int move = 0; move < 8; move++) {
					int nX = knightX + dx[move];
					int nY = knightY + dy[move];

					if (nX >= 0 && nY >= 0 && nX < boardSize && nY < boardSize && !visited[nX][nY]) {
						visited[nX][nY] = true;
						queue.offer(new int[] { nX, nY });
					}
				}
			}
			count++;
		}

		return -1;
	}
}
