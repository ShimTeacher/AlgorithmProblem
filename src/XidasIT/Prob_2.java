package XidasIT;

import java.util.Scanner;
	
	//두개의 다각형의 좌표를 입력받아 임의의 좌표가 다각형 내부에 존재하는지 체크하는프로그램 작성하
	//무조건 첫번째 다각형은 outline에 생성되고
	// 두번째 다각형은 첫번째 다각형 안쪽으로 inline에 생성된다.
	// outline과 inline 사이의 좌표가 존재할 때 체크를 해줘야함.
	
	//---------------------------------------
	//|					-------------		|
	//|		A 			|	B		|		| C
	//|					-------------		|
	//---------------------------------------
	// A는 내부점. B,C는 외부점으로 인식.

	//INPUT
	//	1 2 
	//	5
	//	0 0 9 1 7 7 9 10 0 11
	//	4
	//	1 3 3 1 6 8 2 9

	//OUTPUT
	// TRUE





class Point
{
	double x;
	double y;
	Point(double x, double y)
	{
		this.x = x;
		this.y= y;
	}
}

public class Prob_2 {
		
		
		static int crosses=0;
		public static void main(String args[])
		{
			//입력값 처리하기 
			Scanner in = new Scanner(System.in);
			int x = in.nextInt();
			int y = in.nextInt();
			
			
			Point checkPoint = new Point(x,y);
			
			final int numOfOutsidePoint = in.nextInt();
			Point Outside[] = new Point[numOfOutsidePoint];
			
			int i = numOfOutsidePoint;
			int val = 0;
			while( i-- > 0)
			{
				
				int tempX = in.nextInt();
				int tempY = in.nextInt();
				
				Outside[val++] = new Point(tempX, tempY);
			}
			
			final int numOfInsidePoint = in.nextInt();
			Point Inside[] = new Point[numOfInsidePoint];
			
			val = 0;
			int j = numOfInsidePoint;
			while(j-->0)
			{
				int tempX = in.nextInt();
				int tempY = in.nextInt();
				
				Inside[val++] = new Point(tempX, tempY);
			}
			
			System.out.println(isInside(checkPoint,Outside,Inside));
			
			

			
		}
		
		
		static void CountCross(Point tempP, Point p[])
		{
			for(int i=0; i<p.length; i++)
			{
				int j=(i+1)%p.length;
				if((p[i].y > tempP.y) != (p[j].y > tempP.y))
				{
					double atX = (p[j].x - p[i].x)/(p[j].y - p[i].y) *(tempP.y - getYJ(p[i],p[j]));
					
					if(tempP.x< atX)
					{
						++crosses;
					}
				}
			}
		}
		
		//내부에 점이 있는지 확인해주는 메소드 
		static boolean isInside(Point tempP, Point p[], Point q[])
		{
			CountCross(tempP,p);
			CountCross(tempP,q);
			
			System.out.println(crosses);
			return crosses % 2 > 0 ;
		}
		
		//y절편을 구한다. 
		static double getYJ(Point p, Point j)
		{
			double a = (p.y-j.y)/(p.x-j.x);
			double b = p.y-a*p.x;
			return b;
		}
		
		
		//영역의 넓이를 구한다.
//		static double area(Point p[])
//		{
//			double ret = 0;
//			for(int i =0; i<p.length; i++)
//			{
//				int j = (i+1)% p.length;
//				ret += p[i].x*p[j].y - p[j].x * p[i].y;
//			}
//			return Math.abs(ret)/2.0;
//		}

}
