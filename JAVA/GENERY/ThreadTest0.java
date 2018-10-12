//这是一个开发技巧，代码量不多的话要善于用匿名内部类。
class ThreadTest0{
	public static void main(String[] args){
		new Thread(){
			public void run(){
				for(int i=0; i<50; i++){
					System.out.println(Thread.currentThread().getName()+"....1..."+i);
				}
			}
		}.start();	//匿名内部类！！！！
		for(int i=0; i<50; i++){
			System.out.println(Thread.currentThread().getName()+"....2..."+i);
		}
		Runnable r = new Runnable(){
			public void run(){
				for(int i=0; i<50; i++){
					System.out.println(Thread.currentThread().getName()+"....3..."+i);
				}
			}
		};
		new Thread(r).start();	//匿名内部类！！！
	}
}

//线程顺序执行，就只有一个主线程。
// class ThreadTest0{
// 	public static void main(String[] args){
	// 		for(int i=0; i<50; i++){
// 			System.out.println(Thread.currentThread().getName()+"....1..."+i);
// 		}
// 		for(int i=0; i<50; i++){
// 			System.out.println(Thread.currentThread().getName()+"....2..."+i);
// 		}
// 		for(int i=0; i<50; i++){
// 			System.out.println(Thread.currentThread().getName()+"....3..."+i);
// 		}
// 	}
// }