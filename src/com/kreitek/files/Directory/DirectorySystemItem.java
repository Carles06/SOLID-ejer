package com.kreitek.files.Directory;



import java.util.List;

public  interface DirectorySystemItem {
    String getName();
    void setName(String name);
    DirectorySystemItem getParent();
    void setParent(DirectorySystemItem directory);
    String getFullPath();
    List<DirectorySystemItem> listFiles();
    void addFile(DirectorySystemItem file);
    void removeFile(DirectorySystemItem file);
}
