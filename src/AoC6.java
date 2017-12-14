import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AoC6 {
	public static void main(String[] args) {
		int[] input = {11,11,13,7,0,15,5,5,4,4,1,1,7,1,15,11};
		solution(input);
	}
	public static void solution(int[] input) {
		List<int[]> myList = new ArrayList<int[]>();
		int cycles = 1;
		
		whileloop:
		while(true) {
			int max=input[0];
			int maxindex = 0;
			myList.add(Arrays.copyOf(input, input.length));
			//checking for max value in array
			for(int i = 0; i<input.length; i++) {
				if(input[i]>max) {
					max = input[i];
					maxindex = i;
				}
			}
			//changing the value with the biggest value to 0
			input[maxindex]= 0;
			
			//distributing the value amongst the other elements
			for(int i = 0; i<max; i++){
				int index = (maxindex+i+1)%(input.length);
				input[index]++;
			}
			
			//checking if the array has been the same before 
			for(int i = 0; i<myList.size(); i++) {
				if(Arrays.equals(input, myList.get(i))) {
					System.out.println("Answer to part 2:\nNumber of cycles between the two equal arrays: "+(myList.size()-i));
					break whileloop;
				}
			}

			cycles ++;
		}
		System.out.println("Answer to part 1:\nNumber of cycles: "+cycles);
	}
}
