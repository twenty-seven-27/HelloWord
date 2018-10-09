/*
 * 用TreeeSet集合存储自定义对象Student;
 * 使其按学号进行排序。
 * */


import java.util.*;
class Student{
	private String name;
	private int number;
	Student(String n, int nu){
		this.name = name;
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public int getNumber() {
		return number;
	} 
}
public class treeSetStudent {
	public static void main(String[] args) {
		TreeSet ts = new TreeSet();
		ts.add(new Student("tom01",12));
		ts.add(new Student("tom07",22));
		ts.add(new Student("tom09",12));
		Iterator it = ts.iterator();
		while(it.hasNext()) {
			Student st = (Student)it.next();
			System.out.println(st.getName()+"....."+st.getNumber());
		}
	}

}
