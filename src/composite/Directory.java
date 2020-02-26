package composite;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public abstract class Directory {
    protected int indentDepth = 0;
    protected String directoryName;
    protected Directory parentDirectory;
    protected List<Directory> directories;
    protected List<String> idTags;

    public Directory(String directoryName) {
        this.directoryName = directoryName;
        this.directories = new ArrayList<>();
        this.idTags = new ArrayList<>();
    }

    public abstract void printDirectoryInformation();

    public void addDirectory(Directory directory) {
        directories.add(directory);
    }

    public final boolean isComposite() {
        return !directories.isEmpty();
    }

    public final ListIterator<Directory> listDirectories() {
        return directories.listIterator();
    }

    protected String indent(int depth) {
        StringBuilder stringBuilder = new StringBuilder();
        do {
            stringBuilder.append("+ ");
        } while (depth-- > 0);

        return stringBuilder.toString();
    }

    public final void printStructure() {
        System.out.println(indent(indentDepth) + directoryName + (isComposite() ? " (node)" : " (leaf)"));
        for(Directory directory : directories) {
            directory.indentDepth = indentDepth + 1;
            directory.printStructure();
        }
    }

    public String getSuperiorDirectory() {
        String parent;

        if(parentDirectory == null) {
            parent = "--- top level directory";
        } else {
            parent = this.parentDirectory.directoryName;
        }
        return parent;
    }

    public void addIdTag(String idTag) {
        idTags.add(idTag);
    }

    public void printTags() {
        System.out.print("[" + idTags + "]");
        if(parentDirectory != null) parentDirectory.printTags();
    }
}
