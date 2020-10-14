import reflect.ISkill;
import reflect.HeroFactory;

import java.util.Scanner;
    /*
    本代码是v5版本
    使用了反射机制reflect，将switch也消除
    现在到了v5版本了，使用了interface+factory+reflect，实现了OCP
    但是还是没有用上IOC和DI
    * */

public class Main {

    /*下面代码是版本v2*/
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

    /*下面代码是版本v3*/
//    public static void main(String[] args) {
//        String name = Main.getPlayerInput();
//        ISkill iSkill;
//        switch(name){                   //这个switch-case功能很单纯，只做一件事：实例化对象(单一职责)。因此以后可以提取为一个方法
//            case "Diana":
//                iSkill = new Diana();   //依然需要对象逐个new，说明"单纯的interface不能统一对象的实例化"
//                break;
//            case "Irelia":
//                iSkill = new Irelia();
//                break;
//            case "Camille":
//                iSkill = new Camille();
//                break;
//            default:
//                throw new IllegalStateException("Unexpected value: " + name);
//        }
//        iSkill.r();     //体现出"interface可以统一方法的调用"
//    }

    /*下面代码是版本v4*/
    public static void main(String[] args) throws Exception{
        String name = Main.getPlayerInput();
        ISkill iSkill = HeroFactory.getHero(name);
        iSkill.r();
    }

    private static String getPlayerInput(){
        System.out.println("请输入英雄名字：");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
