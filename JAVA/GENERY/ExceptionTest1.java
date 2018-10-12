/*
有一个长方形。
都可以获取面积。对于面积如果出现非法的数值，视为是获取面积出现了问题。
问题通过异常表示。
现有对这个程序进行基本设计。

*/

interface Shape{
	void getArea();
}

class NoValueException extends Exception{
	NoValueException(String message){
		super(message);
	}
}

class Rec implements Shape{
	private int len, wid;

	Rec(int len, int wid) throws NoValueException{
		//以往我们为了不让用户不输入负数，通常会在这加一个if,else，该方法非常不可取
		//这个导致，程序执行代码和问题处理代码结合太紧密，可读性太差！！！
		//正确处理：用异常处理。
		if(len <= 0 || wid <= 0)
			throw new NoValueException("出现非法值");
		this.len = len;
		this.wid = wid;
	}

	public void getArea(){
		System.out.println(len*wid);
	}
}

class ExceptionTest1{
	public static void main(String[] args){
		
		try{
			Rec r1 = new Rec(1,0);
			r1.getArea();	//上面语句出现异常，下面的语句就不会在执行，程序会处理该异常，然后结束。
		}
		catch(NoValueException e){
			System.out.println(e.toString());
			System.out.println("请重新输入");
		}
		

	}
}
