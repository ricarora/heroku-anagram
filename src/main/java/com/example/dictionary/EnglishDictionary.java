package com.example.dictionary;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Richa on 2/27/15.
 */
public class EnglishDictionary implements Dictionary {

    private Set<String> words;

    public EnglishDictionary() throws FileNotFoundException {


        words = new HashSet<String>();

        try {
            BufferedReader in = new BufferedReader(new FileReader("words"));
            String text;
            while ((text = in.readLine()) != null) {
                words.add(text);
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public boolean isWord(String s) {
        return words.contains(s);
    }

    @Override
    public Set<String> getAllWords() {
        return words;
    }

    public static void main(String[] args) {

    }
}
