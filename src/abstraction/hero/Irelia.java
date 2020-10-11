package abstraction.hero;

import abstraction.ISkill;

public class Irelia implements ISkill {
    public void q(){
        System.out.println("Irelia Q");
    }

    public void w(){
        System.out.println("Irelia W");
    }

    public void e(){
        System.out.println("Irelia E");
    }

    public void r(){
        System.out.println("Irelia R");
    }
}
