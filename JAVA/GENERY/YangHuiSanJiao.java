public class YangHuiSanJiao
{
	public static void main(String[] args)
	{
		int N = 10;
		int [][] a = new int[N][];
		a[0] = new int [1]; //第一行开辟一个空间
		a[0][0] = 1;
		for(int i = 1; i < N; i++)
		{
			int m=i;
			a[m] = new int [m+1]; //第 i 行开辟i+1个空间
			a[m][m] = 1;
			a[m][0] = 1;
			for(int j = m+1; j>0&&j<N; j--)
			{
				
				if(m >= 2)
				{
					a[m][j] = a[m-1][j-1] + a[m-1][j];
				}
			}
		}
		int tap = 30;
		for(int i = 0; i < N; i++)
		{
			for(int j = 0; j < a[i].length; j++)
			{
				System.out.println(a[i][j]);
			}
		}
	}

}


/*public class YangHuiSanJiao
{
	public static void main(String[] args)
	{
		int N = 10;
		int[][] a= new int [N][N];
		a[0][0] = 1;
		for(int i=0; i<N; i++)
		{
			for(int j=i+1; j>0&&j<N; j--)
			{
				a[i][i]=1;
				a[i][0]=1;
				if(i>=2)
				{
					a[i][j] = a[i-1][j-1] + a[i-1][j];
				}
			}
		}
	}

}
*/
