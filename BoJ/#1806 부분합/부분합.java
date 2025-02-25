import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		String[] input = br.readLine().split(" ");
		int[] arr = new int[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}
		
		int min = Integer.MAX_VALUE;
		int left = 0, right = 0;
		long sum = arr[left];
		
		while(right < n) {
			if(sum < s) {
				right++;
				if(right == n)
					break;
				sum += arr[right];
			} else {
				min = Math.min(min, right - left + 1);
				while(sum >= s) {
					min = Math.min(min, right - left + 1);
					sum -= arr[left++];
				
				}
			}
		}
		
		System.out.println(min == Integer.MAX_VALUE ? 0 : min);
	}
}