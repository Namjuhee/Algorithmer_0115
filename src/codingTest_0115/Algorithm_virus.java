package codingTest_0115;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

// 접근 방식을 틀려서 컴퓨터의 갯수가 아니라 연결된 선의 수로 측정되어 코드 참조
// 참고
// https://heesangstudynote.tistory.com/43
public class Algorithm_virus {
	static int n;	//컴퓨터 수
	static int m;	//컴퓨터 연결 쌍
	static List<List<Integer>> graph;
	static boolean[] visited;
	static int count;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		graph = new LinkedList<>();
		visited = new boolean[n+1];
		
		int a, b;
		StringTokenizer st;
		
		for(int i=0; i<n+1; i++) {
			List<Integer> list = new LinkedList<>();
			graph.add(list);
		}
		
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		
		count = 0;
		dfs(1);
		
		bw.write(String.valueOf(count));
		bw.flush();
		bw.close();
		
	}
	
	static void dfs(int start) {
		visited[start] = true;

		List<Integer> tempList = graph.get(start);
		
		for(int i=0; i<tempList.size(); i++) {
			int temp = tempList.get(i);
			
			if(visited[temp] == false) {
				dfs(temp);
				count++;
			}
		}
	}
}
