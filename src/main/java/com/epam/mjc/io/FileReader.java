package com.epam.mjc.io;

import com.sun.source.tree.WhileLoopTree;

import java.awt.datatransfer.FlavorEvent;
import java.io.*;


public class FileReader {


    public Profile getDataFromFile(File file) {
        Profile person = new Profile();
        try {
            BufferedReader reader = new BufferedReader(new java.io.FileReader(file));
            String line;
            String text = "";
            while ((line = reader.readLine()) != null){
                text += line;
                text += "\n";
            }
            reader.close();
            int i = 0;
            while (i<text.length()){
                String key = "";
                String value = "";
                while (text.charAt(i) != ':') {
                    key += text.charAt(i);
                    i++;
                }
                i++;
                i++;
                while (text.charAt(i) != '\n'){
                    value += text.charAt(i);
                    i++;
                }
                i++;
                switch (key) {
                    default: break;
                    case "Name":
                        person.setName(value);
                        break;
                    case "Age":
                        person.setAge(Integer.valueOf(value));
                        break;
                    case "Email":
                        person.setEmail(value);
                        break;
                    case "Phone":
                        person.setPhone(Long.valueOf(value));
                        break;
                };
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return person;
    }

}


