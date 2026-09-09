package MixOfAll;

// program to MixOfAll.add and convert to binary we can change operation and calculate value
public class intobinary {
    public static void main(String[] args) {
        int a = 100;
        int b = 90;
      /*  int c = a+b;
        System.out.println(Integer.toBinaryString(c));
    }
}*/  // and operation similarly we can use all
        System.out.println("100&90:" + (a & b));
        System.out.println("Binary:" + Integer.toBinaryString(a & b));
    }
}