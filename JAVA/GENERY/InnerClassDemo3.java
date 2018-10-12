class Outer{
	int x = 3;
	void method(final int a){	//为了被内部类访问，需要被final修饰。
		//a++;   报错！！
		final int y = 8;	//为了被内部类访问，需要被final修饰。
		class Inner{
			void function(){
				System.out.println(y);	//访问局部变量：y
				System.out.println(a);	//访问传递参数：a
			}	
			
		}
	}
	new Inner().function();	//得放后面；放前面，函数代码都还没有加载到。
}

class InnerClassDemo4{
	public static void main(String[] args){
		new Outer().method(7);
		new Outer().method(8);	//不会出问题，不会报错！！
	}
}