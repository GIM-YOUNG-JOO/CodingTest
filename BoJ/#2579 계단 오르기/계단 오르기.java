import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(br.readLine());
		int[] stair = new int[tc + 1];
		int[] arr = new int[tc + 1];

		for (int i = 1; i <= tc; i++) {
			stair[i] = Integer.parseInt(br.readLine());
		}

		arr[0] = 0;
		arr[1] = stair[1];
		if (tc >= 2) {
			arr[2] = stair[1] + stair[2];
		}

		for (int i = 3; i <= tc; i++) {
			arr[i] = Math.max(arr[i - 2], arr[i - 3] + stair[i - 1]) + stair[i];
		}

		System.out.println(arr[tc]);
	}
}
