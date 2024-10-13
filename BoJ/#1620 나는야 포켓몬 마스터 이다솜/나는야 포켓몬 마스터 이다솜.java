import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		String[] str = br.readLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);
		
		String[] pokemon = new String[n];
		HashMap<String, Integer> pokemonMap = new HashMap<>();
		
		for (int i = 0; i < n; i++) {
			pokemon[i] = br.readLine();
			pokemonMap.put(pokemon[i], i + 1);
		}
		
		for (int i = 0; i < m; i++) {
			String search = br.readLine();
			if (isNumeric(search)) {
				sb.append(pokemon[Integer.parseInt(search) - 1] + "\n");
			} else {
				sb.append(pokemonMap.get(search) + "\n");
			}
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	public static boolean isNumeric(String str) {
	    char[] isPokemon = str.toCharArray();
	    
	    if(Character.isDigit(isPokemon[0]))
	    	return true;
	    else
	    	return false;
	}
}