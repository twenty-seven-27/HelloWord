import java.util.*;
import java.io.*;
class propetiesDemo{
	public static void main(String[] args) throws IOException{
		method_1();
	}
	//��ʾ����ν����е����ݴ洢�������С�
	//��Ҫ��info.txt�еļ�ֵ���е����ݴ浽�����н��в�����
	/*
	˼·��
	1����һ������info.txt�ļ��������
	2����ȡһ�����ݣ������������á�=�����зָ
	3���Ⱥ����Ϊ�����ұ�Ϊֵ�����뵽Propeerties���ϼ��ɡ�
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