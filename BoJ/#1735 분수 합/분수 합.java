import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//1735
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] str = br.readLine().split(" ");

		int molecular1 = Integer.parseInt(str[0]);
		int denominator1 = Integer.parseInt(str[1]);

		str = br.readLine().split(" ");

		int molecular2 = Integer.parseInt(str[0]);
		int denominator2 = Integer.parseInt(str[1]);

		molecular1 = molecular1 * denominator2 + molecular2 * denominator1;
		denominator1 *= denominator2;

		int gcd = eratosthenes(molecular1, denominator1);

		System.out.println(molecular1 / gcd + " " + denominator1 / gcd);
	}

	private static int eratosthenes(int a, int b) {
		if (a % b == 0) {
			return b;
		}
		return eratosthenes(b, a % b);
	}
}