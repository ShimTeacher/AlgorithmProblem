package BruteForce;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//여행하는 외판원 문제 ( 시작점까지 돌아오지 않는 시작위치는 랜덤하다 .  )

//예제 입력
//
//2
//3
//0.0000000000  611.6157225201  648.7500617289
//611.6157225201  0.0000000000  743.8557967501
//648.7500617289  743.8557967501  0.0000000000
//4
//0.0000000000  326.0008994586  503.1066076077  290.0250922998
//326.0008994586  0.0000000000  225.1785728436  395.4019367384
//503.1066076077  225.1785728436  0.0000000000  620.3945520632
//290.0250922998  395.4019367384  620.3945520632  0.0000000000
//
//예제 출력
//
//1260.3657842490
//841.2045646020



public class Prob_4 {
	static int cityNum;
	static double map[][];
	static final int INF = 987654321;
	
	public static void main(String args[])
	{
		Scanner scan = new Scanner(System.in);
		int testcase = scan.nextInt();
		
		
		
		LinkedList<Integer> path; 
		boolean visited[];
		
		
		while(testcase-- >0)
		{
			cityNum = scan.nextInt();
			map = new double[cityNum][cityNum];
			visited = new boolean[cityNum];
			for (int i = 0; i < cityNum; i++) {
				for (int j = 0; j < cityNum; j++) {
					map[i][j] = scan.nextDouble();
				}
			}
			//입력완료
			
			double shortestPathResult=0.00;
			for (int i = 0; i < visited.length; i++) {
				path = new LinkedList<Integer>();
				shortestPathResult = INF;
				double result = shortestPath(i,path,visited,0);
				shortestPathResult = result < shortestPathResult ? result : shortestPathResult;
			}
			
			System.out.println(shortestPathResult);
		}
	}
	
	static double shortestPath(int startPoint, LinkedList<Integer> path,boolean visited[], double currentLength)
	{
		if(path.size() == cityNum)
		{
			return currentLength;
//			return currentLength + map[path.getFirst()][path.getLast()];
		}
		double ret = INF;
		
		int here =startPoint;
		for (int next = 0; next < cityNum; next++) {

			if(visited[next]) continue;
			
			
			try{
			here = path.getLast();
			}catch(Exception e)
			{
				
			}
			
			
			path.add(next);
			visited[next]= true;
			
			double cand = shortestPath(startPoint, path,visited,currentLength + map[here][next]);
			
			ret = Math.min(ret,cand);
			visited[next]=false;
			path.removeLast();
		}
		
		
		return ret;
	}
}
