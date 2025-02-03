import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		
		int stack = 0;
		int answer = 0;
		
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == '(') {
				if(i < str.length()-1 && str.charAt(i+1) == ')') {
					i++;
					answer += stack;
				} else {
					stack++;
				}
			} else {
				answer++;
				stack--;
			}
		}
		
		System.out.println(answer);
	}
}