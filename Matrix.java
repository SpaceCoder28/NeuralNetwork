class Matrix {
  
  int rows, columns;
  Double[][] data;
  
  Matrix(int rows, int columns) {
    this.rows = rows;
    this.columns = columns;
    this.data = new Double[rows][columns];
    
    //to avoid NullPointerException
    for(int i=0; i<rows; i++) {
      for(int j=0; j<columns; j++) {
        this.data[i][j] = 0.0;
      }
    }
  }
  
  
  //to assign random value from (-1,1) to each element
  void randomise() {
    for(int i=0; i<this.rows; i++) {
      for(int j=0; j<this.columns; j++) {
        this.data[i][j] = Math.random() * 2 - 1;
      }
    }
  }
  
  //to add given matrix to this matrix
  void add(Matrix a) {
    if(a.rows != this. rows || a.columns != this.columns) {
      System.out.println("Given matrix cannot be added.");
    } 
    else {
      for(int i=0; i<this.rows; i++) {
        for(int j=0; j<this.columns; j++) {
          this.data[i][j] += a.data[i][j];
        }
      }
    }
  }
  
  
  //transpose of a matrix 
  static Matrix transpose(Matrix t) {
    Matrix transp = new Matrix(t.columns, t.rows);
    for(int i=0; i<t.rows; i++) {
      for(int j=0; j<t.columns; j++) {
        transp.data[i][j] = t.data[j][i];
      }
    }
    return transp;
  }
  
  //scalar multiplication of matrix
  void multiply(Double n) {
    for(int i=0; i<this.rows; i++) {
        for(int j=0; j<this.columns; j++) {
          this.data[i][j] *= n;
        }
      }
  }
  void multiply(int n) {
    for(int i=0; i<this.rows; i++) {
      for(int j=0; j<this.columns; j++) {
        this.data[i][j] *= n;
      }
    }
  }
  
  
  //Matrix multiplication
  Matrix multiply(Matrix n) {
    if(this.columns != n.rows) {
      System.out.println("The matrix product does not exist");
      return null;
    } else {
      Matrix product = new Matrix(this.rows, n.columns);
      
      Matrix B = Matrix.transpose(n);
      
      for(int i=0; i<product.rows; i++) {
        for(int j=0; j<product.columns; j++) {
          Double[] row = this.data[i];
          Double[] column = B.data[j];
          for(int a=0; a<row.length; a++) {
            product.data[i][j] += row[a]*column[a];
          }
        }
      }
      return product;
    }
  }
  
  //prints the elements of the matrix
  void print() {
    for(int i=0; i<this.rows; i++) {
      for(int j=0; j<this.columns; j++) {
        System.out.print(this.data[i][j] + "\t");
      }
      System.out.println();
    }
  }
}
