/*
1,��ָ��Ŀ¼���еݹ顣
2����ȡ�ݹ���������е�Java�ļ�·����
3������Щ·���洢�������С�
4���������е�����д����һ���ļ��С�
*/
import java.io.*;
import java.util.*;
class javaFileList{
	public static void main(String[] args) throws IOException{
		File dir = new File("F:\\test\\jihe");
		//����List���ϣ������洢�ļ�
		List<File> list = new ArrayList<File>();
		fileToList(dir, list);
		//��ӡ���ϵĴ�С
		System.out.println(list .size());
		writeToFile(list,"F:\\test\\fileTable");
	}
	public static void fileToList(File dir, List<File> list){
		File[] files = dir.listFiles();
		for(File file : files){
			if(file.isDirectory())
				//�ݹ����fileToList()����
				fileToList(file, list);
			else{
				if(file.getName().endsWith(".java"));
					list.add(file);
			}
		}
	}
	public static void writeToFile(List<File> list, String javaListFile) throws IOException{
		//Ŀ�ģ��ı�
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