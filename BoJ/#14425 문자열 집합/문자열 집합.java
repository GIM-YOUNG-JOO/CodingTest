import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Set<String> set = new HashSet<String>();

		String[] str = br.readLine().split(" ");

		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);
		int answer = 0;

		for (int i = 0; i < n; i++) {
			set.add(br.readLine());
		}
		
		for (int i = 0; i < m; i++) {
			if(set.contains(br.readLine()))
				answer++;
		}
		
		System.out.println(answer);
	}
}