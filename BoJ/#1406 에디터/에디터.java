import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String initial = br.readLine();
		int commandCount = Integer.parseInt(br.readLine());

		LinkedList<Character> list = new LinkedList<>();
		for (char c : initial.toCharArray()) {
			list.add(c);
		}

		ListIterator<Character> iter = list.listIterator(list.size());

		for (int i = 0; i < commandCount; i++) {
			String command = br.readLine();
			char cmd = command.charAt(0);
			switch (cmd) {
			case 'L':
				if (iter.hasPrevious()) {
					iter.previous();
				}
				break;
			case 'D':
				if (iter.hasNext()) {
					iter.next();
				}
				break;
			case 'B':
				if (iter.hasPrevious()) {
					iter.previous();
					iter.remove();
				}
				break;
			case 'P':
				iter.add(command.charAt(2));
				break;
			}
		}

		StringBuilder sb = new StringBuilder();
		for (char c : list) {
			sb.append(c);
		}
		System.out.println(sb.toString());
	}
}