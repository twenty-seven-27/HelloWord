import java.io.*;
/*
用留的思想来操作数组。
*/
class ByteArrayStream{
	public static void main(String[] args){
		//数据源
		ByteArrayInputStream bais = new ByteArrayInputStream("ABCDEF".getBytes());
		//数组目的
		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		int by = 0;
		while((by=bais.read())!=-1){
			baos.write(by);
		}
		System.out.println(baos.size());
		System.out.println(baos.toString());
	}


}