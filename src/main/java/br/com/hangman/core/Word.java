package br.com.hangman.core;

import br.com.hangman.UI.UI;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Word {

    public static char SECRET_CHAR = '_';
    private String originalWord;
    private String secretWord;
    private Dictionary dictionary = Dictionary.getInstanceDictionary();

    public Word(){

        this.choiceWord();
        this.createSecretWord();
    }

    private void choiceWord(){
        int pos;
        List<String>listWord;

        listWord = dictionary.getListWords();

        Random random = new Random();
        pos = random.nextInt(listWord.size());

        this.originalWord = listWord.get(pos);
    }


    private void createSecretWord(){
        char[] chars = this.originalWord.toCharArray();

        for(int i = 0; i < this.originalWord.length(); i ++){
            chars[i] = SECRET_CHAR;
        }

        this.secretWord = new String(chars);
    }

    public void printSecretWord(){
        for(int i = 0; i < this.secretWord.length(); i++){
            UI.print(secretWord.charAt(i) + " ");
        }
    }

    public void printOriginalWord(){
        UI.println(this.originalWord);
    }

    public boolean inputChar(char c) throws InvalidCharacterException{
        if(Character.isDigit(c)){
            throw new InvalidCharacterException("Não é permitido digitar números");
        }
        if(this.secretWord.contains(String.valueOf(c))){
            throw new InvalidCharacterException("O caracter já foi digitado!");
        }

        if(this.containsChar(c)){
            char[] chars = this.secretWord.toCharArray();

            for(int i = 0; i < this.originalWord.length(); i ++){
                if((String.valueOf(this.originalWord.charAt(i)).equals(String.valueOf(c).toUpperCase()))){
                    chars[i] = c;
                }
            }

            this.secretWord = new String(chars).toUpperCase();

            return true;
        }

        return false;
    }

    private boolean containsChar(char c){
        return this.originalWord.contains(String.valueOf(c).toUpperCase());
    }

    public boolean isOriginalWord(){
        return this.secretWord.equals(this.originalWord);
    }
}
