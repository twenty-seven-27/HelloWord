import java.io.*;
import java.util.*;
class SplitFile{
	public static void main(String[] args) throws IOException{
		//将图片文件切片
		//splitFile();
		//将图片碎片文件重新合成图片
		merge();
	}
	//合并碎片文件函数
	public static void merge() throws IOException{
		//便利碎片文件，将其一次存入集合
		ArrayList<FileInputStream> al = new ArrayList<FileInputStream>();
		for(int x=1; x<=3; x++){
			al.add(new FileInputStream("f:\\test\\splitfile\\"+x+".part"));
		}
		//用迭代器，调用Enumeration对象
		Iterator<FileInputStream> it = al.iterator();
		Enumeration<FileInputStream> en = new Enumeration<FileInputStream>(){
			public boolean hasMoreElements(){
				return it.hasNext();
			}
			public FileInputStream nextElement(){
				return it.next();
			}
		};
		//定义字节合并流对象，用来作为一个源。
		SequenceInputStream sis = new SequenceInputStream(en);
		//定义输出流对象，并用缓冲区提高字节输出流写入效率
		FileOutputStream fos = new FileOutputStream("f:\\test\\b.png");
		byte[] buf = new byte[1024];
		int len = 0;
		while((len=sis.read(buf)) != -1){
			fos.write(buf,0,len);
		}
		fos.close();
		sis.close();
	}
	//文件切片函数
	public static void splitFile() throws IOException{
		FileInputStream fis = new FileInputStream("f:\\test\\a.png");
		FileOutputStream fos = null;
		byte[] buf = new byte[1024*1024];
		int len = 0;
		int count = 1;
		while((len=fis.read(buf)) != -1){
			fos = new FileOutputStream("f:\\test\\splitfile\\"+count+".part");
			fos.write(buf, 0, len);
			count++;
			
		}
		fos.close();
		fis.close();
	}
}