import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
        
        if (n == 1) {
            System.out.println(1);
            return;
        }
        
		int a = 1, b = 2, temp;
        
        for (int i = 3; i <= n; i++) {
            temp = (a + b) % 15746;
            a = b;
            b = temp;
        }

		System.out.println(b);
	}
}
