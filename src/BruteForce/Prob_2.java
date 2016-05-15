package BruteForce;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

//보글 게임판에서 해당위치에서 주어진 단어가 시작하는지를 반환 

//INPUT

//1
//URLPM
//XPRET
//GIAET
//XTNZY
//XOQRS
//6
//PRETTY
//GIRL
//REPEAT
//KARA
//PANDORA
//GIAZAPX

//OUTPUT

//PRETTY YES
//GIRL YES
//REPEAT YES
//KARA NO
//PANDORA NO
//GIAZAPX YES

public class Prob_2 {
	
	final static int width =5;
	final static int height =5;
	final static int dx[] = {-1, -1, -1, 1, 1, 1, 0, 0};
	final static int dy[] = {-1, 0, 1, -1, 0, 1, -1, 1};
	static char[][] board = new char[5][5];
	
	public static void main(String args[])
	{
		Scanner scan = new Scanner(System.in);	
		HashMap<String, Integer> result = new HashMap<String, Integer>();
		
		int testcase = scan.nextInt();
		String words[];
		
		//***************입력 받기 위한 CODE *********************//
		for (int i = 0; i < width; i++) {
			String tempBoard = scan.next();
			for (int j = 0; j < height; j++) {
				board[i][j] = tempBoard.charAt(j);
			}
		}
		
		int wordsSize = scan.nextInt();
		words = new String[wordsSize];
		
		for (int i = 0; i < wordsSize; i++) {
			words[i] = scan.next();
			result.put(words[i], 0);
		}
		//***************입력 받기 위한 CODE *********************//
		
		//입력 본문 
		for(String tempWords : words){
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					if(hasWord(i, j, tempWords)){
						result.put(tempWords, 1);
					}
				}
			}
		}
		
		//결과 출력 
		for(String str : result.keySet()){
			String resultBoolean = result.get(str) == 1 ? "YES" : "NO";    
			System.out.println(str +"  "+resultBoolean);
		}
	}

	static boolean hasWord(int y, int x,final String word)
	{
		if(!inRange(y,x))
			return false;
		
		if(board[y][x] != word.charAt(0))
			return false;
		
		if(word.length() == 1)
			return true;
		
		for (int direction = 0; direction < 8; direction++) {
			int nextY = y + dy[direction];
			int nextX = x + dx[direction];
			
			if(hasWord(nextY, nextX, word.substring(1)))
				return true;
		}
	
		return false;
	}
	
	static boolean inRange(int y, int x)
	{
		if(!(y >= 0 && y < width))
			return false;
		
		if(!(x >= 0 && x < height))
			return false;
		
		return true;
	}
}
