package com.example.anagramsolver;

import com.example.dictionary.EnglishDictionary;
import org.junit.Ignore;
import org.mockito.Mock;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.when;

/**
 * Created by Richa on 2/27/15.
 */
public class AnagramSolverTest {

    private AnagramSolver anagramSolver;

    @Mock
    private EnglishDictionary englishDictionary;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        anagramSolver = new AnagramSolver(englishDictionary);
//        anagramSolver = new AnagramSolver.getInstance(englishDictionary); // this will be applied once singleton is applied

    }

    @Test
    @Ignore

    public void test_GetAnagrams_AnagramsExist() {
        Set<String> miniDictionary = new HashSet<String>();
        miniDictionary.add("cat");
        when(englishDictionary.getAllWords()).thenReturn(miniDictionary);
        Set<String> actual = anagramSolver.getAnagrams("act");
        assertEquals(1, actual.size());
        assertTrue(actual.contains("cat"));
        assertFalse(actual.contains("whatever"));
    }
}
