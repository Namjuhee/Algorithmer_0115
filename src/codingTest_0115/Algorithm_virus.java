package codingTest_0115;

//���� ��ǻ���� ������ �ƴ϶� ����� ���� ���� �����Ǵ°����� Ȯ�� ��
public class Algorithm_virus {
	public static void main(String[] args) {
		int[][] computers = {{1, 2}, {2, 3}, {1, 5}, {5, 2}, {5, 6}, {4, 7}};
		System.out.println(new Solution().solution(computers));
	}
	
	public static class Solution{
		public int solution(int[][] computers) {
			int answer = 0;
			boolean[] check = new boolean[computers.length];
			
			for (int i = 0; i < computers.length; i++) {
				if(check[i] == true) {
					answer++;
				}
				dfs(i, check, computers);
			}
			
			return answer;
		}
		
		public void dfs(int node, boolean[] check, int[][] computers) //DFS ���� �켱 Ž��
		{
			
			for (int i = 0; i < computers.length; i++) {
				for (int j = 0; j < 2; j++) {
					if (check[i] == false) {
						if(computers[node][0] == computers[i][j] || computers[node][1] == computers[i][j]) {
							check[node] = true;
							dfs(i, check, computers);

						}
					}
				}
			}
		}
	}
}
