package OOp;

interface Mouse{
    void click();
}
class wiremouse implements Mouse{

    @Override
    public void click() {
        System.out.println("click from wired");
    }
}
class wireless implements Mouse{
    @Override
    public void click() {
        System.out.println("click from wireless");
    }
}
class laptop{
    private final Mouse mouse;
    public laptop(Mouse mouse) {
        this.mouse = mouse;
    }
    public void usemouse(){
        mouse.click();
    }
}
public class Dependency {
    public static void main(String[] args) {
        laptop l1=new laptop(new wiremouse());
        l1.usemouse();

    }
}
