/*
去除重复元素。
思路：要再有一个临时容器，将除去相同元素的集合放在这个容器中，然后将该容器返回给调用者。
*/

import java.util.*;
class ArrayListTest{
	public static void main(String[] args){
		ArrayList al1 = new ArrayList();
		al1.add("java01");
		al1.add("java02");
		al1.add("java01");
		al1.add("java03");
		al1.add("java01");
		al1.add("java04");
		al1.add("java01");
		Iterator it1 = al1.iterator();	//在ArrayList中，应用迭代器进行遍历效率最低。索引遍历效率最高。
		while(it1.hasNext()){
			System.out.println(it1.next());	
		}
		

		SingleElement(al1);			
	}
	public static ArrayList SingleElement(ArrayList al){
		//定义一个临时容器
		ArrayList newAl = new ArrayList();
		//添加迭代器
		Iterator it = al.iterator();
		while(it.hasNext()){
			Object obj = it.next();		//定义一个元素对象，用来存放原容器中的元素。
			if(!newAl.contains(obj))	//contains()方法，用来判断数组集合中是否存在obj对象。
				newAl.add(obj);
		}
		return newAl;
	}
}
