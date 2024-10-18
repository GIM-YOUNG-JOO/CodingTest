import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int count = 0; // 방법의 수를 저장할 변수

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			backtrack(n);
			sb.append(count + "\n");
			count = 0;
		}
		System.out.println(sb.toString());
	}

	static void backtrack(int remaining) {
		if (remaining == 0) {
			count++; // 목표에 도달했을 때 카운트 증가
			return;
		}

		if (remaining < 0) {
			return; // 음수가 되면 종료
		}

		// 1, 2, 3, 4을 차례로 선택
		backtrack(remaining - 1);
		backtrack(remaining - 2);
		backtrack(remaining - 3);
	}

	static int recurrence(int n) {
		if (n == 1)
			return 1;
		else if (n == 2)
			return 2;
		else if (n == 3)
			return 4;

		else {
			int a = 1;
			int b = 2;
			int c = 4;
			int result = 0;

			for (int i = 4; i <= n; i++) {
		        result = a + b + c;
		        a = b;
		        b = c;
		        c = result;
			}
			return result;
		}
	}
}