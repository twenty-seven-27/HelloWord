/*
��ӡ����
�ô�ӡ���ṩ��ӡ����,���Խ������������Ͷ�ԭ����ӡ�� 

�ֽڴ�ӡ����
PrintStream
���캯�����Խ��ܵĲ������ͣ�
	1��file����,File
	2���ַ���·��,String
	2���ֽ��������OutputStream
�ַ���ӡ����
PrintWriter
���캯�����Խ��ܵĲ������ͣ�
	1��file����,File
	2���ַ���·��,String
	2���ֽ��������OutputStream
	4,�ַ��������Writer


*/
//�Ӽ������룬�ӿ���̨���
/*
import java.io.*;
class PrintWriter{
	public static void main(String[] args) throws IOException{
		BufferedReader bufr = 
			new BufferedReader(new InputStreamReader(System.in));
		//System.out��PrintStream���ͣ�
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
//�Ӽ������룬������ļ�
import java.io.*;
class PrintWriter{
	public static void main(String[] args) throws IOException{
		BufferedReader bufr = 
			new BufferedReader(new InputStreamReader(System.in));
		//System.out��PrintStream���ͣ�
		//FileWrite���ļ���װ�������������Ϳ��Դ���true������
		//true���������ã��Զ�ˢ�£����Ϊfalse�Ͳ�ˢ�£���ֻˢ��println,printf,format.
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
