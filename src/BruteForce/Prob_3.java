package BruteForce;

import java.util.Scanner;

//예제 입력
//
//3 
//2 1 
//0 1 
//4 6 
//0 1 1 2 2 3 3 0 0 2 1 3 
//6 10 
//0 1 0 2 1 2 1 3 1 4 2 3 2 4 3 4 3 5 4 5
//예제 출력
//
//1
//3
//4



public class Prob_3 {
	
	static boolean areFriends[][];
	
	
	public static void main(String args[])
	{
		Scanner scan = new Scanner(System.in);
		boolean taken[];
		int testcase = scan.nextInt();
		
		while(testcase-->0)
		{
			int friendNum = scan.nextInt();
			int teamNum = scan.nextInt();
			
			areFriends = new boolean[friendNum][friendNum];
			
			while(teamNum-->0){
				int temp1 = scan.nextInt();
				int temp2 = scan.nextInt();
				
				areFriends[temp1][temp2] = true;
			}
			
			taken = new boolean[friendNum];
//			System.out.println(taken.length);
			System.out.println(countPairings(taken));
			
			
//			for (int i = 0; i < friendNum; i++) {
//				for (int j = 0; j < friendNum; j++) {
//					System.out.println(i + ","+j+" "+ areFriends[i][j]);
//				}
//			}
//			System.out.println("-------");
			//입력완료 
			
			
			
		}
	}
	
	static int countPairings(boolean taken[])
	{
		int firstFree = -1;
		
		for (int i = 0; i < taken.length; i++) {
			if(!taken[i]){
				firstFree = i;
				break;
			}
		}
		
		if(firstFree == -1) return 1;
		
		int ret = 0;
		
		for (int pairWith = firstFree + 1; pairWith < taken.length; pairWith++) {
			if(!taken[pairWith] && areFriends[firstFree][pairWith]){
				taken[firstFree] = taken[pairWith] = true;
				ret+=countPairings(taken);
				taken[firstFree] = taken[pairWith] = false;
			}
		}
		
		return ret;
	}

}
