import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");

		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);

		int[] tree = new int[n];

		str = br.readLine().split(" ");

		for (int i = 0; i < n; i++) {
			tree[i] = Integer.parseInt(str[i]);
		}

		System.out.println(func(tree, m));

	}

	private static long func(int[] tree, int m) {
		long high = Arrays.stream(tree).max().getAsInt();
		long low = 0;
		long mid = 0;

		while (low <= high) {
			long sum = 0;
			mid = (high + low) / 2;
			for (int i = 0; i < tree.length; i++) {
				if (tree[i] > mid)
					sum += tree[i] - mid;
			}
			if(sum == m) {
				break;
			} else if (sum >= m) {
				low = mid + 1;
			}
			else {
				high = mid - 1;
				mid = high;
			}
		}

		return mid;
	}
}