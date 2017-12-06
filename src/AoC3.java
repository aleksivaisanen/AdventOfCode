public class AoC3 {
	public static void main(String[] args){
		int input =277678;
		partone(input);
		parttwo(input);
		
	}
	public static void partone(int input) {
		//calculating the needed width and height of the matrix
		double width = Math.sqrt(input);
		int neededwidth = (int) Math.ceil(width);
		int[][] matrix = new int[neededwidth][neededwidth];
		int center = Math.round(neededwidth/2);
		
		int number = 1;
		int x = center;
		int y = center;
		matrix[x][y] = number;
		number++;
		for(int i = 3; i<= neededwidth; i+=2) {
			matrix[++x][y] = number;
			number++;
			for(int k = 0; k<(i-2); k++) {
				matrix[x][--y]= number;
				number++;
			}
			for(int k = 1; k< i; k++) {
				matrix[--x][y]=number;
				number++;
			}
			for(int k = 1; k<i; k++) {
				matrix[x][++y]=number;
				number++;
			}
			for(int k=1; k<i; k++) {
				matrix[++x][y]=number;
				number++;
			}
		}
		for(int i= 0; i<neededwidth;i++) {
			for(int k = 0; k< neededwidth; k++) {
				if(matrix[k][i]==277678) {
					int distance = (Math.abs(k-center)+Math.abs(i-center));
					System.out.println("Distance: " + distance);
				}
			}
		}
	}
	public static void parttwo(int input) {
		//calculating the needed width and height of the matrix
		double width = Math.sqrt(input);
		int neededwidth = (int) Math.ceil(width);
		int[][] matrix = new int[neededwidth][neededwidth];
		int center = Math.round(neededwidth/2);
		
		int number = 1;
		int x = center;
		int y = center;
		matrix[x][y] = number;
		boolean bigger = false;
		
		for(int i = 3; i<= neededwidth; i+=2) {
			if(!bigger) {
					number = partTwoSumMethod(number, matrix, x+1, y, neededwidth);
					matrix[++x][y] = number;
				if(number >= input) {
					System.out.println(number);
					bigger = true;
					break;
				}
				if(!bigger) {
					for(int k = 0; k<(i-2); k++) {
						number = partTwoSumMethod(number, matrix, x, y-1, neededwidth);
						matrix[x][--y]= number;

						if(number >= input) {
							System.out.println(number);
							bigger = true;
							break;
						}
					}
				}
				if(!bigger) {
					for(int k = 1; k< i; k++) {
						number = partTwoSumMethod(number, matrix, x-1, y, neededwidth);
						matrix[--x][y]=number;
						
						if(number >= input) {
							System.out.println(number);
							bigger = true;
							break;

						}
					}
				}
				if(!bigger) {
					for(int k = 1; k<i; k++) {
						number = partTwoSumMethod(number, matrix, x, y+1, neededwidth);
						matrix[x][++y]=number;
						
						if(number >= input) {
							System.out.println(number);
							bigger = true;
							break;
						}
					}
				}
				if(!bigger) {
					for(int k=1; k<i; k++) {
						number = partTwoSumMethod(number, matrix, 1+x, y, neededwidth);
						matrix[++x][y]=number;
						
						if(number >= input) {
							System.out.println(number);
							bigger = true;
							break;
						}
					}
				}
			}
		}
	}
	public static int partTwoSumMethod(int number, int[][] matrix, int x, int y, int neededwidth) {
		int sum = 0;
		int[][] matrixcopy = matrix;
		if((x+1)<neededwidth && (x+1)>=0) {
			sum += matrixcopy[x+1][y];
		}
		if((y+1)<neededwidth && (y+1)>=0) {
			sum += matrixcopy[x][y+1];			
		}
		if((x-1)<neededwidth && (x-1)>=0) {
			sum += matrixcopy[x-1][y];
		}
		if((y-1)<neededwidth && (y-1)>=0) {
			sum += matrixcopy[x][y-1];
		}
		if(((x+1)<neededwidth && (x+1)>=0)&&((y+1)<neededwidth && (y+1)>=0)) {
			sum += matrixcopy[x+1][y+1];
		}
		if(((x+1)<neededwidth && (x+1)>=0)&&((y-1)<neededwidth && (y-1)>=0)) {
			sum += matrixcopy[x+1][y-1];
		}
		if(((x-1)<neededwidth && (x-1)>=0)&&((y+1)<neededwidth && (y+1)>=0)) {
			sum += matrixcopy[x-1][y+1];
		}
		if(((x-1)<neededwidth && (x-1)>=0)&&((y-1)<neededwidth && (y-1)>=0)) {
			sum += matrixcopy[x-1][y-1];
		}

		return sum;
	}
}
