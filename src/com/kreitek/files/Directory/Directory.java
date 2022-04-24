package com.kreitek.files.Directory;



import java.util.List;

public class Directory extends DirectorySystemItemBase implements DirectorySystemItem {

    private static final String NO_ES_VALIDO_PARA_DIRECTORIOS = "No es válido para directorios";
    private final List<DirectorySystemItem> files;

    public Directory(DirectorySystemItem files, String s) {
        super();
        this.files = (List<DirectorySystemItem>) files;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void setName(String name) {

    }

    @Override
    public DirectorySystemItem getParent() {
        return null;
    }

    @Override
    public void setParent(DirectorySystemItem directory) {

    }

    @Override
    public String getFullPath() {
        return null;
    }

    @Override
    public List<DirectorySystemItem> listFiles() {
        return files;
    }

    @Override
    public void addFile(DirectorySystemItem file) {
        if (!files.contains(file)) {
            files.add(file);
            file.setParent(this);
        }
    }

    @Override
    public void removeFile(DirectorySystemItem file) {
        files.remove(file);
    }




}

