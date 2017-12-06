import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class AoC6 {
	public static void main(String[] args) {
		int[] input = {11,11,13,7,0,15,5,5,4,4,1,1,7,1,15,11};
		partone(input);
	}
	public static void partone(int[] input) {
		List<int[]> myList = new ArrayList<int[]>();
		int max=input[0];
		int index = 0;
		int cycles = 0;
		
		whileloop:
		while(true) {
			for(int i = 0; i<input.length; i++) {
				if(input[i]>max) {
					max = input[i];
					index = i;
				}
			}
			input[index]= 0;
			for(int i = 0; i<max;i++) {
				
				int j = i;
				if(i>=input.length) {
					j-=(input.length);
				}
				
				if(i==input.length) {
					input[index]++;
				}
				if(j!=index) {
					input[j]++;
				}
				System.out.println(input[j]);
			}
			System.out.println("");
			
			for(int i = 0; i<myList.size(); i++) {
				if(Arrays.equals(input, myList.get(i))) {
					System.out.println("break is true");
					break whileloop;
				}
			}
			myList.add(input);
			cycles ++;
		}
		System.out.println("Number of cycles: "+cycles);
	}
}
