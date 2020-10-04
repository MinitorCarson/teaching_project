import awkward.hero.Camille;
import awkward.hero.Diana;
import awkward.hero.Irelia;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        String name = Main.getPlayerInput();
        switch (name){
            case "Diana":
                Diana diana = new Diana();
                diana.r();
                break;
            case "Irelia":
                System.out.println("ddd");
                Irelia irelia = new Irelia();
                irelia.r();
                break;
            case "Camille":
                Camille camille = new Camille();
                camille.r();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + name);
        }

    }

    private static String getPlayerInput(){
        System.out.println("请输入英雄名字：");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
