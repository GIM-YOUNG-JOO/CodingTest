import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[][] min_score = new int[n][3];
		int[][] max_score = new int[n][3];
		
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;

		String[] str;

		for (int i = 0; i < n; i++) {
			str = br.readLine().split(" ");
			for (int j = 0; j < 3; j++) {
				min_score[i][j] = max_score[i][j] = Integer.parseInt(str[j]);
			}
		}

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < 3; j++) {
				switch (j) {
				case 0:
					min_score[i][j] = Math.min(min_score[i - 1][j], min_score[i - 1][j + 1]) + min_score[i][j];
					max_score[i][j] = Math.max(max_score[i - 1][j], max_score[i - 1][j + 1]) + max_score[i][j];
					break;
				case 1:
					min_score[i][j] = Math.min(min_score[i - 1][j - 1], Math.min(min_score[i - 1][j], min_score[i - 1][j + 1])) + min_score[i][j];
					max_score[i][j] = Math.max(max_score[i - 1][j - 1], Math.max(max_score[i - 1][j], max_score[i - 1][j + 1])) + max_score[i][j];
					break;
				case 2:
					min_score[i][j] = Math.min(min_score[i - 1][j - 1], min_score[i - 1][j]) + min_score[i][j];
					max_score[i][j] = Math.max(max_score[i - 1][j - 1], max_score[i - 1][j]) + max_score[i][j];
					break;
				}
			}
		}
		
		for(int i = 0; i < 3; i++) {
			max = Math.max(max, max_score[n-1][i]);
			min = Math.min(min, min_score[n-1][i]);
		}

		System.out.println(max + " " + min);
	}
}