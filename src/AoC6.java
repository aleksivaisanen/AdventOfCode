import java.util.List;
import java.util.ArrayList;

public class AoC6 {
	public static void main(String[] args) {
		int[] input = {11,11,13,7,0,15,5,5,4,4,1,1,7,1,15,11};
		partone(input);
	}
	public static void partone(int[] input) {
		List<int[]> myList = new ArrayList<int[]>();
		myList.add(input);
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
			input[index]=0;
			int remainder = max%input.length;
			System.out.println(remainder);
			int quotient = max/input.length;
			for(int i = 0; i<input.length; i++) {
				if((i!=index) && quotient > 0) {
					input[i]= remainder;
					input[index]=quotient;	
					System.out.println(input[i]);
				}
				else if(quotient == 0) {
					input[i]=remainder;
				}
			}
			for(int i = 0; i<myList.size(); i++) {
				if(input == myList.get(i)) {
					break whileloop;
				}
			}
			myList.add(input);
			cycles ++;
		}
		System.out.println("Number of cycles: "+cycles);
	}
}
