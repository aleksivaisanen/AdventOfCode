import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class AoC2 {
	public static void main(String[] args) {
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("./inputs/inputd2p1.txt"));
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();
			while(line != null) {
				sb.append(line);
				sb.append(System.lineSeparator());
				line = br.readLine();
			}
			String everything = sb.toString();
			br.close();
			partone(everything);
			parttwo(everything);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	public static void partone(String everything) {
		Scanner scan = new Scanner(everything);

		int checksum = 0;
		while(scan.hasNextLine()) {
			String line = scan.nextLine();
			String[] values = line.split("	");
			int max = Integer.parseInt(values[0]);
			int min = Integer.parseInt(values[0]);
			for(String value : values) {
				if(Integer.parseInt(value)> max) {
					max = Integer.parseInt(value);
				}
				if(Integer.parseInt(value)<min) {
					min = Integer.parseInt(value);
				}
			}
			int difference = max - min;
			checksum += difference;
		}
		scan.close();
		System.out.println("Answer for part one: "+checksum);
	}
	public static void parttwo(String everything) {
		Scanner scan = new Scanner(everything);
		int checksum = 0;
		while(scan.hasNextLine()) {
			String line = scan.nextLine();
			String[] values = line.split("	");
			for(int i = 0; i< values.length; i++) {
				for(int k = 0; k < values.length; k++) {
					if(i != k && Integer.parseInt(values[i])>Integer.parseInt(values[k])) {
						int division = Integer.parseInt(values[i]) % Integer.parseInt(values[k]);
						if(division == 0) {
							checksum += Integer.parseInt(values[i])/Integer.parseInt(values[k]);
						}
					}
				}
			}
		}
		scan.close();
		System.out.println("Answer for part two: "+checksum);
	}
}
