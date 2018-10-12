class Demo implements Runnable{
	public void run(){
	for(int x = 0; x < 70; x++){
			System.out.println(Thread.currentThread().getName() + "......" + x);
		}
	}	
}

class JoinDemo{
	public static void main(String[] args) throws Exception{
		Demo d = new Demo();
		Thread t1 = new Thread(d);
		Thread t2 = new Thread(d);
		t1.start();
		//t1.join();	//要执行完t1才会执行其他线程。
		t2.start();
		t1.join();

		for(int x = 0; x < 80; x++){
			System.out.println("main....."+x);
		}
		System.out.println("over");

	}
}