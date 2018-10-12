import java.util.*;
class collectionDemo{
	public static void main(String[] args){
		method_1();
	}
	public static void method_1(){
		ArrayList al1 = new ArrayList();
		al1.add("java1");
		al1.add("java2");
		al1.add("java3");
		al1.add("java4");

		ArrayList al2 = new ArrayList();
		al2.add("java1");
		al2.add("java2");
		al2.add("java5");
		al2.add("java6");

		//al1.retainAll(al2);	//取交集并把交集存到al1中！！！改变了集合！
		al1.removeAll(al2);	//干掉相同元素，删掉al1中与al2元素相同的元素！！

		sop("al1: "+al1);
		sop("al2: "+al2);

	}

	public static void method_base(){
		//创建一个集合容器；用Collection接口的子类ArrayList.
		ArrayList al = new ArrayList();

		//1,添加元素：
		al.add("java1");	//add方法是用Object对象来接收的，因为add()参数类型不确定。可以接收任意类型的对像。
		al.add("java2");	//集合中不可能存放对象实体，只是对象的地址！！！
		al.add("java3");
		al.add("java4");

		//打印集合：
		sop("打印原集合："+al);

		//2，获取元素个数，也就是集合长度。
		sop("size: "+al.size());

		//3,删除元素：
		//al.remove("java2");
		al.clear();	//清空集合。

		//4，判断元素：
		sop("java3是否存在："+al.contains("java3"));
		sop("集合是否为空："+al.isEmpty());

		//打印改变后的集合：
		sop("改变后的集合："+al);
	}
	public static void sop(Object obj){
		System.out.println(obj);
	}
}