import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] str = br.readLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);
		int b = Integer.parseInt(str[2]);
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int[][] field = new int[n][m];

		for (int i = 0; i < n; i++) {
			str = br.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				field[i][j] = Integer.parseInt(str[j]);
				if (field[i][j] > max)
					max = field[i][j];
				if (field[i][j] < min)
					min = field[i][j];
			}
		}

		int answer1 = Integer.MAX_VALUE;
		int answer2 = 0;
		for (int x = min; x <= max; x++) {
			int inventory = b;
			int time = 0;
			for (int[] arr : field) {
				for (int i : arr) {
					int diff = x - i;
					if (diff > 0) {
						time += diff;
						inventory -= diff;
					} else if (diff < 0) {
						time += diff * -2;
						inventory -= diff;
					}
				}
			}
			
			//System.out.println(time + " " + x + "///" + inventory);
			
			if (inventory >= 0) {
				if (time <= answer1) {
					answer1 = time;
					answer2 = x;
				}
			}
			
			
		}
		System.out.println(answer1 + " " + answer2);
	}
}