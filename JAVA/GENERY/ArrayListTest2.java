import java.util.*;
class person{
	private int age;
	private String name;
	person(String n, int a){
		this.age = a;
		this.name = n;
	}
	//重写equals方法。
	public boolean equals(Object obj){
		if(!(obj instanceof person))
			return false;
		person p = (person)obj;
		System.out.println(this.name+"......"+p.name);
		//this.name的equals是字符串的equals方法；int没有equals方法，需要逻辑判断.
		return this.name.equals(p.name)&&this.age == p.age;	
	}
	public String getName(){
		return name;
	}
	public int getAge(){
		return age ;
	}
}
class ArrayListTest2{
	public static void sop(Object obj){
		System.out.println(obj);
	}
	public static void main(String[] args){
		ArrayList al = new ArrayList();

		al.add(new person("lily", 18));
		al.add(new person("tom", 18));
		al.add(new person("lily", 98));
		al.add(new person("thsya", 18));
		al.add(new person("lily", 18));
		al.add(new person("bule", 18));

		for(int i=0	; i<al.size(); i++){
			person p = (person)al.get(i);
			System.out.println(p.getName()+"===="+p.getAge());
		}
		//用迭代器，效率要更低一点。舍弃！
		// Iterator it = al.iterator();
		// while(it.hasNext()){
		// 	person p = (person)it.next();
		// 	sop(p.getName()+"::::"+p.getAge());
		// }
		ArrayList al1 = singleElement(al);
		System.out.println();
		//通过利用索引实现for循环。
		for(int j=0	; j<al.size(); j++){
			person p = (person)al1.get(j);	//强制类型转换！！
			System.out.println(p.getName()+"===="+p.getAge());
		}

//ArrayList容器不知道如何判断两个人是否相同；它只能判断是否是同一个对象。
//重写equals方法，来判断person对象的值是否相同。
	}
	public static ArrayList singleElement(ArrayList al){
		ArrayList newAl = new ArrayList();
		for(int i=0; i<al.size(); i++){
			if(!newAl.contains(al.get(i)))
				//contans的底层调用了equals方法，只需要重写equals方法就能实现两个person类对象的比较！
				newAl.add(al.get(i));
		}
		return newAl;
	}
}
