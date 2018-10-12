/*
需求：生产者消费者问题，多个生产者和多个消费者。仓库里面没有商品是，不在消费，生产者生产商品；仓库中有商品时，不在生产，消费者消费商品；

分析：这是一个典型的多线程编程问题，不是我自己分析的，我也说不好。
注意：如何实现多个线程的同步问题，如何让生产线程和消费线程轮流操作资源库。
*/
class Resource{
	private int count = 0;
	private String name ;
	private boolean flag = false;

	public synchronized void set(String name){
			while(flag)
				try{wait();} catch(Exception e){}
			this.name = name+"---"+count++;
			System.out.println(Thread.currentThread().getName()+"--生产者--"+this.name);
			flag = true;
			notifyAll();
			
	}
	public synchronized void out(){
		
			while(!flag)	//让线程被唤醒时，再回去判断标记，防止t1线程唤醒了t2线程，导致生产两次，消费一次的错误情况。
				try{wait();} catch(Exception e){}
			System.out.println(Thread.currentThread().getName()+"消费者"+this.name);
			flag = false;
			notifyAll();	//唤醒所有线程，只唤醒线程池中最上面那个会导致死锁问题，准确来说是类似于死锁问题，于是我们吧所有线程都唤醒。
							//就算全部唤醒线程运行也不会出错，因为我们让他循环判断标记。
	}
}

class Producer implements Runnable{
	private Resource r; 
	Producer(Resource r){
		this.r = r;
	}
	public void run(){
		while(true){
			r.set("商品");
		}
	}
}

class Consumer implements Runnable{
	private Resource r; 
	Consumer(Resource r){
		this.r = r;
	}
	public void run(){
		while(true){
			r.out();
		}
	}
}

class ProduceConsumer{
	public static void main(String[] args){
		Resource r = new Resource();

		Producer p = new Producer(r);
		Consumer c = new Consumer(r);

		Thread t1 = new Thread(p);	//创建多个生产者，多个消费者；
		Thread t2 = new Thread(p);
		Thread t3 = new Thread(c);
		Thread t4 = new Thread(c);

		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}