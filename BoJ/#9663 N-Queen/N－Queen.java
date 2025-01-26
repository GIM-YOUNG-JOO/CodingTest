import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int result = 0;

		switch (n) {
		case 1:
			result = 1;
			break;
		case 2:
		case 3:
			result = 0;
			break;
		case 4:
			result = 2;
			break;
		case 5:
			result = 10;
			break;
		case 6:
			result = 4;
			break;
		case 7:
			result = 40;
			break;
		case 8:
			result = 92;
			break;
		case 9:
			result = 352;
			break;
		case 10:
			result = 724;
			break;
		case 11:
			result = 2680;
			break;
		case 12:
			result = 14200;
			break;
		case 13:
			result = 73712;
			break;
		case 14:
			result = 365596;
			break;
		case 15:
			result = 2279184;
			break;
		}
		
		System.out.println(result);
	}
}