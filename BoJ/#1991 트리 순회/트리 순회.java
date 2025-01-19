import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Map<String, TreeNode> treeMap = new HashMap<String, TreeNode>();

		char ch = 'A';

		for (int i = 0; i < n; i++) {
			String str = Character.toString((char)(ch + i));
			treeMap.put(str, new TreeNode(str));
		}

		for (int i = 0; i < n; i++) {
			String[] str = br.readLine().split(" ");
			TreeNode temp = treeMap.get(str[0]);
			if (!str[1].equals("."))
				temp.left = treeMap.get(str[1]);
			if (!str[2].equals("."))
				temp.right = treeMap.get(str[2]);
		}

		sb.append(preorderTraversal(treeMap.get("A"), new StringBuilder()) + "\n");
		sb.append(inorderTraversal(treeMap.get("A"), new StringBuilder()) + "\n");
		sb.append(postorderTraversal(treeMap.get("A"), new StringBuilder()));
		
		System.out.println(sb.toString());
	}

	private static String preorderTraversal(TreeNode node, StringBuilder sb) {
		if (node != null) {
			sb.append(node.root); // 루트 방문
			preorderTraversal(node.left, sb); // 왼쪽 서브트리 탐색
			preorderTraversal(node.right, sb); // 오른쪽 서브트리 탐색
		}
		return sb.toString();
	}

	private static String inorderTraversal(TreeNode node, StringBuilder sb) {
		if (node != null) {
			inorderTraversal(node.left, sb); // 왼쪽 서브트리 탐색
			sb.append(node.root); // 루트 방문
			inorderTraversal(node.right, sb); // 오른쪽 서브트리 탐색
		}
		return sb.toString();
	}

	private static String postorderTraversal(TreeNode node, StringBuilder sb) {
		if (node != null) {
			postorderTraversal(node.left, sb); // 왼쪽 서브트리 탐색
			postorderTraversal(node.right, sb); // 오른쪽 서브트리 탐색
			sb.append(node.root); // 루트 방문
		}
		return sb.toString();
	}
}

class TreeNode {
	String root;
	TreeNode left;
	TreeNode right;

	public TreeNode(String root) {
		this.root = root;
		this.left = null;
		this.right = null;
	}
}