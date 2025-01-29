import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Set<Integer> aSet = new HashSet<Integer>();
		Set<Integer> bSet = new HashSet<Integer>();

		String[] str = br.readLine().split(" ");
		int a = Integer.parseInt(str[0]);
		int b = Integer.parseInt(str[1]);

		str = br.readLine().split(" ");
		for (int i = 0; i < a; i++) {
			aSet.add(Integer.parseInt(str[i]));
		}

		str = br.readLine().split(" ");
		for (int i = 0; i < b; i++) {
			bSet.add(Integer.parseInt(str[i]));
		}

		int temp = aSet.size();

		aSet.retainAll(bSet);

		int answer = temp + bSet.size() - aSet.size() * 2;

		System.out.println(answer);
	}
}