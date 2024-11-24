import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		int answer = 0;
		boolean flag = false;
		StringTokenizer st = new StringTokenizer(str, "+-", true);
		if(str.contains("-")) {
			while(st.hasMoreTokens()) {
				String temp = st.nextToken();
				if(temp.equals("+")) {
					continue;
				} else if(temp.equals("-")) {
					flag = true;
					continue;
				} else {
					if(flag)
						answer -= Integer.parseInt(temp);
					else
						answer += Integer.parseInt(temp);
				}
			}
		} else {
			String[] temp = str.split("[-+]");
			
			for(String num : temp) {
				answer += Integer.parseInt(num);
			}
		}
		
		System.out.println(answer);
	}
}