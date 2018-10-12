import java.io.*;
class MyBufferedInputStream1{
	private InputStream is;
	private byte[] buf = new byte[1024*4];
	private int pos, count;
	MyBufferedInputStream1(InputStream it){
		this.is = it;
	}
	//一次从缓冲区读取一个字节；
	//为什么不返回byte类型呢？
	//为解决开头读到八个1时，返回-1的情况；对字节进行提升，
	//在前面补上0，这样就能保证数值没有变化，又能防止返回-1；
	//为了在前面补0，我们就让byte类型的数据提升后和255进行按位与操作即可。
	public int myRead() throws IOException{
		//通过is对象读取硬盘上的数据，并存到buf中。
		if(count==0) {
			count = is.read(buf);
			if(count<0)
				return -1;
			pos = 0;
			byte b = buf[pos];
			count--;
			pos++;
			return b&0xffff;
		}
		else if(count>0) {
			byte b = buf[pos];
			count--;
			pos++;
			return b&0xffff;
		}
		return -1;
	}
	public void myClose()throws IOException{
		is.close();
	}
}
public class MyBufferedInputStream {
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		try {
			copy_2();
		}
		catch(Exception e) {
			System.out.println("拷贝失败！");
		}
		long end = System.currentTimeMillis();
		System.out.println((end-start)+"ms");
	} 
	public static void copy_2() throws IOException{
		MyBufferedInputStream1 mbis = new MyBufferedInputStream1(new FileInputStream("/Users/xieliting/Music/1.mp3"));
		BufferedOutputStream bfos = new BufferedOutputStream(new FileOutputStream("/Users/xieliting/Music/2.mp3"));
		System.out.println("第一个字节："+mbis.myRead());
		int by = 0;
		while((by=mbis.myRead())!= -1) {
			bfos.write(by);
		}
		mbis.myClose();
		bfos.close();
	}
}