import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static boolean[][] visit;
	static int[][] complex;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		complex = new int[n][n];
		visit = new boolean[n][n];
		ArrayList<Integer> list = new ArrayList<Integer>();

		for (int i = 0; i < n; i++) {
			String[] str = br.readLine().split("");
			for (int j = 0; j < n; j++) {
				complex[i][j] = Integer.parseInt(str[j]);
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(!visit[i][j] && complex[i][j] == 1) {
					list.add(bfs(n, i, j));
				}
			}
		}
		
		Collections.sort(list);
		
		System.out.println(list.size());
		for(int i : list) {
			System.out.println(i);
		}
	}
	
	private static int bfs(int n, int x, int y) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] {x, y});
		visit[x][y] = true;
		int count = 1;
		
		while(!queue.isEmpty()) {
			int[] d = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nX = d[0] + dx[i];
				int nY = d[1] + dy[i];
				
				if (nX < n && nY < n && nX >= 0 && nY >= 0 && !visit[nX][nY] && complex[nX][nY] == 1) {
					queue.add(new int[] { nX, nY });
					visit[nX][nY] = true;
					count++;
				}
			}
		}
		
		return count;
	}
}