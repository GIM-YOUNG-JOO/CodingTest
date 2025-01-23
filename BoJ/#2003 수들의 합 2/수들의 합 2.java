import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] str = br.readLine().split(" ");

		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);
		int[] arr = new int[n];

		str = br.readLine().split(" ");

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(str[i]);
		}
		int right = 0;
		int left = 0;

		int num = 0;
		int count = 0;

		while (right < n) {
			num += arr[right];

			while (num > m) {
				num -= arr[left];
				left++;
			}

			if (num == m) {
				count++;
			}

			right++;
		}

		System.out.println(count);
	}
}