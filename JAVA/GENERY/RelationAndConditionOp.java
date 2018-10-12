public class RelationAndConditionOp{
	public static void main(String args[]){
	/*	int a=25, b=3;
		boolean d = a<b;
		System.out.println("a<b="+d);
		int e=3;
		if(e!=0 && a/e>5)
			System.out.println("a/e="+a/e);
		int f=0;
		if(f!=0 && a/f>5) //f为0不会出错，是因为f!=0,不会执行后面的语句a/f!
			System.out.println("a/f="+a/f);
		else
			System.out.println("f = "+f);
	*/
		int a=11010110,b=01011001;
		a=a^b;
		b=b^a;
		a=a^b;
		System.out.println("a="+a);
		System.out.println("b="+b);

	}
}