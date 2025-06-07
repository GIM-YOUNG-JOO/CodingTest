import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;
        String[] str = br.readLine().split("");
        int toggle = 0;
        boolean weight = false;
        for (int i = 0; i < str.length; i++) {

            if (toggle == 0) {
                if (str[i].equals("*")) {
                    toggle = 1 - toggle;
                    continue;
                }
                int temp = Integer.parseInt(str[i]);
                answer += temp;
            } else {
                if (str[i].equals("*")) {
                    weight = true;
                    toggle = 1 - toggle;
                    continue;
                }
                int temp = Integer.parseInt(str[i]) * 3;
                answer += temp;
            }
            toggle = 1 - toggle;
        }
        if(weight)
            System.out.println((10 - answer % 10) * 7 % 10);
        else
            System.out.println(10 - answer % 10);
        br.close();
    }
}