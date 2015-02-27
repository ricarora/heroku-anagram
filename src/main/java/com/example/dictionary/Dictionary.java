package com.example.dictionary;

import java.util.Set;

/**
 * Created by Richa on 2/27/15.
 */
public interface Dictionary {
    public boolean isWord(String s);
    public Set<String> getAllWords();
}
