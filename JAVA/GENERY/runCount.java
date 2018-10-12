import java.io.*;
import java.util.*;
class runCount{
	public static void main(String[] args) throws IOException{
		Properties prop = new Properties();
		//将配置文件定义为文件对象
		File file = new File("/Users/xieliting/JAVA/test/init.ini");
		//如果文件不存在就创建文件
		if(!file.exists())
			file.createNewFile();
		FileInputStream fis = new FileInputStream(file);
		//从配置文件输入字节流中读取属性列表
		prop.load(fis);

		//用count表示程序运行的次数
		int count = 0;
		//定义value存取times的值
		String value = prop.getProperty("times");
		System.out.println("times="+prop.getProperty("times"));
		if(value!=null){
			count = Integer.parseInt(value);
			if(count>=5){
				System.out.println("pay for it .");
				return ;
			}
		}
		count++;
		//更新映射表的信息
		prop.setProperty("times",count+"");
		System.out.println("times="+prop.getProperty("times"));
		//定义输出流对象
		FileOutputStream fos = new FileOutputStream(file);
		//将properties映射表中的数据存回到文件夹中。
		prop.store(fos,"");
		fis.close();
		fos.close();
	}
}