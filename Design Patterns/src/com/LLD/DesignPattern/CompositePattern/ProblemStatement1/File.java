package com.LLD.DesignPattern.CompositePattern.ProblemStatement1;

public class File {

    String fileName;
    public File(String name){
        this.fileName = name;
    }

    public void ls(){
        System.out.println("file name " + fileName);
    }
}
