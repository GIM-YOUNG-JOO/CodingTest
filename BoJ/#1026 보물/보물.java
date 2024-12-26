import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		
		int[] arr1 = new int[n];
		int[] arr2 = new int[n];
		
		String[] str = br.readLine().split(" ");

		for (int i = 0; i < n; i++)
			arr1[i] = Integer.parseInt(str[i]);
		
		str = br.readLine().split(" ");

		for (int i = 0; i < n; i++)
			arr2[i] = Integer.parseInt(str[i]);

		Arrays.sort(arr1);
		Arrays.sort(arr2);
		
		for (int i = 0; i < n / 2; i++) {
            int temp = arr1[i];
            arr1[i] = arr1[n - 1 - i];
            arr1[n - 1 - i] = temp;
        }
		
		int answer = 0;
		
		for (int i = 0; i < n; i++)
			answer += arr1[i]*arr2[i];
		
		System.out.println(answer);
	}
}