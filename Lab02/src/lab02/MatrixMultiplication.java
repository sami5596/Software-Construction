package lab02;

//Matrix Multiplication class
public class MatrixMultiplication {
    //Variables
    int R1, C1, R2, C2;
    int first[][];
    int second[][];
    int result[][];
    
    //Constructor
    public MatrixMultiplication(int r1, int c1, int r2, int c2, int f[][], int s[][]){
        this.R1 = r1;
        this.C1 = c1;        
        this.R2 = r2;        
        this.C2 = c2;
        
        first = new int[R1][C1];
        first = f;        
        second = new int[R2][C2];        
        second = s;        
    }
    
    //Iterative Method
    public int[][] iterative(){
        //defining the dimensions of result array
        result= new int[R1][C2];
        if ( C1 != R2 ){
            return null;
        }
        else{
            //declaring variables to be used in iteration
            int i, j, k;
            //stores sum of the product of one row and one column from matrices
            int sum = 0;
            
            //Multiplying the matrices and storing result in result
            for ( i = 0 ; i < R1 ; i++ ){
                for ( j = 0 ; j < C2 ; j++ ){   
                    for ( k = 0 ; k < R2 ; k++ ){
                        sum = sum + first[i][k]*second[k][j];
                    } 
                    result[i][j] = sum;
                    sum = 0;
                }
            }
            //return final array
            return result;            
        }
    }
    
    
    
    
}





