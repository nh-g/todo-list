package com.giang;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileService {

    private static List<Task> tasks = new ArrayList<>();

    /**
     * This method will save the data of Tasks from ArrayList to data file
     * @param fileName a string specifying the full path and extension of data file,
     * @return true if the writing operation was successful, otherwise false
     */
    public boolean saveToFile(String fileName) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(tasks);

            objectOutputStream.close();
            fileOutputStream.close();
            return true;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * This method will read the data file from disk which will contain the data of previously saved tasks
     * @param fileName a string specifying the full path and extension of data file
     * @return true if the reading operation was successful, otherwise false
     */
    public boolean readFromFile(String fileName){
        try{
            if(!Files.isReadable(Paths.get(fileName))){
                System.out.println("The file,i.e., "+fileName+" does not exists");
                return false;
            }

            FileInputStream fileInputStream=new FileInputStream(fileName);
            ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);

            tasks=(ArrayList<Task>)objectInputStream.readObject();

            objectInputStream.close();
            fileInputStream.close();
            return true;

        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}
