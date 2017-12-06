import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class AoC5 {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new FileReader("./inputs/inputd5p1.txt"));
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();
			int lines = 0;
			while(line != null) {
				sb.append(line);
				sb.append(System.lineSeparator());
				line = br.readLine();
				lines++;
			}
			String everything = sb.toString();
			br.close();
			partone(lines, everything);
			parttwo(lines, everything);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	public static void partone(int lines, String everything) {
		int[] array = new int[lines];
		Scanner scan = new Scanner(everything);
		int i = 0;
		while(scan.hasNextLine()) {
			array[i] = Integer.parseInt(scan.nextLine());
			i++;
		}
		int steps = 0;
		i=0;
		try {
			while(true) {
				int number = array[i];
				int j = i;
				i+=number;
				array[j]++;
				steps++;
			}
		}catch(Exception e) {
			System.out.println("Number of steps: "+steps);
		}
	}
	public static void parttwo(int lines, String everything) {
		int[] array = new int[lines];
		Scanner scan = new Scanner(everything);
		int i = 0;
		while(scan.hasNextLine()) {
			array[i] = Integer.parseInt(scan.nextLine());
			i++;
		}
		int steps = 0;
		i=0;
		try {
			while(true) {
				int number = array[i];
				int j = i;
				i+=number;
				if(number>=3) {
					array[j]--;
				}
				else {
					array[j]++;
				}
				steps++;
			}
		}catch(Exception e) {
			System.out.println("Number of steps: "+steps);
		}
	}
}
