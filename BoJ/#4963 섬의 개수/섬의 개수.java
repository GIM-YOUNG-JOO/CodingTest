import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int[] dx = {-1, -1, -1,  0,  0,  1,  1,  1};
    static int[] dy = {-1,  0,  1, -1,  1, -1,  0,  1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] str;
		while (true) {
			int count = 0;
			str = br.readLine().split(" ");
			int w = Integer.parseInt(str[0]);
			int h = Integer.parseInt(str[1]);
			if (w == 0 && h == 0)
				break;

			int[][] map = new int[h][w];
			boolean[][] visited = new boolean[h][w];
			
			for (int i = 0; i < h; i++) {
				str = br.readLine().split(" ");
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(str[j]);
				}
			}

			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (map[i][j] == 1 && !visited[i][j]) {
						visited[i][j] = true;
						bfs(i, j, map, visited);
						count++;
					}
				}
			}
			
			sb.append(count + "\n");
		}

		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}
	
	private static void bfs(int h, int w, int[][] map, boolean[][] visited) {
		Queue<int[]> queue = new LinkedList<int[]>();
		
		queue.offer(new int[] {h, w});
		
		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
			int x = temp[0];
			int y = temp[1];
			
			for(int i = 0; i < 8; i++) {
				int nX = x + dx[i];
				int nY = y + dy[i];
				
				if (nX >= 0 && nY >= 0 && nX < map.length && nY < map[0].length && map[nX][nY] == 1 && !visited[nX][nY]) {
					visited[nX][nY] = true;
					queue.offer(new int[] {nX, nY});
				}
			}
		}
	}
}