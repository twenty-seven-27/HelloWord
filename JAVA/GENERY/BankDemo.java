/*
需求：
银行有一个金库。
有两个储户分别存300元，每次存100，存3次
*/
class Bank{
	private int sum;
	//Object obj = new Object();
	public synchronized void add(int n){
		//synchronized(obj){
			sum = sum + n;
			try{Thread.sleep(10);}catch(Exception e){}
			System.out.println("sum = "+sum);
		//}
	}
}
class Cus implements Runnable{
	private Bank b = new Bank();
	public void run(){
		for(int x=0; x<3; x++){
			b.add(100);
		}
	}
}
class BankDemo{
	public static void main(String[] args){
		Cus c = new Cus();
		Thread t1 = new Thread(c);
		Thread t2 = new Thread(c);
		t1.start();
		t2.start();
	}
}