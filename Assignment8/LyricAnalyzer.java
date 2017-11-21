package com.kevinshi721.Assignment8;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class LyricAnalyzer {

    public static void main(String[] args) throws IOException {
        File f = new File("/Users/kevinshi721/IdeaProjects/INFO5100/src/com/kevinshi721/Assignment8/Question2_test2.txt");
        LyricAnalyzer la = new LyricAnalyzer();
        la.read(f);
        System.out.println("unique words: " + la.count());
        System.out.println("most frequenty word: " + la.mostFrequentWord());
        System.out.println("\n" + "*********************************" + "\n");
        la.displayWords();
        File fn = new File("/Users/kevinshi721/IdeaProjects/INFO5100/src/com/kevinshi721/Assignment8/LyricsNew.txt");
        la.writeLyrics(fn);
    }

    private HashMap<String, ArrayList<Integer>> map;

    public LyricAnalyzer() {
        this.map = new HashMap<>();
    }

    public void read(File file) throws IOException {
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        int pst = 1;
        String line;
        while (true) {
            line = br.readLine();
            if (line == null) {
                break;
            }
            String[] words = line.toUpperCase().split(" ");
            for (int i = 0; i < words.length; ++i) {
                if (i == words.length - 1) {
                    add(words[i], -pst);
                } else {
                    add(words[i], pst);
                }
                pst++;
            }
        }
        br.close();
        fr.close();
    }

    private void add(String lyricWord, int wordPosition) {
        if (!map.containsKey(lyricWord)) {
            ArrayList<Integer> wp = new ArrayList<>();
            wp.add(wordPosition);
            map.put(lyricWord, wp);
        } else {
            map.get(lyricWord).add(wordPosition);
        }
    }

    public void displayWords() {
        String[] words = new String[map.size()];
        map.keySet().toArray(words);
        Arrays.sort(words);
        for (String s : words) {
            StringBuilder sb = new StringBuilder();
            sb.append(s).append(": ");
            String list = map.get(s).toString();
            sb.append(list.substring(1, list.length() - 1));
            System.out.println(sb.toString());
        }
    }

    public int count() {
        return map.size();
    }

    public String mostFrequentWord() {
        int count = 0;
        String str = "";
        for (String s : map.keySet()) {
            if (map.get(s).size() > count) {
                count = map.get(s).size();
                str = s;
            }
        }
        return str;
    }

    public void writeLyrics(File file) throws IOException {
        int n = 0;
        for (ArrayList<Integer> arr : map.values()) {
            n += arr.size();
        }
        String[] words = new String[n + 1];
        Arrays.fill(words, "");
        for (String s : map.keySet()) {
            for (Integer i : map.get(s)) {
                if (i < 0) {
                    words[-i] = s.toUpperCase() + " " + "\n";
                } else {
                    words[i] = s.toUpperCase() + " ";
                }
            }
        }
        FileWriter fw = new FileWriter(file);
        PrintWriter pw = new PrintWriter(fw);
        for (int i = 1; i < words.length; ++i) {
            pw.print(words[i]);
        }
        pw.close();
        fw.close();
    }
}
