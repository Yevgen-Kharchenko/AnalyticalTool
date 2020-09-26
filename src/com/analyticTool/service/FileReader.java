package com.analyticTool.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class FileReader {

    String[] readMyFile(String path) {
        File file = new File(path);

        Scanner scanner;

        {
            try {
                scanner = new Scanner(file);
                String line = scanner.nextLine();
                int count = Integer.parseInt(line);

                String[] query = new String[count];
                try {
                    for (int i = 0; i < count; i++) {

                        String data = scanner.nextLine();
                        query[i] = data;
                    }
                }catch (NoSuchElementException e){
                    System.out.println("The number of tapes in the file does not match the stated");
                    return new String[0];
                }

                scanner.close();
                return query;

            } catch (FileNotFoundException e) {
                System.out.println("File not found");
            }
        }
        return new String[0];
    }

}
