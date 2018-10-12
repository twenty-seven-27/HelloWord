import java.util.Scanner;
public class LotteryArray
{
	public static void main(String [] args){
		int[][] matrix = new int[10][10];
		int[][] matrix1 = new int[10][10];
		//使用输入值初始化数组
		// Scanner input = new Scanner(System.in);
		// System.out.println("Enter" + matrix.length + "rows and" + matrix[0].length + "columns:");
		// for(int row = 0; row < matrix.length; row++){
		// 	for(int column = 0; column < matrix[row].length; column++){
		// 		matrix[row][column] = input.nextInt();
		// 	}
		// }
		//使用随机值初始化数组
		for(int row = 0; row < matrix1.length; row++){
			for(int column = 0; column < matrix1[row].length; column++){
				matrix1[row][column] = (int)(Math.random()*100);
			}
		}
		//打印数组
		// System.out.println("matrix: ");
		// for(int row = 0; row < matrix.length; row++){
		// 	for(int column = 0; column < matrix[row].length; column++){
		// 		System.out.print(matrix[row][column] + "");
		// 	}
		// 	System.out.println();
		// }
		System.out.println("matrix1: ");
		for(int row = 0; row < matrix1.length; row++){
			for(int column = 0; column < matrix1[row].length; column++){
				System.out.print(matrix1[row][column] + " ");
			}
			System.out.println();
		}
		//求所有元素的和
		int total = 0;
		for(int row = 0; row < matrix1.length; row++){
			for(int column = 0; column < matrix1[row].length; column++){
				total += matrix1[row][column];
			}
		}
		System.out.println("total is :" + total);
		//对数组按列求和
		for(int column = 0; column < matrix1[0].length; column++){
			int total1 = 0;
			for(int row = 0; row < matrix1.length; row++){
				total1 += matrix1[row][column];	
			}
			System.out.println("Sum for column " + column + " is " + total1);
		}
		//哪一行的和最大？
		int maxrow = 0;
		int IndexOfMaxrow = 0;
		for(int column = 0; column < matrix1[0].length; column++){
			maxrow += matrix1[0][column];
		}
		for(int row = 0; row < matrix1.length; row++){
			int TotalOfRow = 0;
			for(int column = 0; column < matrix1[row].length; column++){
				TotalOfRow += matrix1[row][column];
			}
			if(TotalOfRow > maxrow){
				maxrow = TotalOfRow;
				IndexOfMaxrow = row;
			}

		}
		System.out.println("Row " + IndexOfMaxrow + " has the maximum sum of " + maxrow);
		//随意打乱
		for(int i = 0; i < matrix1.length; i++){
			for(int j = 0; j < matrix1[i].length; j++){
			int i1 = (int)(Math.random()*matrix1.length); 
			int j1 = (int)(Math.random()*matrix1[i].length);
			int temp = matrix1[i][j]; 
			matrix1[i][j] = matrix1[i1][j1];
			matrix1[i1][j1] = temp;
			}	
		 }

		 System.out.println("matrix1: ");
		for(int row = 0; row < matrix1.length; row++){
			for(int column = 0; column < matrix1[row].length; column++){
				System.out.print(matrix1[row][column] + " ");
			}
			System.out.println();
		}
		//input.close();

	}
 
} 