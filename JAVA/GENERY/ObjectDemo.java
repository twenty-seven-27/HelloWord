class Demo{
	private int num;
	Demo(int num){
		this.num = num;
	}

	//重写Object类的equals方法，让值相同，对象就相同；值不同，对象也就不同！！
	public boolean equals(Object obj){ //Object obj = new Demo()	多态！！！！！
		if(!(obj instanceof Demo))	//判断obj对象是否是Demo类
			return false;  //更为合理的做法是用异常处理，抛出异常！！
		Demo d = (Demo)obj;	//类型转换；只能父类对象转换为子类对像。
		return this.num == d.num;
	}
}

class Person{	//定义一个Person类，测试一下不同类的对象比较

}

class ObjectDemo{
	public static void main(String[] args){
		Demo d1 = new Demo(123);
		Demo d2 = new Demo(23);
		Person p1 = new Person();
		System.out.println(d1.toString());
		System.out.println(d1.equals(d2));
		System.out.println(d1.equals(p1));   //不同类之间的对象比较，对象一定不同，
		System.out.println(d1.equals(d1));	//所以我们在equals(Object obj)的开头先判断一下是否是同个对象！！！
	}
}