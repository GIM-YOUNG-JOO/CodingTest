import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int m = Integer.parseInt(br.readLine());
		int s = 0;
		int set = (1 << 20) - 1;
		int x = 0;

		for (int i = 0; i < m; i++) {
			String[] str = br.readLine().split(" ");
			
			if (str.length > 1 && !str[1].isEmpty())
				x = Integer.parseInt(str[1]);

			switch (str[0]) {
				case "add":
					s |= (1 << x - 1);
					break;
				case "remove":
					s &= ~(1 << x - 1);
					break;
				case "check":
					if ((s & (1 << (x - 1))) != 0) {
						sb.append("1\n");
					} else {
						sb.append("0\n");
					}
					break;
				case "toggle":
					s ^= (1 << (x - 1));
					break;
				case "all":
					s = set;
					break;
				case "empty":
					s = 0;
					break;
			}
		}
		bw.write(sb.toString());
		bw.close();
	}
}