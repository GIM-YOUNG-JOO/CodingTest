import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] str = br.readLine().split(" ");

		long a = Integer.parseInt(str[0]);
		long b = Integer.parseInt(str[1]);
		long c = Integer.parseInt(str[2]);

		long answer = 1;
		a = a % c; // a를 c로 나눈 나머지로 초기화 (a^b % c 계산이므로)

		while (b > 0) {
			if (b % 2 == 1) { // b가 홀수일 때
				answer = (answer * a) % c; // 현재 base를 결과에 곱하기
			}
			a = (a * a) % c; // base를 제곱
			b /= 2; // b를 2로 나누기
		}

		System.out.println(answer);
	}
}