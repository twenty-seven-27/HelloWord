/*

毕老师用电脑上课。

开始思考上课会出现的问题。

比如电脑蓝屏。如果电脑蓝屏就重启电脑。
电脑冒烟。如果电脑冒烟，拿电脑就没救了，老师将没办法上课。
老师没办法上课会拖慢课时进程。

要对问题进行描述，封装成对象。

类：LanPingException,蓝屏异常类；MaoYanExeption,冒烟异常类；NoPlanException,电脑冒烟后，课时进程拖慢异常类。
	Computer,电脑类；Teacher,老师类；
	电脑有三个状态，分别是正常、蓝屏、冒烟；有两个方法：run(),电脑运行；reset()，电脑重启；电脑运行过程中，可能会遇到前面两种异常；
	所以run()方法中需要抛出异常；而调用run()方法的Teacher类的Prelect()需要捕获和处理异常。
	电脑冒烟，没法上课，这种情况还有处理方法：学生自习。所以冒烟异常的处理还可以抛出“拖慢课时进程”异常；主函数对其调用和处理该异常！

*/
class LanPinngException extends Exception{

	LanPinngException(String message){
		super(message);
	}
}
class MaoYanException extends Exception{
	MaoYanException(String message){
		super(message);
	}
}
class NoPlanException extends Exception{
	NoPlanException(String message){
		super(message);
	}
}
class Computer{
	private int state = 3;
	public void run() throws LanPinngException,MaoYanException{ //对运行过程进行异常检测！
		if(state == 2)
			throw new LanPinngException("电脑蓝屏！！");
		if(state == 3)
			throw new MaoYanException("惨了！电脑冒烟啦！！");
		System.out.println("电脑运行");
	}
	public void reset(){
		state = 1;
		System.out.println("电脑重启");
	}
}
class Teacher{
	private String name;
	Teacher(String name){
		this.name = name;
		//Computer c = new Computer();
	}
	public void prelect() throws NoPlanException{ //对电脑运行过程抛出的异常进行异常捕获和处理。
			Computer c = new Computer();
			try{
				c.run();
			}
			catch(LanPinngException e){
				new Computer().reset();
			}
			catch(MaoYanException e){
				test();	//这个test()只能放在throw语句之前，因为throw语句会结束当前代码段的执行，不执行后面的代码！
				throw new NoPlanException(e.getMessage()+"课时无法继续,");
			}
			System.out.println("讲课！");
	}
	public void test(){
		System.out.println("同学们自己自习！");
	}
}
class ExceptionTest{
	public static void main(String[] args){
		Teacher t = new Teacher("毕老师");
		try{								//对老师讲课过程中的异常进行捕获和处理。
			t.prelect();
		}
		catch(NoPlanException e){
			System.out.println(e.toString());
			System.out.println("换老师或者放假");
		}
		catch(Exception e){
			System.out.println(e.toString());
		}
	}
}