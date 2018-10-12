import java.util.*;
class iteratorDemo{
	public static void main(String[] args){
		method_iterator();
	}
	public static void method_iterator(){
		ArrayList al1 = new ArrayList();
		al1.add("java1");
		al1.add("java2");
		al1.add("java3");
		al1.add("java4");

		// Iterator it = al1.iterator();	//获取迭代器，用于取出集合中元素；
		// while(it.hasNext()){
		// 	sop(it.next());
		// }

		//老外写法：代码更优，it对象用完就释放！
		for(Iterator it = al1.iterator();it.hasNext();){
			sop(it.next());
		}
	}

	public static void sop(Object obj){
		System.out.println(obj);
	}
}