package org.example.lab7.compulsory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SharedMemory {
    private final List<Token> tokens;


    public SharedMemory(int n) {
        //adauga si da shuffle la tokeni
        tokens = new ArrayList<>();
        for (int i = 1; i < n * n * n; i++)
            tokens.add(new Token(i));
        Collections.shuffle(tokens);
    }


    public synchronized List<Token> extractToken(int howMany) {
        //extrage cate n tokeni din SharedMemory
        List<Token> extracted = new ArrayList<>();
        for (int i = 0; i < howMany; i++) {
            if (tokens.isEmpty()) {
                break;
            }
            extracted.add(tokens.remove(0));
        }
        return extracted;
    }
}
