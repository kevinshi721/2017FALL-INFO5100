package com.kevinshi721.Assignment8;

import java.io.IOException;
import java.util.Scanner;

public class FileCounter {

    private int characterCount, wordCount, lineCount;

    public FileCounter() {
        characterCount = 0;
        wordCount = 0;
        lineCount = 0;
    }

    public void read(Scanner in) throws IOException {
        while (in.hasNextLine()){
            lineCount++;
            String line = in.nextLine();
            wordCount += line.split(" ").length;
            for (String ch : line.split(" ")){
                characterCount += ch.length();
            }
        }
    }

    public int getLineCount() {
        return lineCount;
    }

    public int getCharacterCount() {
        return characterCount;
    }

    public int getWordCount() {
        return wordCount;
    }
}
