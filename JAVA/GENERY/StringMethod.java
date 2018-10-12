class StringMethod{
	public static void sop(Object obj){
			System.out.println(obj);
		}
	public static void main(String[] args){
		String s1 = "Welcome to java !";
		String s2 = s1;
		String s3 = new String("Welcome to java !");
		String s4 = "Welcome to java !";

		//测试一下“==”
		sop(s1==s2);
		//结果：true
		sop(s2==s3);
		//结果：false
		//总结：“==”用来判断两个字符串变量是否引用同一个对象！

		//测试一下“equals()”
		sop(s1.equals(s2));
		//结果：true
		sop(s2.equals(s3));
		//结果：true
		//总结：“equals()“函数是用来判断两个字符串变量的值是否相等！

		//测试compareTo()
		sop(s1.compareTo(s2));
		//结果：0
		//总结：比较两个字符串ASCII值的大小；两者相等返回“0”，调用字符串对象大于被调用字符串对象时，返回大于0的数；小于时返回小于0的数。
		sop(s2.compareTo(s3));
		//结果：0

		sop(s1==s4);
		//结果：true
		//理解：java虚拟机把字符串对象都存放在内存中，为了节约空间，虚拟机在定义变量前，
		//会在内存中查看是否有已经存在的相同的对象，若有，就直接引用；如果没有就会新开辟空间创建新的对象。
		//需要注意的是：如果定义是用了new关键字来定义对象，这时无论对是否已经存在，都会另外开辟空间创建对象！

		//测试charAt()
		sop(s1.chartAt(0));

		//取得字符串的长度
		sop(s1.length());
		//结果：17




		
	}
}