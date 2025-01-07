import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[][] paper;
	final static int[] dx = new int[] { -1, 0, 1, 0 };
	final static int[] dy = new int[] { 0, -1, 0, 1 };
	static boolean[][] visited;
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] str = br.readLine().split(" ");

		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);

		visited = new boolean[n][m];
		paper = new int[n][m];

		for (int i = 0; i < n; i++) {
			str = br.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				paper[i][j] = Integer.parseInt(str[j]);
			}
		}

		for (int i = 0; i < paper.length; i++) {
			for (int j = 0; j < paper[0].length; j++) {
				visited[i][j] = true;
				tetromino(i, j, 1, paper[i][j]);
				visited[i][j] = false;
				tspin(i, j);
			}
		}

		System.out.println(max);

	}
	
	/* 테트리스 블록 DFS
	 ■ ■    ■ ■ ■   ■ ■   ■ ■ ■ ■
	   ■ ■      ■   ■ ■
    */
	private static void tetromino(int x, int y, int depth, int sum) {
		if (depth == 4) {
			max = Math.max(max, sum);
			return;
		}

		for (int i = 0; i < 4; i++) {
			int newX = x + dx[i];
			int newY = y + dy[i];

			if (newX < 0 || newX >= paper.length || newY < 0 || newY >= paper[0].length) {
				continue;
			} else {
				if (!visited[newX][newY]) {
					visited[newX][newY] = true;
			        tetromino(newX, newY, depth + 1, sum + paper[newX][newY]);
			        visited[newX][newY] = false;
				}
			}
		}
	}

	/*	T스핀 계산
		 ■ ■ ■
		   ■     */
	private static void tspin(int x, int y) {
		int sum = paper[x][y];
		for (int i = 0; i < 4; i++) {
			int newX = x + dx[i];
			int newY = y + dy[i];

			if (newX < 0 || newX >= paper.length || newY < 0 || newY >= paper[0].length) {
				continue;
			} else {
				sum += paper[newX][newY];
			}
		}
		
		//십자가 형태의 총합이 max보다 낮으면 계산해야 할 이유가 없음
		if(sum < max)
			return;

		for (int i = 0; i < 4; i++) {
			int newX = x + dx[i];
			int newY = y + dy[i];

			if (newX < 0 || newX >= paper.length || newY < 0 || newY >= paper[0].length) {
				//테두리에서 탐색을 시작할 때, 4방향 중 뺄 수 없는 경우가 나오면 그것대로 T스핀 모양이 됨
				if (max < sum) {
					max = sum;
				}
			} else {
				if (max < sum - paper[newX][newY]) {
					max = sum - paper[newX][newY];
				}
			}
		}
	}
}