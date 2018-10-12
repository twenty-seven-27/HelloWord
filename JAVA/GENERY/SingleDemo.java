class Single{
	private int num;
	private Single(){}
	private static Single  s = new Single();

	public static Single getInstance(){
		return s;
	}
	public void setNum(int n){
		this.num = n;
	}
	public int getNum(){
		return num;
	}
}
class SingleDemo{
	public static void main(String[] args){
		Single ss = Single.getInstance();
		Single s1 = Single.getInstance();	//ss,s1都指向堆中同一个对象；无论mian中new出多少个对象，他都指向同一个对象。
		ss.setNum(23);
		System.out.println(ss.getNum());

	}
}