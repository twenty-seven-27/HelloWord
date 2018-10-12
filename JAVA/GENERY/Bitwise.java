public class Bitwise 
{
	public static void main(String[] args)
	{
		byte data1 = 'a';
		byte data2 = 'b';
		char t ;
		Byte rs1, rs2;
		t = (char)(data1 << 8);
		t = (char)(t+data2);
		System.out.println("t = " +t);
		rs1 = (char)(t >> 8);
		rs2 = (char)(t & 0x00ff);
		System.out.println("rs1 = "+rs1, "rs2 = "+rs2, "t = "+t );

	}
