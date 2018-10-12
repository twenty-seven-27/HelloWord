class Outer{
	private int x = 3;
	class Inner{	//内部类
		int x = 4;
		void function(){
			int x = 6;
			System.out.println("inner, x of Outer : "+Outer.this.x);	//访问外部类的私有成员x
			System.out.println("inner, x of Inner  : "+this.x);	//访问内部类的成员x
			System.out.println("inner, x of function : "+x);	//访问内部类方法中的x
		}
	}
	public void fun(){	//要访问内部类需要先定义类对象
		Inner i = new Inner();
		System.out.println("Outer Find Inner,x of Inner :" + i.x);  
		i.function();	

	}
}
class InnerClassDemo{
	public static void main(String[] args){
		Outer.Inner a = new Outer().new Inner();	//非所属外部类访问内部类要使用类的全名
		System.out.println("Outer Of Main Find Inner, x of Inner : "+a.x);
		Outer o = new Outer();
		o.fun();
	}
}