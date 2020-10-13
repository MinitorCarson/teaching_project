import factory.ISkill;
import factory.HeroFactory;

import java.util.Scanner;
    /*
    本代码是v4版本
    重点理论：
    本次版本的目的是将new实例化对象给统一起来
    (0)新增一个新的英雄(修改)，但是代码不用改动，就说明这一段代码是稳定的，
    (1)使用了简单的工厂模式，这时候就很稳定了，将new实例化给统一到一个地方去.
    (2)以后添加新英雄不用修改main函数了。此时可以说“main函数实现了OCP，变得稳定”，但是HeroFactory却没有实现OCP，还是不稳定
    (3)上面的这句话，其实是保证了main的稳定性但是引入了新的HeroFactory的不稳定，其实是合理的。
    因为代码总是不稳定的，但是我们可以将不稳定的代码封装隔离到一个地方去，这就是稳定的相对性。
    (4)软件中的“变化“带来了不稳定
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
