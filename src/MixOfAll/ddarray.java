package MixOfAll;

public class ddarray {
    public static void main (String[]args){
        int [][] b = new int[3][4];  // initialization of 2d MixOfAll.array
        int[][] fuf  = { //to initialise an matrix type MixOfAll.array
                {1,2,3},  //0
                {3,4,5},   //1
                {7,5,8}     //2 similarly goes with column 0 ,1,2
        };
        System.out.println(fuf[2][2]); //to print based on index and column
        for ( int i=0;i<fuf.length;i++) {               // for row
            for(int j=0;j<fuf.length;j++){              // for column chutiye int lagana maat bhul j ke pahle
                System.out.print(fuf[i][j] + "   "); // don't use ln nahi nichr niche print ho jayega aur jitna space dogai inverted ke beech utna gap banega numbers ke beech
            }
            System.out.println();  // don't forget comma
        }
        char [][] arr = new char[3][3];  // for character type matrix
        arr [0] [0] = 'a';  //have a look at indexing again
        arr [0] [1] = 'a';
        arr [0] [2] = 'a';
        arr [1] [0] ='t';
        arr [1] [1] ='x';
        arr [1] [2] ='a';
        arr [2] [0] ='p';
        arr [2] [1] ='r';
        arr [2] [2] ='s';
        for( char i =0;i<arr.length;i++){
            for( char j =0;j<arr.length;j++){
                System.out.print(arr[i][j]+" "); //ln nahi lagana hai aur space dena hai
            }
            System.out.println(); // ln lagana hai print ke sath aur jake matrix ke row aur column firse check karke aao
        }
    }

}
// yaha pe 3x3 tha to sahi se hua agar yahi i chota aur j bada hota to us condition ko JAGGED ARRAY kahte us condition me we use
//j<arr[i].length  mtlb j utni baar chalega jitni i ki length hai