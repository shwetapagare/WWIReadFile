package com.wwi.readfile;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

public class FileReader {
    public static void main(String[] args) {

        String filePath = new File("").getAbsolutePath();
    	String filename = filePath + "/src/com/wwi/readfile/file.txt";
    	System.out.println(filename);
        BufferedReader br;

        if (doesFileExists(filename)) {
        	try {
        		br = new BufferedReader(new java.io.FileReader(filename));
                String line = br.readLine();
                while (line != null) {
                	String[] dashedSplit = line.split("-");
                    System.out.println(dashedSplit[0].trim());
                    String[] commaSplit = dashedSplit[1].split(",");
                    for (String meaning : commaSplit) {
                        System.out.println(meaning);
                    }
                    line = br.readLine();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("File does not exist");
        }
    }

    static boolean doesFileExists(String filePathString) {
        File f = new File(filePathString);
        return (f.exists() && !f.isDirectory());
    }
}