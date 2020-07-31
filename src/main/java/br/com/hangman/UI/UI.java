package br.com.hangman.UI;

import br.com.hangman.core.Player;

import java.util.Scanner;

public class UI {

    public static void gameTitle(){
        println("------------------");
        println("   HANGMAN GAME!  ");
        println("------------------");
    }

    public static void welcomePlayer(Player player){
        println("Seja bem vindo! " + player.getName());
        newLine();
    }

    public static void println(String text){
        System.out.println(text);
    }

    public static void print(String text){
        System.out.print(text);
    }

    public static void newLine(){
        System.out.println("");
    }

    public static String readString(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static char readChar(){
        Scanner scanner = new Scanner(System.in);
        return scanner.next().charAt(0);
    }
}
