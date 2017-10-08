package br.com.loja.infrastructure.utils;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class FileReader {

    public String name(String fileName) {

        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());
        String data = null;
        try {
            data = FileUtils.readFileToString(file, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}
