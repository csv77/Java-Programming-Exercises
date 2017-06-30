package exercise_19_11;

import testcomplex.Complex;

public class Exercise_19_11 {

    public static void main(String[] args) {
        Complex[][] m1 = generateComplexMatrix(3, 3);
        Complex[][] m2 = generateComplexMatrix(3, 3);
        
        ComplexMatrix m = new ComplexMatrix();
        ComplexMatrix.printResult(m1, m2, m.addMatrix(m1, m2), '+');
        System.out.println();
        ComplexMatrix.printResult(m1, m2, m.multiplyMatrix(m1, m2), '*');
    }
    
    public static Complex[][] generateComplexMatrix(int size1, int size2) {
        Complex[][] m = new Complex[size1][size2];
        for(int i = 0; i < size1; i++) {
            for(int j = 0; j < size2; j++) {
                m[i][j] = new Complex(i + 1, j + 1);
            }
        }
        return m;
    }
}
