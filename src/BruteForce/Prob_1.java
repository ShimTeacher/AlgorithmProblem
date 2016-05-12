package BruteForce;

import java.util.ArrayList;

public class Prob_1 {
	static String lists[] = {"철수 ", "영희 ", "현보 ", "수연 ", "민철 ", "진우 "};
	public static void main(String args[])
	{
	
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		pick(6, list, 3);
		
	}
	 

	
	//n개의 원소중 m개를 고르는 모든 조합을 찾는 알고리즘 
	//pick(입력할 원소의 갯수, 원소의 배열, 앞으로 골라야할 원소의 수);
	static void pick(int n, ArrayList<Integer> list, int toPick)
	{
		if(toPick == 0){
			printPicked(list);
			return ;
		}
		
		int smallest = list.isEmpty() ? 0 : list.get(list.size()-1) + 1;
		for(int next = smallest; next < n; ++next){
			list.add(next);
			pick(n, list, toPick - 1);
			list.remove(list.size()-1);
		}
		
	}
	
	static void printPicked(ArrayList<Integer> list)
	{
		StringBuilder sb = new StringBuilder();
		for(int i : list)
		{
			sb.append(lists[i]);
		}
		System.out.println(sb);
	}
	
	
	//1부터 n까지 합을 계산하는 재귀 함수
	static int recursiveSum(int n)
	{
		if(n == 1){
			return 1;
		}
		return n + recursiveSum(n - 1);
	}
	
	//1부터 n까지 합을 계산하는 반복  함수
	static int sum(int n)
	{
		int ret = 0;
		for(int i = 1; i <= n; i++)
		{
			ret+=i;
		}
	
		return ret;
	}
}
