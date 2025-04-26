package com.LLD.DesignPattern.CompositePattern.ProblemStatement1;

import java.util.List;

public class Directory {

    String directoryName;
    List<Object> objectList;

    public Directory(String directoryName, List<Object> objectList) {
        this.directoryName = directoryName;
        this.objectList = objectList;
    }

    public void add(Object object){
        objectList.add(object);
    }

    public void ls(){
        System.out.println("Directory Name: " + directoryName);
        for(Object obj : objectList){
            if(obj instanceof  File){
                ((File) obj).ls();
            } else if (obj instanceof Directory) {
                ((Directory) obj).ls();
            }
        }
    }
}
