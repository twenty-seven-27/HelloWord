import java.util.*;
/*
枚举就是（Vector）特有方法，
发现枚举和迭代器（Iterator）很像，
其实枚举和迭代器是一样的。

因为枚举名称及其方法名称都过长，所以被枚举取代了。
枚举给予郁郁而终了。
*/
class VectorDemo{
	public static void main(String[] args){
		Vector v = new Vector();

		v.add("java01");
		v.add("java02");
		v.add("java03");
		v.add("java04");

		Enumeration en = new v.Enumeration();

		while(en.hasMoreElements()){
			System.out.println(en.nextElement());
		}
	}
}