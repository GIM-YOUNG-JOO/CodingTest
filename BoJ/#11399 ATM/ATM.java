import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int[] p = new int[n];

		
		String[] str = br.readLine().split(" ");
		
		for (int i = 0; i < n; i++) {
			p[i] = Integer.parseInt(str[i]);
		}
		Arrays.sort(p);
		int temp = 0;
		int sum = 0;

		for (int i = 0; i < n; i++) {
			temp += p[i];
			sum += temp;
		}

		bw.write(sum + "");
		bw.flush();
		bw.close();
	}
}
