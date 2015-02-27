package com.example.anagramsolver;

import com.example.dictionary.Dictionary;
import com.example.dictionary.EnglishDictionary;

import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by Richa on 2/27/15.
 */
public class AnagramSolver {

    private Dictionary dictionary;
    private Map<String, Set<String>> signatureMap;



    public AnagramSolver(Dictionary dictionary) {
        this.dictionary = dictionary;
        signatureMap = new HashMap<String, Set<String>>();
        for (String text: dictionary.getAllWords()) {
            String wordSignature = signature(text);
            if (!signatureMap.containsKey(wordSignature)) {
                signatureMap.put(wordSignature, new HashSet<String>());
            }
            signatureMap.get(wordSignature).add(text);
        }
    }

    public Set<String> getAnagrams(String s) {
        String signature = signature(s);
        if (signatureMap.containsKey(signature)) {
            return signatureMap.get(signature);
        }
        return new HashSet<String>();
    }

    private static String signature(String s) {
        char[] characters = s.toLowerCase().toCharArray();
        Arrays.sort(characters);
        return new String(characters);
    }

//    public static void main(String[] args) throws FileNotFoundException {
//        Dictionary dictionary = new EnglishDictionary();
//        AnagramSolver solver = new AnagramSolver(dictionary);
//        Set<String> myAnagrams = solver.getAnagrams("trap");
//        for (String s: myAnagrams) {
//            System.out.println(s);
//        }
//    }
}
