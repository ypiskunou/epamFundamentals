package com.epam.practice5.TextFile;

import java.io.File;

public class Directory {

    private String path;

    public Directory(String path) {
        this.path = path;
        File dir = new File(path);
        if(!dir.exists() || dir.isFile())
            dir.mkdir();
    }

    public static Directory makeDirectory(String path){
        return new Directory(path);
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
