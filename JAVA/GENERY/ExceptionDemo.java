// class Demo{
// 	int div(int a, int b) {
// 		return a/b;	//new AritchmeticException()；虚拟机常见一个对象
// 	}
// }

// class ExceptionDemo{
// 	public static void main(String[] args){
// 		Demo d = new Demo();
// 		try{
// 			int x =d.div(4,0);	//new AritchmeticException()
// 			System.out.println("x = "+x);
// 		} 
// 		catch(Exception e){		//Exception e = new ArithmeticException(); 接受异常对象
// 			System.out.println("除零啦！！");
// 			System.out.println(e.getMessage()); // by zero; 获取异常信息
// 			System.out.println(e.toString());	//异常名称； 获取异常名称

// 			e.printStackTrace();	//异常名称，异常信息，异常出现的位置。
// 		}							//其实jvm默认的异常处理机制，就是在调用printStackTrace方法。
// 									//打印异常的堆栈的跟踪信息。
// 		System.out.println("over !!");
// 	}
// }

// class Demo{
// 	int div(int a, int b) Excetopn{		//在功能上通过throws的关键字声明了该功能可能会出问题。
// 		return a/b;	//new AritchmeticException()；虚拟机常见一个对象
// 	}
// }

// class ExceptionDemo{
// 	public static void main(String[] args) throws Exception{	//Demo抛出异常，主函数调用了它，就需要处理这个异常，
// 		Demo d = new Demo();									//如果不进行捕获的话，也可以抛给虚拟机，虚拟机会用默认处理方式。
// 		int x =d.div(4,0);	//new AritchmeticException()
// 		System.out.println("x = "+x);
		
// 		System.out.println("over !!");
// 	}
// }


// class Demo{
// 	int div(int a, int b) throws ArithmeticException,ArrayIndexOutOfBoundsException{ //在功能上通过throws的关键字声明了该功能可能会出问题。
// 		return a/b;	//new AritchmeticException()；虚拟机常见一个对象					//抛出多个异常，用逗号隔开！
// 	}
// }
// class ExceptionDemo{
// 	public static void main(String[] args) {	
// 		Demo d = new Demo();									
// 		try{
// 			int x =d.div(4,0);	//new AritchmeticException()
// 			System.out.println("x = "+x);
// 		}
// 		catch(ArithmeticException e){	//函数中抛出什么异常，catch就要处理什么异常！
// 			System.out.println(e.toString());
// 			System.out.println("除零了 ！！！");
// 		}
// 		catch(ArrayIndexOutOfBoundsException e){
// 			System.out.println(e.toString());
// 			System.out.println("角标越界了！！");
// 		}
// 		catch(Exception e){
// 			System.out.println(e.toString());
// 		}
		
// 		System.out.println("over !!");
// 	}
// }
/*
需求：除数除了不能为0外，还不可能为负数。
实现：
*/
class FuShuException extends Exception{
	FuShuException(String mess){
		super(mess);
	}
}
class Demo{
	int div(int a, int b) throws ArithmeticException,ArrayIndexOutOfBoundsException,FuShuException{ 
		if(b<0)																	//在功能上通过throws的关键字声明了该功能可能会出问题。	
			throw  new FuShuException("一个负数");  //手动通过throw关键字抛出异常。			//抛出多个异常，用逗号隔开！
		return a/b;	//new AritchmeticException()；虚拟机常见一个对象					
	}
}
class ExceptionDemo{
	public static void main(String[] args) {	
		Demo d = new Demo();									
		try{
			int x =d.div(4,-1);	//new AritchmeticException()
			System.out.println("x = "+x);
		}
		catch(ArithmeticException e){	//函数中抛出什么异常，catch就要处理什么异常！
			System.out.println(e.toString());
			System.out.println("除零了 ！！！");
		}
		catch(ArrayIndexOutOfBoundsException e){
			System.out.println(e.toString());
			System.out.println("角标越界了！！");
		}
		catch(FuShuException e){
			System.out.println(e.toString());
			System.out.println("亲，有负数！！！！");
		}
		catch(Exception e){
			System.out.println(e.toString());
		}
		System.out.println("over !!");
	}
}

// //Throwable,Exception实现getMessage()
// class Thrownable{
// 	private String message;
// 	Thrownable(String message){
// 		this.message = message;
// 	}
// 	public String getMessage(){
// 		return message;
// 	}
// }

// class Exception extends Thrownable{
// 	Exception(String message){
// 		super(message);
// 	}
// }