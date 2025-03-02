import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;
	static int n;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());

		arr = new int[n];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());

		int add = Integer.parseInt(st.nextToken());
		int sub = Integer.parseInt(st.nextToken());
		int mul = Integer.parseInt(st.nextToken());
		int div = Integer.parseInt(st.nextToken());

		dfs(1, add, sub, mul, div, arr[0]);
		
		System.out.println(max + "\n" + min);
	}

	//심심하니까 가변 파라미터 써보기
	private static void dfs(int... option) {

		if (option[0] == n) {
			max = Math.max(max, option[5]);
			min = Math.min(min, option[5]);
			return;
		}

		if (option[1] > 0)
			dfs(option[0] + 1, option[1] - 1, option[2], option[3], option[4], option[5] + arr[option[0]]);

		if (option[2] > 0)
			dfs(option[0] + 1, option[1], option[2] - 1, option[3], option[4], option[5] - arr[option[0]]);

		if (option[3] > 0)
			dfs(option[0] + 1, option[1], option[2], option[3] - 1, option[4], option[5] * arr[option[0]]);

		if (option[4] > 0)
			dfs(option[0] + 1, option[1], option[2], option[3], option[4] - 1, option[5] / arr[option[0]]);

	}
}