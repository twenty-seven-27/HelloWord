//package java2;





/*/*
生产者消费者问题。
需求：有多个生产者生产商品，放到仓库中；多个消费者消费商品，
消费者从仓库中取出上品进行消费；仓库里最多只能存放一个商品。
	 。。。。
	 用java5.0的 java.util.concurrent.locks 新特性实现线程之间的通信。
分析：两个生产者线程，两个消费者线程；
通过，创建继承Runnable接口的生产、消费类，再将相应的类型对象传递给Thread类来创建线程。
	 调用java.util.concurrent.locks包中的Lock接口中的ReentrantLock类来创建锁。
	 调用java.util.concurrent.locks包中的Condition接口中的lock.newCondition()来创建 ？？？？
	 （我不知道这个增么描述！）。
*/
import java.util.concurrent.locks.*;	//调用java5.0的新特性，摒弃synchronized那啥啥的
class Resource{		//资源仓库
	private int count = 0;		//商品数量
	private String name ;		//商品名称
	private boolean flag = false;	//用来标记仓库是否有商品

	private Lock lock = new ReentrantLock();	//创建一个锁对象
	private Condition condition_pro = lock.newCondition();	//我就是难以理解这个该死的Condition类时干嘛的，
	private Condition condition_con = lock.newCondition();

	public void set(String name) throws InterruptedException{	//为了提高代码可读性，把创建商品的过程封装成方法，放到Resource类下面。
			lock.lock();	//打开锁，保证以下代码块同步
			try{	//检测异常
				while(flag)		//让唤醒的线程循环访问flag标签；避免用if时，被唤醒的线程不在判断仓库中是否有商品而生产多个商品
					condition_pro.await();
				this.name = name+"---"+count++;		//生产商品
				System.out.println(Thread.currentThread().getName()+"--生产者--"+this.name);	//生产商品
			flag = true;	//更改标签
			condition_con.signal();		//唤醒消费者线程
			}
			finally{	//一定会执行的代码：关闭锁！
				lock.unlock();
			}
			
	}
	public  void out() throws InterruptedException{	//为了提高代码可读性，把消费商品的过程封装成方法，放到Resource类下面。
		lock.lock();
		try{
			while(!flag)	
				condition_con.await();
			System.out.println(Thread.currentThread().getName()+"消费者"+this.name);
			flag = false;
			condition_pro.signal();		//唤醒生产者线程
		}
		finally{
			lock.unlock();
		}
	}
}

class Producer implements Runnable{		//生产类
	private Resource r; 	//为了保证所有的线程操作的事同一个仓库对象，这里就没有再创建对象，只是创建引用。
	Producer(Resource r){	//引用对象lalsl
		this.r = r;
	}
	public void run(){		//线程的run()方法
		while(true){
			try{		//检测异常
				r.set("商品");
			}
			catch(Exception e){}
		}
	}
}

class Consumer implements Runnable
{		//消费类
	private Resource r; 
	Consumer(Resource r)
	{
		this.r = r;
	}
	public void run()
	{
		while(true)
		{
			try{
				r.out();
				}
			catch(Exception e){}
		}
	}
}	

public class sss {

	public static void main(String[] args) {
		Resource r = new Resource();	//创建仓库
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

 
 