import abstraction.ISkill;
import abstraction.hero.Camille;
import abstraction.hero.Diana;
import abstraction.hero.Irelia;

import java.util.Scanner;
    /*
    本代码是v3版本
    重点理论：
    (1)单纯的interface可以统一方法的调用，但是不能统一对象的实例化。（英雄联盟V3版本就可以体现）
    (2)面向对象常做的两件事情：实例化对象、调用方法(实现业务逻辑)
    (3)统一方法有意义吗？有的，因为实际项目可能有非常多的对象、方法，我统一后就只有一条代码，多简洁。
    (4)只有一段代码中没有new出现，才能保持相对稳定，逐步实现OCP原则(实质意思是，一段代码如果要保持稳定，就不应该负责对象的实例化)
    (5)上面的这句话，实质上并不是要消除对象实例化，而是要把这个对象实例化的过程转移到其他代码片段。
    下一个版本需要解决“统一对象的实例化”的问题。
    * */

public class Main {

    //下面是v2版本

//    public static void main(String[] args){
//        String name = Main.getPlayerInput();
//        switch (name){                        //这个switch-case功能不单纯，因为它做了两件事：实例化对象+实现业务逻辑
//            case "Diana":
//                Diana diana = new Diana();    //实例化对象
//                diana.r();                    //调用方法(实现业务逻辑)
//                break;
//            case "Irelia":
//                System.out.println("ddd");
//                Irelia irelia = new Irelia();
//                irelia.r();
//                break;
//            case "Camille":
//                Camille camille = new Camille();
//                camille.r();
//                break;
//            default:
//                throw new IllegalStateException("Unexpected value: " + name);
//        }
//
//    }

    //下面代码是版本v3
    public static void main(String[] args) {
        String name = Main.getPlayerInput();
        ISkill iSkill;
        switch(name){                   //这个switch-case功能很单纯，只做一件事：实例化对象(单一职责)。因此以后可以提取为一个方法
            case "Diana":
                iSkill = new Diana();   //依然需要对象逐个new，说明"单纯的interface不能统一对象的实例化"
                break;
            case "Irelia":
                iSkill = new Irelia();
                break;
            case "Camille":
                iSkill = new Camille();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + name);
        }
        iSkill.r();     //体现出"interface可以统一方法的调用"
    }
    private static String getPlayerInput(){
        System.out.println("请输入英雄名字：");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
