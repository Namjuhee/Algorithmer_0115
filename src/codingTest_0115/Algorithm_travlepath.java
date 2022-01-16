package codingTest_0115;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

//내가 놓쳤던 부분
//행선지 중복은 가능하지만 티켓 중복이 생기는걸 고려안함
//모든 도시를 방문할 수 있으므로 도시를 방문하는 경로를 구하고 알파벳 순서로 정렬
// 참고
// https://sang12.co.kr/278/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EC%BD%94%EB%94%A9%ED%85%8C%EC%8A%A4%ED%8A%B8-DFSBFS-%EC%97%AC%ED%96%89%EA%B2%BD%EB%A1%9C-JAVA

public class Algorithm_travlepath {
static ArrayList<String> result = new ArrayList<String>(); //String 타입을 원소로 갖는 List
    
    public static void main(String[] args) {
    	String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
    	Algorithm_travlepath s = new Algorithm_travlepath();
    	System.out.println(Arrays.toString(s.solution(tickets)));
    }
    
    public String[] solution(String[][] tickets) {
        //방문경로를 저장하기위한 배열
    Boolean[] visited = new Boolean[tickets.length];
	Arrays.fill(visited, Boolean.FALSE);
        //깊이탐색 시작
	dfs(visited, "ICN", "", tickets, 0);
        //알파벳순서로 가장 빠른 경로를 가져오기 위한 정렬
        Collections.sort(result);
        
        String[] answer = result.get(0).split(","); //result를 배열로 가져옵니다
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
                        //사용하지 않은 티켓이고 가는 경로가 있을 경우 => 방문한 노드와 인접한 모든 노드를 가져온다
			if(!visited[i] && tickets[i][0].equals(station)) {
				visited[i] = true;
				dfs(visited, tickets[i][1], path, tickets, index+1); //다음 인덱스 원소를 넣기 위해 index+1으로 재귀호출
				visited[i] = false; // 방문여부 해제
			}
		}
	}
}