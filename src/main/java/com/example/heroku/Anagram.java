package com.example.heroku;

/**
 * Created by Richa on 2/26/15.
 */

import com.example.anagramsolver.AnagramSolver;
import com.example.dictionary.*;



import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.FileNotFoundException;

import java.util.Set;

@Path("anagram/{word}")
public class Anagram {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getAnagram(@PathParam("word") String word) throws FileNotFoundException {
        Dictionary dictionary = new EnglishDictionary();
        AnagramSolver solver = new AnagramSolver(dictionary);
        Set<String> myAnagrams = solver.getAnagrams(word);
//        for (String s: myAnagrams) {
//            System.out.println(s);
//        }
        return myAnagrams.toString();

    }

}
