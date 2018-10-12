interface Inter{
	void method();
}
class Test{
	/* 下面是内部类，但不是匿名内部类。
	staticclass Inner implements Inter{
		public void method(){
			System.out.println("method : ");
		}
	}
	static Inner function(){
		Inner i1 = new Inner();
		return i1;
	}
	*/ 
	//补足代码，通过匿名内部类。
	static Inter function(){
		return new Inter(){	//匿名内部类，返回Inter类型的对象。
			public void method(){
			System.out.println("method : ");
		}
		};
	}
}
class InnerClassDemo5{
	public static void main(String[] args){
		//理解：
		//Test.function():Test类中有一个静态的方法function。
		//.method():function()这个方法执行后的结果是一个对象，而且是一个Inter类型的对象。
		//因为只有Inter类型的对象，才可以调用method方法。
		Test.function().method();
		//常用场景
		show(new Inter(){
			public void method(){
				System.out.println("method show run ");
			}
		});	//注意这个分号不要省略。
	}
	public void static show(Inter in){
		in.method();
	}
}