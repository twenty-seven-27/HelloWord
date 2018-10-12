/*
First In First Out

为什么要另外封装队列？LinkedList不是有这样的功能吗？
LinkedList只有本身的含义，不适合贴近应用的工具；我们需要跟有意义名称的工具！
*/
import java.util.*;
class DuiLie{
	private LinkedList link;
	DuiLie(){
		link = new LinkedList();
	}
	public void myadd(Object obj){
		link.addFirst(obj);
	}
	public Object myGet(){
		return link.removeLast();
	}
	public boolean isNull(){
		return link.isEmpty();
	}
}
class LinkListFIFO{
	public static void main(String[] args){
		DuiLie d1 = new DuiLie();
		d1.myadd("java01");
		d1.myadd("java02");
		d1.myadd("java03");
		d1.myadd("java04");
		d1.myadd("java05");
		while(!d1.isNull()){
			System.out.println(d1.myGet());
		}
	}

}