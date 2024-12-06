import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());

		for (int t = 0; t < tc; t++) {
			int n = Integer.parseInt(br.readLine());
			TreeMap<Integer, Integer> set = new TreeMap<>();

			for (int i = 0; i < n; i++) {
				String[] str = br.readLine().split(" ");
				if (str[0].equals("I")) {
					int value = Integer.parseInt(str[1]);
					set.put(value, set.getOrDefault(value, 0) + 1);
				} else if (str[0].equals("D") && !set.isEmpty()) {
					if (str[1].equals("1")) {
                        int maxKey = set.lastKey();
                        if (set.get(maxKey) == 1) {
                            set.pollLastEntry();
                        } else {
                            set.put(maxKey, set.get(maxKey) - 1);
                        }
                    } else if (str[1].equals("-1")) {
                        int minKey = set.firstKey();
                        if (set.get(minKey) == 1) {
                            set.pollFirstEntry();
                        } else {
                            set.put(minKey, set.get(minKey) - 1);
                        }
                    }
				}
			}

			if (set.isEmpty())
				sb.append("EMPTY\n");
			else {
				sb.append(set.lastEntry().getKey() + " " + set.firstEntry().getKey() + "\n");
			}
		}

		sb.setLength(sb.length() - 1);

		System.out.println(sb.toString());
	}
}