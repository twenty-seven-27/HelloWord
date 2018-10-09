import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
public class CopyMp3 {public static void main(String[] args) throws IOException {
BufferedInputStream bis = null;BufferedOutputStream bos = null;bis = new BufferedInputStream(new FileInputStream("D:\\b\\a\\任贤齐 - 花好月圆.mp3"));
bos = new BufferedOutputStream(new FileOutputStream("D:\\music\\任贤齐 - 花好月圆.mp3"));byte[] bytes = new byte[1024];int len;while((len = bis.read()) != -1) {bos.write(bytes, 0, len);}bis.close();bos.close();}
}

