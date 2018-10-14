
/*
	管道流的应用：
*/
import java.io.*;
class PipedStream{
	public static void main(String[] args) throws IOException{
		//定义管道输出流对象和管道输入流对象。
		PipedOutputStream  out = new PipedOutputStream();
		PipedInputStream in = new PipedInputStream();
		//让管道输入流与输出流连接起来。
		in.connect(out);
		//注意：
		//将对象传入Read，Write类型对象的构造方法中。
		Read r = new Read(in);
		Write w = new Write(out);
		//为Read、Write类型对象创建线程，并启动线程。
		new Thread(r).start();
		new Thread(w).start();
		//注意：
		//1，管道输出流PIpedOutputStream类型对象是用来向管道内输入数组的。
		//2，管道输入流PIpedOInputStream类型对象是用来输出管道内的数组。
		//可以理解为：流对象对数据的处理，是站在数据对象自身的立场上来看待数据的操作，
		//上面可以理解为：自身就是数据对象，当自身被写入数据时，就将管道输出属性附加给自己，用来输出刚刚被写入的数据。
		//然后，输出的数据被送到管道输入流中，数据进入管道，等待被读取。
		//数据的读写操作，必须先写入数据才能被读取数据。
		//数据对象与管道的相互协作，跟数据与文件对象的相互协作类似。
	}
}
//继承Runnable接口，覆盖run方法。
class Read implements Runnable{
	private PipedInputStream in;
	Read(PipedInputStream i){
		this.in = i;
	}
	public void run(){
		try{ 
			//定义一个缓冲区，提高读取效率。
			byte[] buf = new byte[1024];
			System.out.println("阻塞前没有数据，读取前");
			//读取管道输入流中的数据。如果没有数据，就等待数据，称之为阻塞状态。
			int len = in.read(buf);
			System.out.println("读到数据，阻塞结束。");
			//调用String的构造方法，遍历缓冲区，将字符数组转化成字符串并返回。
			String s = new String(buf,0,len);
			System.out.println(s);
			in.close();
		}
		catch(IOException e){
			throw new RuntimeException("Reading PipedStream is fail ！");

		}

	}

}
class Write implements Runnable{
	//定义一个输出流管道对象
	private PipedOutputStream out;
	//通过构造函数，从外面接收一个输出流管道对象
	Write(PipedOutputStream o){
		this.out = o;
	}
	//覆盖Runnable中的Run方法；该方法有异常处理机制，但不能抛出异常，只能处理异常。
	public void run(){
		try{
			//调用管道输出流的write方法，写入字符串；
			//调用String的getBytes方法，将字符串转化为byte类型。
			out.write("piped lai la .".getBytes());
			System.out.println("写入人数据成功。");
			//关闭管道输出流。
			out.close();
		}
		//异常处理。
		catch(IOException e){
			throw new RuntimeException("管道输出流。");
		}
		
	}

}
