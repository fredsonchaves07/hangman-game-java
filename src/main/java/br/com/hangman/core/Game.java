package br.com.hangman.core;

import br.com.hangman.UI.UI;

public class Game {
    private Player player;
    private Word word;
    private int attempts = 6;

    public void play(){
        int round = 0;

        UI.gameTitle();
        UI.newLine();

        this.createPlayer();
        this.createWord();
        UI.welcomePlayer(player);

        while(true){
            UI.println("RODADA: " + round);
            UI.newLine();

            word.printSecretWord();
            UI.newLine();
            UI.newLine();

            this.inputChar();
        }

    }

    private void createPlayer(){
        String name;
        UI.print("Digite o nome do jogador: ");
        name = UI.readString();

        this.player = new Player(name);
    }

    private void createWord(){
        this.word = new Word();
    }

    private void inputChar(){
        char c;

        while(true){
            UI.print("Digite um caracter: ");
            c = UI.readChar();

            try {
                if(!word.inputChar(c)){
                    UI.println("O caracter não pertence a palavra");
                    this.attempts -= 1;
                    UI.println("Você ainda tem " + this.attempts + " tentativas");
                } else {
                    UI.println("Parabéns!! Você acertou");
                }
            } catch (InvalidCharacterException e ){
                UI.println("[ERRO]: " + e.getMessage());
                continue;
            }

            break;
        }

    }
}
