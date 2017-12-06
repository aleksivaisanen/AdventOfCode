import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

public class AoC4 {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new FileReader("./inputs/inputd4p1.txt"));
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
	public static void partone(String input) {
		Scanner scan = new Scanner(input);
		int validpassphrases = 0;
		boolean valid = true;
		int lines = 0;
		while(scan.hasNextLine()) {
			String[] line = scan.nextLine().split(" ");
			lines++;
			outerloop:
			for(int i = 0; i< line.length; i++) {
				if(valid) {	
					for(int k = 0; k<line.length; k++) {
						if(!(i==k)){
							if(line[i].equals(line[k])) {
								valid = false;
								break outerloop;
							}
						}
					}
				}
			}
			if(valid) {
				validpassphrases++;
			}
			valid = true;
		}
		scan.close();
		System.out.println("lines: "+lines);
		System.out.println("Number of valid passphrases: "+validpassphrases);
	}
	public static void parttwo(String input) {
		Scanner scan = new Scanner(input);
		int validpassphrases = 0;
		boolean valid = true;
		int lines = 0;
		while(scan.hasNextLine()) {
			String[] line = scan.nextLine().split(" ");
			lines++;
			outerloop:
			for(int i = 0; i< line.length; i++) {
				if(valid) {	
					for(int k = 0; k<line.length; k++) {
						if(i!=k){
							if(line[i].equals(line[k])) {
								valid = false;
								break outerloop;
							}
							if(line[i].length() == line[k].length()) {
								char[] charArray1 = line[i].toCharArray();
								char[] charArray2 = line[k].toCharArray();
								Arrays.sort(charArray1);
								Arrays.sort(charArray2);
								if(Arrays.equals(charArray1, charArray2)) {
									valid = false;
									break outerloop;
								}
							}
						}
					}
				}
			}
			if(valid) {
				validpassphrases++;
			}
			valid = true;
		}
		scan.close();
		System.out.println("lines: "+lines);
		System.out.println("Number of valid passphrases: "+validpassphrases);
	}
}
