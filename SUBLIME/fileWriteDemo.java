import java.io.*;
class fileWriteDemo{
	public static void main(String[] args) throws IOException{
		//����һ��FIleWriter����ʱ������ָ��Ŀ¼�´���һ���ļ���
		//�����Ŀ¼���Ժ�ͬ���ļ������ļ����ᱻ���ǡ�
		//��ʵ�ò������Ҫ��ȷ���ݴ�ŵĵط���
		FileWriter fw = new FileWriter("demo.txt");
		//����write���������ַ���д�뵽���У�
		fw.write("Hello Evn Green");
		//ˢ�¶����еĻ����������ݣ�������ˢ�µ�Ŀ�ĵأ�
		//���û��ˢ�£����ݾͲ���浽�ļ����档
		fw.flush();
		//�ر�����Դ���ڹر�֮ǰ��ˢ�»���������Դ��Ŀ�ĵ��У�
		//flushˢ�º󣬿����������Դ����close�Ͳ�����д�ˡ�
		//ÿ�ζ��ļ����в�����ɺ�Ҫ����close()�ر��ļ���
		fw.close();

	}
}