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
		for(int i = 0; i<input.length; i++) {
			if(input[i]>max) {
				max = input[i];
				index = i;
			}
		}
		input[index]=0;
		int remainder = max%input.length;
		int quotient = max/input.length;
		for(int i = 0; i<input.length; i++) {
			input[i]
		}
	}
}
