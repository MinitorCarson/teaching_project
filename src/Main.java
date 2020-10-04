import awkward.hero.Diana;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        String name = Main.getPlayerInput();
        if(name.equals("Diana")){
            Diana diana = new Diana();
            diana.r();
        }
    }

    private static String getPlayerInput(){
        System.out.println("请输入英雄名字：");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
