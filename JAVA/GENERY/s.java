import java.util.Scanner;
public class s
{
	public static void main(String [] args){
		int[][] matrix = new int[10][10];
		int[][] matrix1 = new int[10][10];
		//使用输入值初始化数组
		Scanner input = new Scanner(System.in);
		System.out.println("Enter" + matrix.length + "rows and" + matrix[0].length + "columns:");
		for(int row = 0; row < matrix.length; row++){
			for(int column = 0; column < matrix[row].length; column++){
				matrix[row][column] = input.nextInt();
			}
		}
		//使用随机值初始化数组
		//打印数组
		//求所有元素的和
		//对数组按列求和
		//哪一行的和最大？
		//随意打乱
		// for(int i = 0; i < matrix.length; i++){
		// 	for(int j = 0; j < matrix[i].length; j++){
		// 	int j1 = (int)(Math.random()*matrix.length); 
		// 	int j1 = (int)(Math.random()*matrix[i].length);
		// 	int temp = matrix[i][j]; 
		// 	matrix[i][j] = matrix[i1][j1];
		// 	matrix[i1][j1] = temp;
		// 	}	
		// }
		input.close();

	}
 
} 