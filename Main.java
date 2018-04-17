class Main {
  public static void main(String[] args) {
    NeuralNetwork nn = new NeuralNetwork(2, 2, 1);
    
    Double[] input = {1.0, 0.0};
    
    Double[] guess = nn.feedforward(input);
    
    Print.print(guess);
  }
}
