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

        while(!this.isWinner() &&  !this.isLoser()){
            UI.println("RODADA: " + (round + 1));
            UI.newLine();

            word.printSecretWord();
            UI.newLine();
            UI.newLine();

            this.inputChar();
            round += 1;
        }

    }

    private void createPlayer(){
        while(true){
            try{
                String name;
                UI.print("Digite o nome do jogador: ");
                name = UI.readString();

                this.player = new Player(name);

            }catch (InvalidCharacterException e){
                UI.println("[ERRO]: " + e.getMessage());
                continue;
            }

            break;
        }

    }

    private void createWord(){
        this.word = new Word();
    }

    private void inputChar(){
        char c;

        while(true){
            UI.print("Digite um caracter: ");
            c = UI.readChar();
            UI.newLine();

            try {
                if(!word.inputChar(c)){
                    UI.println("O caracter não pertence a palavra");
                    this.attempts -= 1;
                    UI.println("Você ainda tem " + this.attempts + " tentativas");
                }
            } catch (InvalidCharacterException e ){
                UI.println("[ERRO]: " + e.getMessage());
                continue;
            }

            break;
        }

    }

    private boolean isWinner(){
        if(this.word.isOriginalWord()){
            UI.newLine();
            UI.println("Parabéns! O jogador " + this.player.getName() + " acertou a palavra!");
            UI.print("A palavra secreta é ");
            word.printOriginalWord();

            return true;
        }

        return  false;
    }

    private boolean isLoser(){
        if(this.attempts == 0){
            UI.newLine();
            UI.println("Você perdeu! Tente novamente");
            UI.print("A palavra secreta é ");
            word.printOriginalWord();

            return true;
        }

        return false;
    }

}
