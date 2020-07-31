package br.com.hangman.core;

public class InvalidCharacterException extends Exception{

    public InvalidCharacterException(String mensage){
        super(mensage);
    }
}
