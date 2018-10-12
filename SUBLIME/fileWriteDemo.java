import java.io.*;
class fileWriteDemo{
	public static void main(String[] args) throws IOException{
		//创建一个FIleWriter对象时，会在指定目录下创建一个文件；
		//如果该目录下以后同名文件，该文件将会被覆盖。
		//其实该步骤就是要明确数据存放的地方。
		FileWriter fw = new FileWriter("demo.txt");
		//调用write方法，将字符串写入到流中；
		fw.write("Hello Evn Green");
		//刷新对象中的缓冲区的数据，将数据刷新到目的地；
		//如果没有刷新，数据就不会存到文件里面。
		fw.flush();
		//关闭流资源，在关闭之前会刷新缓冲区的资源到目的地中；
		//flush刷新后，可以再添加资源；但close就不可再写了。
		//每次对文件进行操作完成后都要调用close()关闭文件。
		fw.close();

	}
}