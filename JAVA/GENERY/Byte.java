public class Byte
{
	public static void main(String[] args){
		byte a = -128, b = (byte)128, c = (byte)129, d = (byte)130;
		byte e = (byte)-129, f = (byte)-130;
		System.out.println(a == ((byte)-a));
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		System.out.println(e);
		System.out.println(f);
	}
}