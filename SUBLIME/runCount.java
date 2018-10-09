import java.io.*;
import java.util.*;
class runCount{
	public static void main(String[] args){
		Properties prop = new Properties();
		File file = new File("F:\\test\\count.ini");
		if(!file.exits())
			file.createNewFile();
		FileInputStream fis = new FileInputStream(file);
		prop.load(fis);

		int count = 0;
		String vlue = prop.getProperty("time");
		if(vlue!=null){
			count = Integer.parseInt(value);
			if(count>=5){
				System.out.println("pay for it .");
				return ;
			}
		}
		count++；
		prop.setProperty("time",count+"");
		FileOutputStream fos = new FileOutputStream(file);
	}
}