package BruteForce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;


public class Prob_5 {

	
	static int dx[] = {1 ,0};
	static int dy[] = {0, 1};
	static int MAXCANDY = 0;
	static char[][] BOARD;
	
	public static void main(String args[]) throws Exception
	{
		new Prob_5().run();
		
	}
	private void run() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		MAXCANDY =Integer.valueOf(br.readLine());
		
		
		BOARD = new char[MAXCANDY][MAXCANDY];
		
		for (int i = 0; i < MAXCANDY; i++) {
			String tempBoard = br.readLine();
			for (int j = 0; j < MAXCANDY; j++) {
				BOARD[i][j] = tempBoard.charAt(j);
			}
		}
		System.out.println(getMaxCount(0,0));

	}
	
	
//	5
//	AAAAE
//	ABCDA
//	ABCDE
//	ABCDE
//	BBCDE
	
	static int CountCandy()
	{
		char temp;
		int count = 1;
		int maxCount = 0;
		
			for (int i = 0; i < MAXCANDY; i++) {
				temp = BOARD[i][0];
				for (int j = 1; j < MAXCANDY; j++) {
					if(temp == BOARD[i][j])
					{
						count++;
					}
					else
					{
						if(count > maxCount){
							maxCount = count;
						}
						
						count = 1;
						temp = BOARD[i][j];	
						
					}
					
				}
				if(count > maxCount){
					maxCount = count;
				}
				
			}
			
			count = 1;
			
			for (int i = 0; i < MAXCANDY; i++) {
				temp = BOARD[0][i];
				for (int j = 1; j < MAXCANDY; j++) {
					if(temp == BOARD[j][i])
					{
						count++;
					}
					else
					{
						if(count > maxCount){
							maxCount = count;
						}
						
						
						count = 1;
						temp = BOARD[j][i];	
					}
					
				}
				if(count > maxCount){
					maxCount = count;
				}
				
				
			}
	
		
		return maxCount;
	}
	
	static int getMaxCount(int startX, int startY)
	{
		int ret = 0;
		
		for (int direction = 0; direction < 2; direction++) {
			int nextY = startY+dy[direction], nextX = startX + dx[direction];
			
			if(!isRange(nextY, nextX))
				return 0;
			
			changeValue(startX,startY,nextX,nextY);
			
			int ret1 = CountCandy();
			
			changeValue(nextX,nextY,startX,startY);
			int ret2= getMaxCount(nextX, nextY);
			
			
			ret= Math.max(ret1, ret2);
			
		}
		
		
		return ret;
	}
	
	static boolean isRange(int y, int x)
	{
		if( (0 <= y && y <  MAXCANDY) && (0 <= x && x <  MAXCANDY ))
			return true;
		
		return false;
			
	}
	
	static void changeValue(int oldX, int oldY, int newX, int newY)
	{
		char temp = BOARD[oldY][oldX];
		BOARD[oldY][oldX] = BOARD[newY][newX];
		BOARD[newY][newX] = temp;
	}
}
