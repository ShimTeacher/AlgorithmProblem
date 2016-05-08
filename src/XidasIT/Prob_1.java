package XidasIT;
import java.util.Arrays;
import java.util.Scanner;

import XidasIT.Circle;

public class Prob_1 {
	public static void main(String args[])
	{
		Scanner NumScn = new Scanner(System.in);
		int numOfCircle = NumScn.nextInt();
		int tempNumOfCircle = numOfCircle;
		Circle circle[] = new Circle[numOfCircle];
		int i =0;
		
		// 데이터 입력 
		while(numOfCircle-->0){
			int id = NumScn.nextInt();
			double x = NumScn.nextDouble();
			double y = NumScn.nextDouble();
			double rad = NumScn.nextDouble();
			circle[i++] = new Circle(id, x, y, rad);
		}
		
		//circle을 ID 으로 정렬.
		Arrays.sort(circle);
		for(Circle cir : circle)
			cir.showCircle();
		
		
		System.out.println("START");
		for(int temp = 0; temp<tempNumOfCircle; temp++)
		{
			for(int j = temp+1; j<tempNumOfCircle; j++)
			{
				if(circle[temp].isOverlapCircle(circle[j]))
				{
					System.out.println(circle[temp].ID+" "+circle[j].ID);
				}
				
			}
		}
		
		System.out.println(" END ");
	
	}
}

class Circle implements Comparable <Circle>
{
	int ID;
	double x;
	double y;
	double rad;
	
	Circle(int id, double x, double y, double rad)
	{
		this.ID = id;
		this.x = x;
		this.y = y;
		this.rad = rad;
	}
	
	public void showCircle()
	{
		System.out.println("ID: " + ID+ ", x: "+x+", y: "+y+", rad: "+rad);
	}
	
	public boolean isOverlapCircle(Circle input)
	{
		double ResultRad = this.rad + input.rad;
		double ResultX = this.x- input.x;
		double ResultY = this.y- input.y;

		double length = Math.sqrt(Math.pow(ResultX, 2)+Math.pow(ResultY, 2));
		if(length< ResultRad)
		{
			
			return true;
		}
		else
		{
			return false;
		}
		
	}
	

	public int compareTo(Circle obj){
		Circle other = (Circle)obj;
		if(this.ID >other.ID)
			return 1;
		else if(this.ID<other.ID)
			return -1;
		return 0;
	}
}
