import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(br.readLine());
		int count = 0;

		for (int t = 0; t < tc; t++) {
			String str = br.readLine();
			HashSet<Character> set = new HashSet<Character>();
			boolean flag = false;

			for (int i = 1; i < str.length(); i++) {
				if(str.charAt(i) != str.charAt(i-1)) {
					if(set.contains(str.charAt(i))) {
						flag = true;
						break;
					}
					else
						set.add(str.charAt(i-1));
				}
					
			}
			
			if(!flag)
				count++;
		}
		
		System.out.println(count);
	}
}