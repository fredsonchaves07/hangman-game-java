package br.com.hangman.core;

public class Player {

    private String name;

    public Player(String name) throws  InvalidCharacterException{
        if(name.isEmpty()){
            throw new InvalidCharacterException("O nome do jogador está vazio");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
