import java.io.*;
import java.util.*;
/*
需求：现有1.txt，2.txt,3.txt三个文件；先要把三个文件合并到一个文件。
分析：
1，先将三个文件输入流对象一个接一个的存入Vector集合。
2，再用SequenceInputStream将Vector集合中的元素整合到一个流中，作为源。
3，再声明目的，定义输出流对象。
4，将输入流中的数据存到输出流中。
5，输入流和输出流。

*/
class sequenceDemo{
	public static void main(String[] args) throws IOException{
		Vector<FileInputStream> v = new Vector<FileInputStream>();
		v.add(new FileInputStream("f:\\test\\1.txt"));
		v.add(new FileInputStream("f:\\test\\2.txt"));
		v.add(new FileInputStream("f:\\test\\3.txt"));
		Enumeration<FileInputStream> en = v.elements();
		SequenceInputStream sis = new SequenceInputStream(en);
		FileOutputStream fos = new FileOutputStream("f:\\test\\4.txt");
		byte[] buf = new byte[1024];
		int len = 0;
		//因为SequenceInputStream是InputStream的子类，所以可以调用read方法。
		while((len=sis.read(buf)) != -1){
			fos.write(buf,0,len);
		}
		fos.close();
		sis.close();
	}
}