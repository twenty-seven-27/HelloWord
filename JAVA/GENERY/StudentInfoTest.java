/*
需求：有五个学生，每个学生有三门成绩，
	从键盘输入以上数据（包括姓名和三门成绩），
	输入格式：如：zhangsan, 30,40,60,在计算总成绩。
	并把学生信息和总成绩从高到低存入的顺序存入磁盘文件“stud.txt"中。

思路：
	1，描述一个学生对象。
	2，定义一个可操作的学生对象工具类。

	1，通过捕获键盘录入的一行数据，并将该行中的信息取出封装成学生对象。
	2，因为学生有很多，那么需要存储，使用到集合，有因为需要排序，这里可以用TreeSet集合。
	3，再将集合信息写入这个文件。
*/
import java.io.*;
import java.util.*;

class Student implements Comparable<Student>{
	private String name;
	private int math, chinese, english;
	private int sum;

	Student(String n, int m, int c, int e){
		this.name = n;
		this.math = m;
		this.chinese = c;
		this.english = e;
		sum = math + chinese + english; 
	}
	public String getName(){
		return name;
	}
	public int getMath(){
		return math;
	}
	public int getEnglish(){
		return english;
	}
	public int getSum(){
		return sum;
	}
	public int hashCode(){
		return name.hashCode()+sum*23;
	}
	public boolean equals(Object obj){
		if(!(obj instanceof Student ))
			throw new ClassCastException("类型不匹配");

		Student s = (Student)obj;
		return this.name.equals(s.name) && this.sum==s.sum;
	}
	public int compareTo(Student s){
		int num = new Integer(this.sum).compareTo(new Integer(s.sum));
		if(num == 0)
			return this.name.compareTo(s.name);
		return num;
	}
	public String toString(){
		return "student["+name+","+math+","+chinese+","+english+"]";
	}

}

class StudentInfoTools{
	public static Set<Student> getStudents() throws IOException{
		return getStudents(null);
	}
	public static Set<Student> getStudents(Comparator<Student> cmp) throws IOException{
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		Set<Student> stus = new TreeSet<Student>();
		if(cmp==null)
			stus = new TreeSet<Student>();
		else
			stus = new TreeSet<Student>(cmp);
		
		while((line = bufr.readLine())!=null){
			if("over".equals(line))
				break;
			String[] info = line.split(",");
			Student stu = new Student(info[0], 
				Integer.parseInt(info[1]),
				Integer.parseInt(info[2]),
				Integer.parseInt(info[3]));
			stus.add(stu);
		}
		bufr.close();
		return stus;
	}

	public static void writeFile(Set<Student> stus) throws IOException{
		BufferedWriter bufw = new BufferedWriter(new FileWriter("stuinfo.txt"));
		for(Student stu : stus){
			bufw.write(stu.toString()+"\t");
			bufw.write(stu.getSum()+"");
			bufw.newLine();
			bufw.flush();
		}
		bufw.close();
	}
}

class StudentInfoTest{
	public static void main(String[] args) throws IOException{
		Comparator<Student> cmp = Collections.reverseOrder();
		Set<Student> stus = StudentInfoTools.getStudents(cmp);
		StudentInfoTools.writeFile(stus);
	}
}
