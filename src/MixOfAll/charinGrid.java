/*ps  is to remove spaces from string
then find sqrt of length
find floor value of it fl
ceil value of it cl
then declare a grid of rl cl size
fill each character in that grid and return. */

package MixOfAll;

import java.util.Arrays;

public class charinGrid {
    public static void main(String[]args){
        String s="This is Aditya";
        String []arr=s.split(" ");//space hatane ke liye taki length sahi nikle
        char[]temp=String.join("",arr).toCharArray();//split karo fir join karke ak kar do
        int n=temp.length;
        double sq=Math.sqrt(n);
        int fl=(int)Math.floor(sq);
        int cl=(int)Math.ceil(sq);
        char[][]grid=new char[fl][cl];
        int idx=0;
        for(int i=0;i<fl;i++){
            for(int j=0;j<cl;j++){
                grid[i][j]=temp[idx++];
            }
        }
        for(int i=0;i<fl;i++){
            for(int j=0;j<cl;j++){
                System.out.print(grid[i][j]+" ");
            }
            System.out.println();
        }

    }
}
