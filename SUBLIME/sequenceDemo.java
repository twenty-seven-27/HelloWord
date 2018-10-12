import java.io.*;
import java.util.*;
/*
��������1.txt��2.txt,3.txt�����ļ�����Ҫ�������ļ��ϲ���һ���ļ���
������
1���Ƚ������ļ�����������һ����һ���Ĵ���Vector���ϡ�
2������SequenceInputStream��Vector�����е�Ԫ�����ϵ�һ�����У���ΪԴ��
3��������Ŀ�ģ��������������
4�����������е����ݴ浽������С�
5�����������������

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
		//��ΪSequenceInputStream��InputStream�����࣬���Կ��Ե���read������
		while((len=sis.read(buf)) != -1){
			fos.write(buf,0,len);
		}
		fos.close();
		sis.close();
	}
}