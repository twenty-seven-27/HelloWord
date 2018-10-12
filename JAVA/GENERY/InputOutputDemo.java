
/*
需求：有一堆媒，有一卡车来拉煤，还有一卡车送煤来；
分析：煤堆就是一个对象；一辆卡车就是一个线程。

类似的：一个仓库，存放注册者的姓名和性别，分别有注册和输出两个线程。
*/
class Res{
	
	String name;
	String sex;
	boolean flag = false;	//设置flag来表示仓库里面有没有资源。
}
class Input implements Runnable{
	private Res r;	//不搞对象，直接引用。这里也可以用单例实现！
	Input(Res r){
		this.r = r;
	}
	public void run(){
		int x = 0;
		while(true){
			synchronized(r){	
				if(r.flag)	//使用wait(),notify()交替执行，保证输入、输出两个线程交替执行，不会出现死锁的问题！
					try{r.wait();} catch(Exception e){}	//wait()方法在Object类中，不在Thread()类中！Thread继承了Object类的。
				if(x == 0){
					r.name = "mike";
					r.sex = "man";
				}
				else{
					r.name = "Lily";
					r.sex = "woman";
				}
				x = (x+1)%2;
				r.flag = true;
				r.notify();	//唤醒线程池中的线程，一般是线程池里的第一个线程。	
			}
		}
	} 
}
class Output implements Runnable{
	private Res r ;
	Output(Res r){
		this.r = r;
	}
	public void run(){
		while(true){
			synchronized(r){	//添加锁，解决代码同步问题。
				if(!r.flag)
					try{r.wait();} catch(Exception e){}
				System.out.println(r.name+" "+r.sex);
				r.flag = false;
				r.notify();
			}
		}
	} 
}
class InputOutputDemo{
	public static void main(String[] args){
		Res r = new Res();
		Input in = new Input(r);
		Output ou = new Output(r);

		Thread t1 = new Thread(in);
		Thread t2 = new Thread(ou);

		t1.start();
		t2.start();
	} 
å}