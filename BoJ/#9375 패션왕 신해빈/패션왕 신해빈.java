import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			HashMap<String, Integer> map = new HashMap<String, Integer>();
			int n = Integer.parseInt(br.readLine());
			
			for (int j = 0; j < n; j++) {
				String[] str = br.readLine().split(" ");
				map.compute(str[1], (key, val) -> (val == null ? 1 : val + 1)); // 메모리와 속도에 효율적인 compute 메서드 사용
			}
			int answer = 1;
			for (int cloth : map.values())
				answer *= (cloth + 1);
			sb.append(--answer + "\n");
		}
		
		sb.setLength(sb.length()-1);
		
		System.out.println(sb.toString());
	}
}