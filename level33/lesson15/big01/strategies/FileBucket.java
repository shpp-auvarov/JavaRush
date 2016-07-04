package com.javarush.test.level33.lesson15.big01.strategies;

import com.javarush.test.level33.lesson15.big01.ExceptionHandler;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileBucket {
    private Path path;

    public FileBucket() {
        try {
            this.path = Files.createTempFile(null, null);
        } catch (Exception e) {
            ExceptionHandler.log(e);
        }
        path.toFile().deleteOnExit();
    }

    public long getFileSize() {
        return path.toFile().length();
    }

    public void putEntry(Entry entry) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(new File(path.toString())))) {
            out.writeObject(entry);
        } catch (Exception e) {
            ExceptionHandler.log(e);
        }
    }

    public Entry getEntry() {
        if (getFileSize() == 0) {
            return null;
        }
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(path.toString()))) {
            return (Entry) input.readObject();
        } catch (Exception e) {
            ExceptionHandler.log(e);
            return null;
        }
    }

    public void remove() {
        new File(path.toString()).delete();
    }
}