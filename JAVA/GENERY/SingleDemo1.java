//懒汉式，不常用，面试官会用！
class Single{
	private static Single s = null;	//对象以加载，方法区就只有s=null；
	private Single(){}				//只有在调用对象getInstance()方法时，才会创建对象；称之为延迟加载。
	public static SIngle getInstance(){
		if(s == null)	//开发一般不用这个的原因：多线程运行程序时，每次调用Instancd()方法是都是临时创建对象，
			s = new Single;  //线程执行太快可能会导致，对象部位的情况。当然这里可以加一个锁（synchronized）,但这样会导致程序的运行效率降低。
		return s;
	}
}
class SingleDemo1{
	public static void main(String[] args){
		Single s1 = Single.getInstance();
		Single s2 = Single.getInstance();

	}
}
//加锁的最终优化结果：

class Single{
	private static Single s = null;	
	private Single(){}				
	public static Single getInstance(){ //在函数中直接使用synchronized关键字，会到只程序执行效率变低，
		if(s == null)	//为了防止第二个、和以后线程重复判断锁，提高效率。
			synchronized(Single.class){
				if(s == null){  //为了只创建一个对像，当第一线程创建一个对象时，后面的线程就不会再创建对象了。
					s = new Single();
				}
			}
		return s;
	}
}
class SingleDemo1{
	public static void main(String[] args){
		Single s1 = Single.getInstance();
		Single s2 = Single.getInstance();
	}
}