import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] str = br.readLine().split(" ");

		int n = Integer.parseInt(str[0]);
		int k = Integer.parseInt(str[1]);
		int[] coin = new int[n];
		int count = 0;

		for (int i = 0; i < n; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}

		for (int i = n - 1; i >= 0; i--) {
			if(k >= coin[i]) {
				count += k / coin[i];
				k %= coin[i];
			}
		}
		
		bw.write(count + "");
		bw.flush();
		bw.close();
	}
}