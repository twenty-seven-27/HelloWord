/*
通过程序的理解会发现：
RandomAccessFile其实就是把文件的内容装入数组，像操作数组一样操作文件的内容，让操作文件变得更灵活；
需要掌握的是：
writeInt();
ReadInt();
seek();
skipBytes();
*/
import java.io.*;
class RandomAccess{
	public static void main(String[] args) throws IOException{
		//向文件内写入内容（按顺序写入）
		writeFile();
		//读取文件内容，可以是顺序读取，也可以是随机读取。
		ReadFile();
		//向文件内随机写入内容
		writeFile_2();
	}
	public static void ReadFile() throws IOException{
		//注意：操作文件模式的重要性。
		RandomAccessFile raf = new RandomAccessFile("ran.txt","r");
		//seek方法用来指定读指针的初始位置，位置的单位是“位”。
		raf.seek(10*1);
		byte[] buf = new byte[6];
		//跳过前面数位。该方法的缺点就是：只能往前跳，不能往后跳；而seek方法就可以往后跳。
		//跳过前面10位。
		raf.skipBytes(10);
		raf.read(buf);
		String name = new String(buf);
		int age = raf.readInt();
		System.out.println("name: "+name+"; age: "+age);
		raf.close();
	}
	public static void writeFile() throws IOException{
		RandomAccessFile raf = new  RandomAccessFile("ran.txt", "rw");
		raf.write("李四".getBytes());
		//write方法只写入最低八位，就是byte类型
		//这里应该用RandomAccessFile类型对象的writeInt方法，直接写入8位，防止数据的丢失。
		raf.writeInt(97);

		raf.write("张三".getBytes());
		raf.writeInt(288);
		raf.close();
	}
	//随机写入；
	public static void writeFile_2() throws IOException {
		RandomAccessFile raf = new  RandomAccessFile("ran.txt", "rw");
		raf.seek(10*5);
		raf.write("周期".getBytes());
		raf.writeInt(103);
		raf.close();		
	}
	//用RandomAccessFile操作文件除了可以随机读写，还可以随机修改！！！！
}