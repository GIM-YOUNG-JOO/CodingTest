import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int tc = Integer.parseInt(br.readLine());
		int end = 0;

		for (int t = 0; t < tc; t++) {
			HashSet<Integer> hashSet = new HashSet<Integer>();
			String[] str = br.readLine().split(" ");
			int M = Integer.parseInt(str[0]);
			int N = Integer.parseInt(str[1]);
			int x = Integer.parseInt(str[2]);
			int y = Integer.parseInt(str[3]);
			boolean flag = false;

			end = M * N / gcd(M, N); // 멸망하는 마지막 해(최소공배수)
			
			for(int i = x; i <= end; i += M) {
				hashSet.add(i);
			}
			
			for(int j = y; j <= end; j += N) {
				if(hashSet.contains(j)) {
					sb.append(j + "\n");
					flag = true;
					break;
				}
			}
			
			if(!flag)
				sb.append(-1 + "\n");
		}

		sb.setLength(sb.length()-1);
		System.out.println(sb.toString());
	}

	private static int gcd(int a, int b) {
		if (b == 0)
			return a;
		return gcd(b, a % b);
	}
}
