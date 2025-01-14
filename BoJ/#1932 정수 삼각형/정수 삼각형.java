import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			String[] temp = br.readLine().split(" ");
			for(int j = 0; j <= i; j++) {
				arr[i][j] = Integer.parseInt(temp[j]);
			}
		}
		
		for (int i = 1; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				if (j == 0) {
					arr[i][j] += arr[i - 1][j];
				} else if (j == i) {
					arr[i][j] += arr[i - 1][j - 1];
				} else {
					arr[i][j] += Math.max(arr[i - 1][j - 1], arr[i - 1][j]);
				}
			}
		}
		
		int answer = Integer.MIN_VALUE;
		for(int i : arr[n-1]) {
			answer = Math.max(i, answer);
		}
		
		System.out.println(answer);
	}
}