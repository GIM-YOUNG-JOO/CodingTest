import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int x = Integer.parseInt(br.readLine());

		int count = 0;
		int zigzag = 0;

		while (count < x) {
			zigzag++;
			for (int i = 1; i <= zigzag; i++) {
				count++;
				if (count == x) {
					if (zigzag % 2 == 0)
						System.out.printf("%d/%d\n", i, zigzag + 1 - i);
					else
						System.out.printf("%d/%d\n", zigzag + 1 - i, i);
					break;
				}
			}
		}
	}
}