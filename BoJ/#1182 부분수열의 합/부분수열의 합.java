import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int count = 0;
	static int n, s;
	static int[] arr;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] str = br.readLine().split(" ");

		n = Integer.parseInt(str[0]);
		s = Integer.parseInt(str[1]);

		arr = new int[n];
		visited = new boolean[n];
		str = br.readLine().split(" ");

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(str[i]);
		}

		dfs(0, 0);
        System.out.println(s == 0 ? count - 1 : count);
	}

	private static void dfs(int check, int sum) {
		if (sum == s)
			count++;
		for (int i = check; i < n; i++) {
			dfs(i + 1, sum + arr[i]);
		}
	}
}