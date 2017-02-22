
package lab02;


import org.junit.Test;
import static org.junit.Assert.*;

public class MultiplyTest {
    //first test
    @Test
    public void ValidMultilpicationTest() {
        int a[][] = {{2,2,3,5,6},{5,5,1,2,3},{9,7,4,2,3},{2,6,5,8,3},{3,2,3,4,5}};
        int b[][] = {{1,3,6,8,5},{2,4,5,3,6},{7,5,1,8,2},{9,8,6,2,1},{2,4,5,3,6}};
        int result[][];
        MatrixMultiplication m = new MatrixMultiplication(5,5,5,5,a,b);
        
        result = m.iterative();
        //check if matrices are valid for multiplication
        if (result == null){
            fail("The matrices cannot be multiplied as Number of columns of M1 is not equal to Number of rows of M2");                   
        }
    }
    //second test
    @Test
    public void MultiplcationTest() {
        int a[][] = {{2,3,5,6,9},{7,5,1,2,3},{5,7,4,2,3},{4,2,5,8,3},{1,2,3,4,5}};
        int b[][] = {{1,3,6,8,5},{2,4,5,3,6},{7,5,1,8,2},{9,8,6,2,1},{2,4,5,3,6}};
        int result[][];
        MatrixMultiplication m = new MatrixMultiplication(5,5,5,5,a,b);
        
        result = m.iterative();
        int ans[][] = {{115,127,113,104,98},{48,74,95,92,87},{71,91,96,106,95},{121,121,102,103,68},{72,78,68,61,57}};
        //check if answers are equal
        for (int i = 0; i< 5; i++){
            for(int j = 0; j < 5; j++){
                if (result[i][j] != ans[i][j]){
                    fail("Test failed");
                }
            }
        }
    }

}
