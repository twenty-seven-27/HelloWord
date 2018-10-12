/*
需求：现有两个线程：
一个线程在同步代码块中运行；
一个线程在同步函数中运行；
两个线程都在执行买票程序。
*/
class Ticket implements Runnable{
	private int tick = 1000;
	Object obj = new Object();
	boolean flag = true ;
	public void run(){
		if(flag){
			while(true){
				synchronized(this){
					if(tick >0){
						try{Thread.sleep(10);}catch(Exception e){}
						System.out.println(Thread.currentThread().getName()+"code.....sale "+ tick--);
					}
				}
			}
		}
		else{
			while(true){
				this.show();
			}
		}
	}
	public synchronized void show(){
		if(tick >0){
			try{Thread.sleep(10);}catch(Exception e){}
			System.out.println(Thread.currentThread().getName()+"show.....sale "+ tick--);
		}
	}
}
class TickDemo{
	public static void main(String[] args){
		Ticket t = new Ticket();
		Thread t1 = new Thread(t);
		Thread t2 = new Thread(t);
		t1.start();
		try{Thread.sleep(10);}catch(Exception e){}
		t.flag = false;
		t2.start();
	}
}