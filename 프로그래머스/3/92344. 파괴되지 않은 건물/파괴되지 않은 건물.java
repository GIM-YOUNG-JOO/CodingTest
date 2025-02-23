class Solution {
    public int solution(int[][] board, int[][] skill) {
       int answer = 0;
			int[][] prefixSum = new int[board.length + 1][board[0].length + 1];
			
			for (int[] s : skill) {
				s[5] *= s[0] == 1 ? -1 : 1;
				prefixSum[s[1]][s[2]] += s[5];
				prefixSum[s[3] + 1][s[2]] -= s[5];
				prefixSum[s[1]][s[4] + 1] -= s[5];
				prefixSum[s[3] + 1][s[4] + 1] += s[5];
			}
			
			for (int i = 1; i < board.length; i++) {
				for (int j = 0; j < board[0].length; j++) {
					prefixSum[i][j] += prefixSum[i-1][j];
				}
			}
			
			for (int i = 0; i < board.length; i++) {
				for (int j = 1; j < board[0].length; j++) {
					prefixSum[i][j] += prefixSum[i][j-1];
				}
			}

			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board[0].length; j++) {
					if (board[i][j] + prefixSum[i][j] > 0)
						answer++;
				}
			}

			return answer;
    }
}