abstract class AbsDemo{
	abstract void show();
}
class Outer{
	int x = 3;
	/*将一下代码简化为匿名内部类
	class  Inner extends AbsDemo{	
		void show(){
			System.out.println("show :" +x);
		}
	}
	*/
	public void function(){
		//new Inner().method();
		//重点：
		new AbsDemo(){		//匿名内部类，没名字，一般只调用一次！
			void show(){
				System.out.println("show :" +x);
			}
		}.show();	//点号前面的是一个AbsDemo的匿名子类对象。
	}
}

class InnerClassDemo4{
	public static void main(String[] args){
		new Outer().function();
	}
}