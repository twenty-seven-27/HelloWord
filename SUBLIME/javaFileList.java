/*
1,对指定目录进行递归。
2，获取递归过程中所有的Java文件路径。
3，对这些路径存储到集合中。
4，将集合中的数据写入另一个文件中。
*/
import java.io.*;
import java.util.*;
class javaFileList{
	public static void main(String[] args) throws IOException{
		File dir = new File("F:\\test\\jihe");
		//定义List集合，用来存储文件
		List<File> list = new ArrayList<File>();
		fileToList(dir, list);
		//打印集合的大小
		System.out.println(list .size());
		writeToFile(list,"F:\\test\\fileTable");
	}
	public static void fileToList(File dir, List<File> list){
		File[] files = dir.listFiles();
		for(File file : files){
			if(file.isDirectory())
				//递归调用fileToList()方法
				fileToList(file, list);
			else{
				if(file.getName().endsWith(".java"));
					list.add(file);
			}
		}
	}
	public static void writeToFile(List<File> list, String javaListFile) throws IOException{
		//目的，文本
		BufferedWriter bufw = null;
		try{
			bufw = new BufferedWriter(new FileWriter(javaListFile));
			for(File f : list){
				String path = f.getAbsolutePath();
				bufw.write(path);
				bufw.newLine();
				bufw.flush();
			}
		}
		catch(IOException e){
			throw e;
		}
		finally{
			try{
				if(bufw != null)
					bufw.close();
				}
			catch(IOException e){
				throw e;
			}
		}
	}
}