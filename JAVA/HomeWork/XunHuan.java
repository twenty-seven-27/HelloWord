/*
1、循环控制
   创建一个二维数组；int型；数据通过Math.random产生；注意60-100之间；
    对数组进行排序；分别是升序和降序；分别用选择和冒泡实现
2、求两个数的最大公约数

*/
import java.util.Scanner;
public class XunHuan{
	public static void main(String[] args){
	Scanner input = new Scanner(System.in);

/* 第一题 */
		System.out.println("原始二维数组");
		int[][] randomm = new int[10][10];
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 10; j++){
				randomm[i][j] = (int)(Math.random()*41+60); //随机数函数
				System.out.print(randomm[i][j]+"  ");
			}
			System.out.println();
		}
/* 冒泡排序 */
		System.out.println("冒泡升序");
		for(int k=0; k<10; k++){
			for(int l=0; l<10; l++){
				for(int i=0; i < 10-k; i++){
					for(int j=0; j < 10; j++){
						if(j!=9 && randomm[i][j] > randomm[i][j+1] ){
							int tmp = randomm[i][j];
							randomm[i][j] = randomm[i][j+1];
							randomm[i][j+1] = tmp;
						}
						if(j == 9 && i != 9 && randomm[i][j]> randomm[i+1][0]){ //从上一行到下一行的比较
							int tmp = randomm[i][j];
							randomm[i][j] = randomm[i+1][0];
							randomm[i+1][0] = tmp;	
						}
					}
				}
		
			}
		}
		//输出二维数组
		for(int i=0; i<10; i++){
			for(int j=0; j<10; j++){
				System.out.print(randomm[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();


/* 选择升序 */
		System.out.println("选择升序");
		for(int k = 0; k < 10; k++){
			for(int l = 0; l < 10; l++){
				int j = l + 1;
				int mini = k, minj = l;
				for(int i = k; i < 10; i++){
					for(; j < 9; j++){
						if(randomm[mini][minj] > randomm[i][j]){
							mini = i;
							minj = j;
						}
					}
					randomm[k][l] = randomm[mini][minj];
 					j = 0;
				}
				System.out.print(randomm[k][l] + "  ");
				
			}
			System.out.println();
		}
			System.out.println();

		System.out.println("冒泡降序");	
/* 冒泡降*/
		for(int k=0; k<10; k++){
			for(int l=0; l<10; l++){
				for(int i=0; i < 10-k; i++){
					for(int j=0; j < 10; j++){
						if(j!=9 && randomm[i][j] < randomm[i][j+1] ){
							int tmp = randomm[i][j];
							randomm[i][j] = randomm[i][j+1];
							randomm[i][j+1] = tmp;
						}
						if(j == 9 && i != 9 && randomm[i][j]< randomm[i+1][0]){
							int tmp = randomm[i][j];
							randomm[i][j] = randomm[i+1][0];
							randomm[i+1][0] = tmp;	
						}
					}
				}
		
			}
		}
		//输出数组
		for(int i=0; i<10; i++){
			for(int j=0; j<10; j++){
				System.out.print(randomm[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();


/* 选择降序 */
		System.out.println("选择降序");
		for(int k = 0; k < 10; k++){
			for(int l = 0; l < 10; l++){
				int j = l + 1;
				int mini = k, minj = l;
				for(int i = k; i < 10; i++){
					for(; j < 9; j++){
						if(randomm[mini][minj] < randomm[i][j]){
							mini = i;
							minj = j;
						}
					}
					randomm[k][l] = randomm[mini][minj];
 					j = 0;
				}
				System.out.print(randomm[k][l] + "  ");

			}
			System.out.println();
		}
		System.out.println();
/* 第二题 */
		System.out.println("请输入两个整数");
		int m = input.nextInt();
		int n = input.nextInt();
		if(m < n){
			for(int i = m; i > 0; i--){
				if(n%i == 0 && m%i ==0){
					System.out.println(n + " 和 " + m + "的最大公约数为：" + i); break;
				}
			}

		}
		else {
			for(int i = n; i > 0; i--){
				if(m%i == 0 && n%i == 0){
					System.out.println(n + " 和 " + m + "的最大公约数为：" + i); break;
				}
			}
		}
 	}
 }


