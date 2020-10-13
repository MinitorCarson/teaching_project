package factory;

import factory.hero.Camille;
import factory.hero.Diana;
import factory.hero.Irelia;

public class HeroFactory {
    public static ISkill getHero(String name){
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
        return iSkill;
    }
}
