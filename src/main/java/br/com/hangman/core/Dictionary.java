package br.com.hangman.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Dictionary {
    private static final String FILE_NAME = "dictionary.txt";
    private List<String>listWords = new ArrayList<>();
    private static Dictionary instanceDictionary;

    private Dictionary(){
        this.loadDictionary();
    }

    public static Dictionary getInstanceDictionary() {
        if(instanceDictionary == null){
            instanceDictionary = new Dictionary();
        }

        return instanceDictionary;
    }

    private void loadDictionary(){
        try(Scanner sc = new Scanner(getClass().getResourceAsStream("/" + FILE_NAME))){
            while (sc.hasNextLine()){
                String word = sc.nextLine().trim().toUpperCase();
                listWords.add(word);
            }
        }
    }

    public List<String> getListWords(){
        return this.listWords;
    }
}
