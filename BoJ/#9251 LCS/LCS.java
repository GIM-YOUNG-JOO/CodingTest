import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] a = br.readLine().split("");
		String[] b = br.readLine().split("");
		int[][] arr = new int[a.length + 1][b.length + 1];
		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j < arr[0].length; j++) {
				if (b[j - 1].equals(a[i - 1]))
					arr[i][j] = arr[i - 1][j - 1] + 1;
				else
					arr[i][j] = Math.max(arr[i - 1][j], arr[i][j - 1]);
			}
		}
		/*
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}*/
		
		System.out.println(arr[arr.length-1][arr[0].length-1]);
	}
}