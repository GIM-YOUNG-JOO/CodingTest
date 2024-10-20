import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[][] field;
	final static int[] dx = { 0, 1, 0, -1 };
	final static int[] dy = { -1, 0, 1, 0 };
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int tc = Integer.parseInt(br.readLine());

		for (int t = 0; t < tc; t++) {
			String[] str = br.readLine().split(" ");
			int count = 0;
			int x = Integer.parseInt(str[0]);
			int y = Integer.parseInt(str[1]);
			int bug = Integer.parseInt(str[2]);
			visited = new boolean[x][y];
			field = new int[x][y];
			for (int i = 0; i < bug; i++) {
				str = br.readLine().split(" ");
				field[Integer.parseInt(str[0])][Integer.parseInt(str[1])] = 1;
			}

			/* 그래프 시각화
			for (int i = 0; i < y; i++) {
				for (int j = 0; j < x; j++) {
					System.out.print(field[j][i] + " ");
				}
				System.out.println();
			}*/
			
			for (int i = 0; i < y; i++) {
				for (int j = 0; j < x; j++) {
					if (field[j][i] == 1 && !visited[j][i]) {
						dfs(j, i);
						count++;
					}
				}
			}
			sb.append(count + "\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}

	private static void dfs(int x, int y) {
		visited[x][y] = true;

		for (int i = 0; i < 4; i++) {
			int newX = x + dx[i];
			int newY = y + dy[i];
			if (newX >= 0 && newY >= 0 && newX < field.length && newY < field[0].length && field[newX][newY] == 1
					&& !visited[newX][newY]) {
				dfs(newX, newY);
			}
		}
	}
}