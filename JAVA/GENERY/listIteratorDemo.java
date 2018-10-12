// import java.util.*;
// class listIteratorDemo{
// 	public static void sop(Object obj){
// 		System.out.println(obj);
// 	}
// 	public static void main(String[] args){
// 		ArrayList al = new ArrayList();

// 		al.add("java1");
// 		al.add("java2");
// 		al.add("java3");
// 		al.add("java4");

// 		//在迭代过程中添加或删除元素；

// 		Iterator it = al.iterator();

// 		while(it.hasNext()){
// 			Object obj = it.next();

// 			if(obj.equals("java2")){
// 				al.add("java008");	//添加不了，不安全，操作迭代器时，不要对集合对象操作；操作不同步，会存在安全问题。
// 			}
// 			sop("obj: "+obj);
// 		}

// 	}
// }

import java.util.*;
class listIteratorDemo{
	public static void sop(Object obj){
		System.out.println(obj);
	}
	public static void main(String[] args){
		ArrayList al = new ArrayList();

		al.add("java1");
		al.add("java2");
		al.add("java3");
		al.add("java4");

		//在迭代过程中添加或删除元素；

		ListIterator it = al.listIterator();

		while(it.hasNext()){
			Object obj = it.next();

			if(obj.equals("java2")){
				//al.add("java008");	//添加不了，不安全，操作迭代器时，不要对集合对象操作；操作不同步，会存在安全问题。
				it.set("java006");
			}
			sop("obj: "+obj);
		}
		sop(al);
	}
}