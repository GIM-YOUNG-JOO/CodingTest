import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<String, String> map = new HashMap<String, String>();
		
		String[] str = br.readLine().split(" ");
		
		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);
		
		for(int i = 0; i < n; i++) {
			str = br.readLine().split(" ");
			map.put(str[0], str[1]);
		}
		
		for(int i = 0; i < m; i++) {
			System.out.println(map.get(br.readLine()));
		}
    }
}