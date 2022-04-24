package com.kreitek.utils;

import com.kreitek.files.Directory.Directory;
import com.kreitek.files.Directory.DirectorySystemItem;
import com.kreitek.files.File;
import com.kreitek.files.FileSystemItem;


public class FileSystemBuilder {
    private final DirectorySystemItem root;
    private DirectorySystemItem currentDirectory;

    public static FileSystemBuilder getBuilder() {
        return new FileSystemBuilder();
    }

    public FileSystemBuilder() {
        root = new Directory(null, "");
        currentDirectory = root;
    }

    public FileSystemBuilder addFile(String name, int size) {
        FileSystemItem file = new File((FileSystemItem) currentDirectory, name);
        file.open();
        file.write(new byte[size]);
        file.close();
        currentDirectory.addFile((DirectorySystemItem) file);
        return this;
    }

    public FileSystemBuilder addDirectory(String name) {
        FileSystemItem directory = (FileSystemItem) new Directory(currentDirectory, name);
        currentDirectory.addFile((DirectorySystemItem) directory);
        currentDirectory = (DirectorySystemItem) directory;
        return this;
    }

    public FileSystemBuilder upOneDirectory() {
        if (currentDirectory.getParent() != null) {
            currentDirectory = currentDirectory.getParent();
        }
        return this;
    }

    public DirectorySystemItem build() {
        return root;
    }
}
