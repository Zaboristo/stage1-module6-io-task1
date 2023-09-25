package com.epam.mjc.io;

import java.io.*;


public class FileReader {


    public Profile getDataFromFile(File file) {
        Profile person = new Profile();
        StringBuilder bld = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new java.io.FileReader(file));
            String line;
            String text = "";
            while ((line = reader.readLine()) != null) {
                text += line + "\n";
            }
            reader.close();
            int i = 0;
            while (i < text.length()) {
                String key = "";
                String value = "";
                while (text.charAt(i) != ':') {
                    bld.append(text.charAt(i));
                    i++;
                }
                key = bld.toString();
                bld.setLength(0);
                i++;
                i++;
                while (text.charAt(i) != '\n') {
                    bld.append(text.charAt(i));
                    value += text.charAt(i);
                    i++;
                }
                value = bld.toString();
                bld.setLength(0);
                i++;
                switch (key) {
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
                    default:
                        break;
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return person;
    }
}


