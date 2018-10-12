
/*
 * 用TreeeSet集合存储自定义对象Student;
 * 使其按学号进行排序。
 * */
import java.util.*;
//定义Student类型
class Student implements Comparable {
	private String name;
	private int number;
	Student(String n, int nu){
		this.name = name;
		this.number = number;
	}
	public int compareTo(Object obj) {
		if(!(obj instanceof Student))
			throw new RuntimeException("not a Student.");
		Student st = (Student)obj;
		if(this.number>st.number)
			return 1;
		if(this.number==st.number)
			return 0;
		return -1;
	}
	public String getName() {
		return name;
	}
	public int getNumber() {
		return number;
	}
}
class TreeSetStudent {
	public static void main(String[] args) {
		TreeSet ts = new TreeSet();	//定义TreeSet集合来存储Student类型对象。
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