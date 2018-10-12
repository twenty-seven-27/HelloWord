import java.util.Scanner;  // 包含输入流头文件  
  
public class ScannerLiu {  
  
     public static void main(String[] args) {   
           
         Scanner scanner = new Scanner(System.in);   // 打开输入流  
           
         System.out.println("请输入字符串，以'0'结束：");   
         while(!scanner.hasNext("0")){    // 以"0"字符串结束输入,否则返回true  
             String str=scanner.next();   // 等待输入一个字符串（会跳过空格、Tab和回车）  
             System.out.println(str);  
         }  
         scanner.next();  // 把结束的"0"从缓冲区清除掉  
             
         System.out.println("请输入字符串，以'exit'结束");   
         while (true) {   
             String line = scanner.nextLine();  // 等待输入一个字符串，只会跳过回车  
             if (line.equals("exit")) break;  // 输入exit跳出循环  
             System.out.println(line);   
         }   
           
         System.out.println("请输入一个浮点数：");   
         double b = scanner.nextDouble(); //输入一个浮点数  
         System.out.println(String.format("%.2f", b)); //保留2位小数  
         // 另外一种控制输出格式的方法  
         java.text.DecimalFormat df = new java.text.DecimalFormat("#.0");  
         System.out.println(df.format(b));  //保留一位小数  
           
         System.out.println("请输入数组长度：");   
         int a = scanner.nextInt();  //输入一个整数  
         int[] arr = new int[a];  // 输入的整数作为数组的大小  
         System.out.println("请输入 "+ a + " 个整数：");   
         for (int i=0; i<a; i++) {  
             arr[i]=scanner.nextInt(); // 输入整数  
         }  
         for (int i=0; i<a; i++) {  
             System.out.print(arr[i] + " ");  
         }  
           
         scanner.close(); //重要，代表关闭输入流，不然会有警告  
         System.out.println("输入结束!!!");   
     }   
  
}  
