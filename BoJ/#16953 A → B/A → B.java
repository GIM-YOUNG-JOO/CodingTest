import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int min = Integer.MAX_VALUE;
	static int a;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] str = br.readLine().split(" ");

		a = Integer.parseInt(str[0]);
		int b = Integer.parseInt(str[1]);

		change(b, 1);

		if (min == Integer.MAX_VALUE) {
			min = -1;
		}

		System.out.println(min);
	}

	private static void change(int b, int count) {
		
		if(b == a && min > count) {
			min = count;
		}

		if (b > a) {
			if (b % 2 == 0) {
				change(b / 2, count + 1);
			}

			String temp = "" + b;
			if (temp.substring(temp.length() - 1, temp.length()).equals("1")) {
				int c = Integer.parseInt(temp.substring(0, temp.length() - 1));
				change(c, count + 1);
			}
		}
	}
}