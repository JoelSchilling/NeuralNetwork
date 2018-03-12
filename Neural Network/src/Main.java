import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Network network = new Network(3, 1, 2, 100, 0.1);
		
		File testData = new File("CharacterInputs.txt");
		
		try {
			Scanner count = new Scanner(testData);
			Scanner inputs = new Scanner(testData);
			
			int numInputs = 0;
			
			for(int i = 0; i < 10000; i++) {
				
				count.nextLine();
				numInputs++;
				
			}
			
			double[][] inputArray = new double[numInputs][1];
			double[][] expected = new double[numInputs][2];
			
			for(int i = 0; i < numInputs; i++) {
				char character = inputs.nextLine().charAt(0);
				
				double[] name = {0.0, 0.0};
				
				if((int)character < 97) {
					
					name[1] = 1.0;
					
					if(character == 'A' || character == 'E' || character == 'I' || character == 'O' || character == 'U') {
						name[0] = 1.0;
					}
				}
				else {
					if(character == 'a' || character == 'e' || character == 'i' || character == 'o' || character == 'u') {
						name[0] = 1.0;
					}
				}
				
				inputArray[i][0] = (double)((int)character);
				expected[i] = name;
				
			}
			
			outputExpected(expected);
			
			count.close();
			inputs.close();
			
			/*for(int i = 0; i < 26; i++) {
				System.out.println(inputArray[i][0] + ": " + expected[i][0] + " " + expected[i][1]);
			}*/
			network.train(inputArray, expected);
			
			network.test('a');
			network.test('j');
			network.test('P');
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void outputExpected(double[][] expected) {
		// TODO Auto-generated method stub
		try {
			PrintWriter writer = new PrintWriter("Output.txt");
			
			for(int i = 0; i < expected.length; i++) {
				for(int j = 0; j < expected[i].length; j++) {
					writer.println(expected[i]);
				}
				writer.flush();
			}
			writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}