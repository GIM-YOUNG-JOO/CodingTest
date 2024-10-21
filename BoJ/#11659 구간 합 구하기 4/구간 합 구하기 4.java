import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(str[0]);
		int t = Integer.parseInt(str[1]);
		
		str = br.readLine().split(" ");
		int[] arr = new int[str.length+1];
		arr[0] = 0;
		for(int i = 1; i <= n; i++) {
			arr[i] += Integer.parseInt(str[i-1]) + arr[i-1];
		}
		
		for(int i = 0; i < t; i++) {
			str = br.readLine().split(" ");
			sb.append(arr[Integer.parseInt(str[1])] - arr[Integer.parseInt(str[0])-1] + "\n");
		}
		
		System.out.println(sb.toString());
	}
}