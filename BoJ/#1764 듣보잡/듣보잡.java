import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		String[] str = br.readLine().split(" ");
		String name;
		int m = Integer.parseInt(str[0]);
		int n = Integer.parseInt(str[1]);
		int cnt = 0;
		
		HashSet<String> set = new HashSet<String>();
		ArrayList<String> list = new ArrayList<String>();

		
		for(int i = 0; i < m; i++) {
			set.add(br.readLine());
		}
		
		for(int i = 0; i < n; i++) {
			name = br.readLine();
			if(set.contains(name)) {
				list.add(name);
				cnt++;
			}
		}
		list.sort(Comparator.naturalOrder());
		bw.write("" + cnt);
		for(String a : list) {
			bw.write("\n" + a);
		}
		bw.flush();
		bw.close();
		
	}
}