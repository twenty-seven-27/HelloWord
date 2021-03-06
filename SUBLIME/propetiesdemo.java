import java.util.*;
import java.io.*;
class propetiesDemo{
	public static void main(String[] args) throws IOException{
		method_1();
	}
	//演示：如何将流中的数据存储到集合中。
	//想要将info.txt中的键值对中的数据存到集合中进行操作。
	/*
	思路：
	1，用一个流有info.txt文件相关联。
	2，读取一行数据，将该行数据用“=”进行分割。
	3，等号左边为键，右边为值，存入到Propeerties集合即可。
	*/
	public static void method_1() throws IOException{
		BufferedReader bufr = new BufferedReader(new FileReader("F:\\test\\info.txt"));
		String line = null;
		Properties prop = new Properties();
		while((line=bufr.readLine())!= null){
			String[] arr = line.split("=");
			prop.setProperty(arr[0],arr[1]);
		}
		bufr.close();
		System.out.println(prop);

	}
}