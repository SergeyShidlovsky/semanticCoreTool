package com.company;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TextScanner {

    private FileInputStream fis;
    private byte[] buffer;
    private String path;


    public String readFile(){
        try {
            path = "D:/Documents Sergey/source.txt";
            fis = new FileInputStream(path);
            buffer = new byte[fis.available()];

            fis.read(buffer, 0, buffer.length);
            String content = new String( buffer);
            fis.close();
            return content;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "This string will not be returned";
    }

}
