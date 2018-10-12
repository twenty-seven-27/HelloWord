// class StopThread implements Runnable{
// 	private boolean flag = true;
// 	public void run(){
// 		while(flag){
// 			System.out.println(Thread.currentThread().getName()+".....run");
// 		}
// 	}
// 	public void changeFlag(){	//改变锁中线程的标志位，以达到终止线程的作用。
// 		flag = false;
// 	}
// }
// class StopDemo{
// 	public static void main(String[] args){
// 		StopThread st = new StopThread();

// 		Thread t1 = new Thread(st);
// 		Thread t2 = new Thread(st);

// 		t1.start();
// 		t2.start();

// 		int num = 0;
// 		while(true){
// 			num++;
// 			if(num == 10){
// 				st.changeFlag();	//中断线程！
// 				break;				//退出程序！
// 			}
// 			System.out.println(Thread.currentThread().getName()+".............."+num);	//显示主线程的运行状况。
// 		}
// 	}
// }

//特殊情况！！！同步！当线程处于了冻结状态，就不会读区标记，就不会结束线程
//解决办法：InterruptedException,如果用循环停止线程，wait(),sleep()就是异常！
// class StopThread implements Runnable{
// 	private boolean flag = true;
// 	public synchronized void run(){
// 		while(flag){
// 			try{
// 				wait();
// 			}
// 			catch(InterruptedException e){	//将冻结状态的线程强制恢复到运行状态。
// 				System.out.println(Thread.currentThread().getName()+".....Exception");
// 				flag = false;
// 			}
// 			System.out.println(Thread.currentThread().getName()+".....run");
// 		}
// 	}
// 	public void changeFlag(){
// 		flag = false;
// 	}
// }
// class StopDemo{
// 	public static void main(String[] args){
// 		StopThread st = new StopThread();

// 		Thread t1 = new Thread(st);
// 		Thread t2 = new Thread(st);

// 		t1.start();
// 		t2.start();

// 		int num = 0;
// 		while(true){
// 			num++;
// 			if(num == 100){
// 				//st.changeFlag();
// 				t1.interrupt();	//中断线程t1，
// 				t2.interrupt();
// 				break;
// 			}
// 			System.out.println(Thread.currentThread().getName()+".............."+num);
// 		}
// 	}
// }

//t1,t2为守护线程时，只有主线程是前台线程，挡住线程结束时，两个守护线程会自动结束。
class StopThread implements Runnable{
	private boolean flag = true;
	public synchronized void run(){
		while(flag){
			System.out.println(Thread.currentThread().getName()+".....run");
		}
	}
	public void changeFlag(){
		flag = false;
	}
}
class StopDemo{
	public static void main(String[] args){
		StopThread st = new StopThread();

		Thread t1 = new Thread(st);
		Thread t2 = new Thread(st);

		t1.setDaemon(true);	//将t1设置为守护线程
		t2.setDaemon(true);	//将t2设置为守护线程
		t1.start();
		t2.start();

		int num = 0;
		while(true){
			num++;
			if(num == 60){
				//st.changeFlag();
				//t1.interrupt();	//中断线程t1，
				//t2.interrupt();
				break;
			}
			System.out.println(Thread.currentThread().getName()+".............."+num);
		}
	}
}

