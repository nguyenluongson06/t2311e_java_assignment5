package com.model;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;

public class FileHandler {
    public static String FILE_NOT_FOUND = "File not found",
            WRITE_FAILED = "File write failed",
            READ_FAILED = "File read failed";

    public String readFile(String path) throws Exception {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))){
            StringBuilder result = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line).append("\n");
            }
            return result.toString();
        } catch (FileNotFoundException e) {
            throw new Exception(FILE_NOT_FOUND);
        } catch (IOException e) {
            throw new Exception(READ_FAILED);
        }
    }

    public Boolean writeFile(String path, String content) throws Exception {
        try (FileWriter writer = new FileWriter(path)) {
            writer.write(content);
            writer.flush();
            writer.close();
            System.out.println("File written successfully");
            return true;
        }
        catch(IOException e){
            throw new Exception(WRITE_FAILED);
        }
    }
}
