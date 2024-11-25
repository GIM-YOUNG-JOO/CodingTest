import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int min = Integer.MAX_VALUE;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		long[] tri = new long[100];
		tri[0] = tri[1] = tri[2] = 1;
		tri[3] = tri[4] = 2;
		for(int i = 5; i < 100; i++) {
			tri[i] = tri[i-1] + tri[i-5];
		}
		int t = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			sb.append(tri[n-1] + "\n");
		}
		
		sb.setLength(sb.length()-1);
		
		System.out.println(sb.toString());
	}
}