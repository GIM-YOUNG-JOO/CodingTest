import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[][] meeting = new int[n][2];
		String[] str;
		for(int i = 0; i < n; i++) {
			str = br.readLine().split(" ");
			meeting[i][0] = Integer.parseInt(str[0]);
			meeting[i][1] = Integer.parseInt(str[1]);
		}
		
		Arrays.sort(meeting, (a, b) -> (a[1] == b[1]) ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));
		
		int endTime = meeting[0][1];
		int count = 1;
		
		for(int i = 1; i < n; i++) {
			if(endTime <= meeting[i][0]) {
				count++;
				endTime = meeting[i][1];
			}
		}
		
		System.out.println(count);
	}
}
