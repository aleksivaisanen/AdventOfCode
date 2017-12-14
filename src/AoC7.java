import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;


public class AoC7 {
	public static void main(String[] args) {	
		try {	
			BufferedReader br = new BufferedReader(new FileReader("./inputs/inputd7p1.txt"));
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
			partone(everything);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	public static void partone(String everything) {
		Scanner scan = new Scanner(everything);
		if(scan.hasNextLine()) {
			String line = scan.nextLine();
			String[] str = line.split(" ");
			findRoot(everything, str[0]);
		}
		scan.close();
	}
	public static void findRoot(String everything, String name) {
		Scanner scan = new Scanner(everything);
		while(scan.hasNextLine()) {
			String line = scan.nextLine();
			String[] str = line.split(" ");
			if(str.length>2 && (name != str[0])) {
				for(int i = 3; i< str.length; i++) {
					if(str[i].contains(name)) {
						findRoot(everything, str[0]);
						scan.close();
						return;
					}
				}
			}
		}
		System.out.println("Answer to part one: "+ name );
		scan.close();
	}
	
	//part two methods
	
	
	public static void parttwo(String everything) {
		Scanner scan = new Scanner(everything);
		while(scan.hasNextLine()) {
			String line = scan.nextLine();
		}
		
	}
	public static int getWeight(String line) {
		String[] split = line.split(" ");
		return Integer.parseInt(split[1].replaceAll("[\\D]", ""));
	}
}
