package OOp;

abstract class animal{
    String name;
    animal(String name){
        this.name=name;
        System.out.println("parent class const");
    }
    abstract void speek();
}
class dog extends animal{
    dog(String name){
        super(name);
        System.out.println("child class const");
    }
    @Override
    void speek(){
        System.out.println("bark");
    }
}
public class ConstInAbs {
    public static void main(String[] args) {
        animal a=new dog("dog");
        a.speek();
    }
}
