public class Node {

	private double[] weights;
	private double bias;
	
	private double total;
	private double numCalc;
	
	
	int direction = 1; 
	double lastError = 1.0;
	
	public Node(int numInputs) {
		
		weights = new double[numInputs];
		
		for(int i = 0; i < numInputs; i++) {
			weights[i] = Math.random();
		}
		bias = Math.random();
		
		total = 0;
		
	}
	
	public void evaluate(double input, int numInput) {
		
		total += (weights[numInput] * input) + bias;
		numCalc++;
		
	}
	
	public double output() {
		double calc = total / numCalc;
		
		total = 0.0;
		numCalc = 0.0;
		
		return Math.tanh(calc);
	}

	public void adjust(double currentError, double learningRate) {
		if(lastError < currentError)
			direction = -direction;
		for(int i = 0; i < weights.length; i++) {
			weights[i] = weights[i] - (learningRate * direction * (currentError/weights[i]));
		}
	}

	public void printNode() {
		
		for(int i = 0; i < weights.length; i++) {
			System.out.println("Weight " + (i + 1) + ": " + weights[i]);
		}
		System.out.println("Bias: " + bias);
		
	}
	
}
