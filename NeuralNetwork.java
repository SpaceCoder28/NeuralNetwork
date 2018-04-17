class NeuralNetwork {
  int input_nodes, hidden_nodes, output_nodes;
  Matrix weights_ih, weights_ho;
  Matrix bias_h, bias_o;
  
  NeuralNetwork(int input_nodes, int hidden_nodes, int output_nodes) {
    this.input_nodes = input_nodes;
    this.hidden_nodes = hidden_nodes;
    this.output_nodes = output_nodes;
    
    this.weights_ih = new Matrix(this.hidden_nodes, this.input_nodes);
    this.weights_ho = new Matrix(this.output_nodes, this.hidden_nodes);
    this.weights_ih.randomise();
    this.weights_ho.randomise();
    
    this.bias_h = new Matrix(this.hidden_nodes, 1);
    this.bias_o = new Matrix(this.output_nodes, 1);
    bias_h.randomise();
    bias_o.randomise();
  }
  
  Double[] feedforward(Double[] input_array) {
    Matrix inputs = Matrix.fromArray(input_array);
    
    Matrix hidden = weights_ih.multiply(inputs);
    hidden.add(this.bias_h);
    
    //activation function
    hidden = sigmoid(hidden);
    
    //Lot of Matrix Math
    Matrix outputs = weights_ho.multiply(hidden);
    outputs.add(bias_o);
    outputs = sigmoid(outputs);
    
    return Matrix.toArray(outputs);
  }
  
  
  Matrix sigmoid(Matrix m) {
    for(int i=0; i<m.rows; i++) {
      for(int j=0; j<m.columns; j++) {
        m.data[i][j] = 1 / (1 + Math.exp(m.data[i][j]));
      }
    }
    return m;
  }
}
