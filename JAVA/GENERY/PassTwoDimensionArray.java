public class PassTwoDimensionArray{
	public static void main(String[] args){
		int[][] m = getArray();
		System.out.println("Sum of all elements is " + sum(m));
 	}
 	public static int [][] getArray(){
		int[][] m = new int[10][10];
		for(int row = 0; row < m.length; row++){
			for(int column = 0; column < m[row].length; column++){
				m[row][column] = (int)(Math.random()*100);
			}
		}
		return m;
	}
	public static int sum(int[][] m){
		int total = 0;
		for(int row = 0; row < m.length; row++){
			for(int column = 0; column < m[row].length; column++){
				total += m[row][column];
			}
		}
		return total;
}	
}
