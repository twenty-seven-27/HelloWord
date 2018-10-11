import java.io.*;
class ObjectStreamDemo{
	public static void main(String[] args) throws Exception{
		//writeObj();
		readObj();
	}
	public static void writeObj() throws IOException{
		ObjectOutputStream oos = 
			new ObjectOutputStream(new FileOutputStream("C:\\Users\\Administrator\\Desktop\\HelloWord\\SUBLIME\\obj.txt"));
		oos.writeObject(new Person("lisi",23,"kr"));
		oos.close();
	}
	public static void readObj() throws Exception{
	ObjectInputStream ois = 
		new ObjectInputStream(new FileInputStream("C:\\Users\\Administrator\\Desktop\\HelloWord\\SUBLIME\\obj.txt"));
	Person p = (Person)ois.readObject();
	System.out.println(p);
	ois.close();
	}
}
//Serializable���л��ӿ�
//UID�����кţ��������г�Ա������ģ�
//
class Person implements Serializable{
	//��������Ψһ�����кţ����Ѿ����л��Ķ����ܱ��µ��������
	public static final long serialVersionUID = 42L;
	String name;
	static String country = "cn";
	int age;
	Person(String n, int a, String c){
		this.name = n;
		this.age = a;
		this.country = c;
	}
	public String toString(){
		 return name+": "+age+": "+country;
	}
}

//���ǵ�Person���������ı�ʱ������UID�ͻ᲻һ�����ͻᵼ�³������д���
//��ʱ��Ҫ�����Լ�����UID��

//���������country����Ϊ���Ǿ�̬�ģ����ڶ����棬���Բ��ܱ����л���
//�����ԷǾ�̬��ԱҲ�������л�����������transient�ؼ������ξͿ����ˡ�
//�ùؼ��ֱ�֤�˱����ζ���ֻ�ڶ��д��ڣ����ı��ļ��в����ڡ�
//readObject()����Ҳ��ǿ�󣬿����Զ�һ�ζ�ȡ��ͬ�Ĵ������