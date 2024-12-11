import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");

		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);
		int[] dx = { 0, 1, 0, -1 };
		int[] dy = { 1, 0, -1, 0 };
		boolean[][] visit = new boolean[n][m];
		String[][] campus = new String[n][m];
		Queue<int[]> queue = new LinkedList<int[]>();
		int friends = 0;

		for (int i = 0; i < n; i++) {
			str = br.readLine().split("");
			for (int j = 0; j < m; j++) {
				campus[i][j] = str[j];

				if (str[j].equals("I")) {
					queue.add(new int[] { i, j });
					visit[i][j] = true;
				}
			}
		}

		while (!queue.isEmpty()) {
			int[] d = queue.poll();
			int x = d[0];
			int y = d[1];
			for (int i = 0; i < 4; i++) {
				int nX = x + dx[i];
				int nY = y + dy[i];

				if (nX >= 0 && nY >= 0 && nX < n && nY < m && !visit[nX][nY] && !campus[nX][nY].equals("X")) {
					if (campus[nX][nY].equals("P"))
						friends++;
					queue.add(new int[] { nX, nY });
					visit[nX][nY] = true;
				}
			}
		}
		
		
		if(friends == 0)
			System.out.println("TT");
		else
			System.out.println(friends);
	}
}