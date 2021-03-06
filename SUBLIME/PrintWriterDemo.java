/*
打印流：
该打印流提供打印方法,可以将各种数据类型都原样打印。 

字节打印流：
PrintStream
构造函数可以接受的参数类型：
	1，file对象,File
	2，字符串路径,String
	2，字节输出流，OutputStream
字符打印流：
PrintWriter
构造函数可以接受的参数类型：
	1，file对象,File
	2，字符串路径,String
	2，字节输出流，OutputStream
	4,字符输出流，Writer


*/
//从键盘输入，从控制台输出
/*
import java.io.*;
class PrintWriter{
	public static void main(String[] args) throws IOException{
		BufferedReader bufr = 
			new BufferedReader(new InputStreamReader(System.in));
		//System.out是PrintStream类型！
		PrintStream out = new PrintStream(System.out);
		String line = null;
		while((line=bufr.readLine())!=null){
			if("over".equals(line))
				break;
			out.println(line.toUpperCase());
			out.flush();
		}
		out.close();
		bufr.close();
	}
}
*/
//从键盘输入，输出到文件
import java.io.*;
class PrintWriter{
	public static void main(String[] args) throws IOException{
		BufferedReader bufr = 
			new BufferedReader(new InputStreamReader(System.in));
		//System.out是PrintStream类型！
		//FileWrite将文件封装成流对象，这样就可以传入true参数了
		//true参数的作用：自动刷新；如果为false就不刷新，但只刷新println,printf,format.
		PrintWriter out = new PrintWriter("a.txt");
		String line = null;
		while((line=bufr.readLine())!=null){
			if("over".equals(line))
				break;
			out.println(line.toUpperCase());
			out.flush();
		}
		out.close();
		bufr.close();
	}
}
