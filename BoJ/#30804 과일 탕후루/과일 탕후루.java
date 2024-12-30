import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] tang = new int[n];
		String[] str = br.readLine().split(" ");
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int max = Integer.MIN_VALUE;
		
		for(int i = 0; i < n; i++)
			tang[i] = Integer.parseInt(str[i]);
		
		int left = 0, right = 0, count = 0;
		
		while(right < n) {
			map.put(tang[right], map.getOrDefault(tang[right], 0) + 1);
			right++;
			if(map.size() > 2) {
				map.put(tang[left], map.get(tang[left]) - 1);
				if(map.get(tang[left]) == 0)
					map.remove(tang[left]);
				left++;
			}

			max = Math.max(max, right-left);

		}
		
		System.out.println(max);
	}
}