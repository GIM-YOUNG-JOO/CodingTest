import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());

		int[][] arr = new int[n][3];

		String[] str = br.readLine().split(" ");

		for (int i = 0; i < n; i++) {
			arr[i][0] = Integer.parseInt(str[i]);
			arr[i][1] = i;
		}

		Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
		
		int count = 0;
		arr[0][2] = count;
		
		for(int i = 1; i < n; i++) {
			if(arr[i][0] == arr[i-1][0])
				arr[i][2] = count;
			else
				arr[i][2] = ++count;
		}
		
		Arrays.sort(arr, (a, b) -> Integer.compare(a[1], b[1]));
		
		sb.append(arr[0][2]);
		
		for(int i = 1; i < n; i++)
			sb.append(" " + arr[i][2]);

		System.out.println(sb.toString());
	}
}