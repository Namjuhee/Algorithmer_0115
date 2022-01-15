package codingTest_0115;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Algorithm_travlepath {
static ArrayList<String> result = new ArrayList<String>(); //String Ÿ���� ���ҷ� ���� List
    
    public static void main(String[] args) {
    	String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
    	Algorithm_travlepath s = new Algorithm_travlepath();
    	System.out.println(Arrays.toString(s.solution(tickets)));
    }
    
    public String[] solution(String[][] tickets) {
        //�湮��θ� �����ϱ����� �迭
    Boolean[] visited = new Boolean[tickets.length];
	Arrays.fill(visited, Boolean.FALSE);
        //����Ž�� ����
	dfs(visited, "ICN", "", tickets, 0);
        //���ĺ������� ���� ���� ��θ� �������� ���� ����
        Collections.sort(result);
        
        String[] answer = result.get(0).split(","); //result�� �迭�� �����ɴϴ�
        return answer;
    }
    
    static void dfs(Boolean[] visited, String station, String path, String[][] tickets, int index)  {
		if("".equals(path)) {
			path = station;
		}else {
			path = path + ","+ station;
		}		
		
		if(index == tickets.length) {
			result.add(path);
		}
		
		for(int i=0; i<tickets.length; i++) {
                        //������� ���� Ƽ���̰� ���� ��ΰ� ���� ��� => �湮�� ���� ������ ��� ��带 �����´�
			if(!visited[i] && tickets[i][0].equals(station)) {
				visited[i] = true;
				dfs(visited, tickets[i][1], path, tickets, index+1); //���� �ε��� ���Ҹ� �ֱ� ���� index+1���� ���ȣ��
				visited[i] = false; // �湮���� ����
			}
		}
	}
}