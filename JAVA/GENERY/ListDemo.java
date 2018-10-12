import java.util.*;
class ListDemo{
	public static void sop(Object obj){
		System.out.println(obj);
	}
	public static void main(String[] args){
		ArrayList al = new ArrayList();

		al.add("java1");
		al.add("java2");
		al.add("java3");
		al.add("java4");

		sop("原集合："+al);

		//在指定位置插入元素
		al.add(1,"java0");

		//删除置顶位置元素：
		al.remove(3);

		//修改元素：
		al.set(2,"javajava2");

		//通过角标获取元素：
		sop("get(0)"+al.get(0));

		//获取所有元素：
		for(int i=0; i<al.size(); i++){
			sop("get("+i+")"+al.get(i));
		}

		//修改后的集合：
		sop("修改后的集合："+al);

	}
}