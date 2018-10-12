class Test implements Runnable{
	private boolean flag;
	Test(boolean f){
		this.flag = f;
	}
	public void run(){
		if(flag){
			synchronized(MyLock.locka){
				System.out.println("if locka");
				synchronized(MyLock.lockb){
					System.out.println("if lockb");
				}
			}
		}
		else{
			synchronized(MyLock.locka){
				System.out.println("else locka");
				synchronized(MyLock.lockb){
					System.out.println("else lockb");
				}
			}
		}
	}
}
class MyLock{  //自己创建两个锁对象。
	static Object locka = new Object();
	static Object lockb = new Object();
}

class DealLockTest{
	public static void main(String[] args){
		Thread t1 = new Thread(new Test(true));
		Thread t2 = new Thread(new Test(false));
		t1.start();
		t2.start();

	}
}