import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(br.readLine());

		for (int i = 0; i < tc; i++) {
			String[] str = br.readLine().split(" ");
			int n = Integer.parseInt(str[0]);
			int r = Integer.parseInt(str[1]);

			if (n < r) {
				int temp = n;
				n = r;
				r = temp;
			}

			sb.append(combination(n, r));
		}

		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}

	private static String combination(int n, int r) {
		if (r == 0 || (n - r) == 0)
			return "1\n";

		int max = Math.max(r, n - r);
		int min = Math.min(r, n - r);

		BigInteger molecule = new BigInteger("1");
		BigInteger denominator = new BigInteger("1");
		BigInteger temp;

		for (int i = n; i > max; i--) {
			temp = BigInteger.valueOf(i);
			molecule = molecule.multiply(temp);
		}

		for (int i = min; i >= 2; i--) {
			temp = BigInteger.valueOf(i);
			denominator = denominator.multiply(temp);
		}

		//System.out.println("분자 : " + molecule + "\n분모 : " + denominator);

		return molecule.divide(denominator) + "\n";
	}
}