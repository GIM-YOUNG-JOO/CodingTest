import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] targets = new int[m];
        LinkedList<Integer> deque = new LinkedList<Integer>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            targets[i] = Integer.parseInt(st.nextToken());
        }
        
        for(int i = n; i > 0; i--) {
        	deque.addFirst(i);
        }
        
        int target = 0;
        int answer = 0;

        while(target < m) {
        	int pos = deque.indexOf(targets[target]);
        	
        	if(pos <= deque.size() / 2) {
        		while(targets[target] != deque.peekFirst()) {
        			int temp = deque.pollFirst();
        			deque.addLast(temp);
        			answer++;
        		}
        		deque.pollFirst();
        	} else {
        		while(targets[target] != deque.peekFirst()) {
        			int temp = deque.pollLast();
        			deque.addFirst(temp);
        			answer++;
        		}
        		deque.pollFirst();
        	}
        	target++;
        }
        System.out.println(answer);
    }
}