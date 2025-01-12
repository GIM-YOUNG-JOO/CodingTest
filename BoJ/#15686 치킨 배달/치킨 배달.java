import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int[][] ch;
	static boolean[] visited;
	static int answer = Integer.MAX_VALUE;
	static int m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		ArrayList<int[]> chicken = new ArrayList<int[]>();
		ArrayList<int[]> house = new ArrayList<int[]>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				String temp = st.nextToken();
				if (temp.equals("1")) {
					house.add(new int[] { i, j });
				} else if (temp.equals("2")) {
					chicken.add(new int[] { i, j });
				}
			}
		}

		ch = new int[chicken.size()][house.size()];
		visited = new boolean[chicken.size()];

		for (int i = 0; i < chicken.size(); i++) {
			for (int j = 0; j < house.size(); j++) {
				ch[i][j] = distance(chicken.get(i), house.get(j));
			}
		}
/*
		System.out.println("=H== 0 1 2 3 =");
		System.out.println("C=============");
		for (int i = 0; i < chicken.size(); i++) {
			System.out.print(i + " || ");
			for (int j = 0; j < house.size(); j++) {
				System.out.print(ch[i][j] + " ");
			}
			System.out.println();
		}*/

		backTracking(0, 0);

		System.out.println(answer);
	}

	private static int distance(int[] chicken, int[] house) {
		return Math.abs(chicken[0] - house[0]) + Math.abs(chicken[1] - house[1]);
	}

	private static void backTracking(int idx, int count) {
	    if (count == m) {
	        int cityDistance = 0;

	        // 각 집에 대해 가장 가까운 치킨집과의 거리 계산
	        for (int j = 0; j < ch[0].length; j++) {
	            int min = Integer.MAX_VALUE;
	            for (int i = 0; i < ch.length; i++) {
	                if (visited[i]) {
	                    min = Math.min(min, ch[i][j]);
	                }
	            }
	            cityDistance += min;
	        }

	        answer = Math.min(answer, cityDistance);
	        return;
	    }

	    for (int i = idx; i < ch.length; i++) {
	        if (!visited[i]) {
	            visited[i] = true;
	            backTracking(i, count + 1);
	            visited[i] = false;
	        }
	    }
	}
}