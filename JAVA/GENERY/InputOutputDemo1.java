
class Res{     //set()和out()都是对本类对象。
	String name;
	String sex;
	boolean flag = false;
	public synchronized void set(String name, String sex){
		if(this.flag)	
			try{this.wait();} catch(Exception e){}	
		this.name = name;
		this.sex = sex;
		this.flag = true;
		this.notify();	
	}
	public synchronized void out(){
		if(!this.flag)
			try{this.wait();} catch(Exception e){}
		System.out.println(this.name+" "+this.sex);
		this.flag = false;
		this.notify();
	}
}
class Input implements Runnable{
	private Res r;	//对象引用，不创建对象，对象由外面导入。
	Input(Res r){
		this.r = r;
	}
	public void run(){
		int x = 0;
		while(true){
			if(x == 0){
				r.set("mike","man");
			}
			else{
				r.set("Lily","woman");
			}
			x = (x+1)%2;
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
			r.out();
		}
	} 
}
class InputOutputDemo1{
	public static void main(String[] args){
		Res r = new Res();
		new Thread(new Input(r)).start();	//线程对象都用匿名对象类创建对象，启动线程。
		new Thread(new Output(r)).start();
	} 
}