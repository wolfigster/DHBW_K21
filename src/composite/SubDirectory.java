package composite;

public class SubDirectory extends Directory {

    public SubDirectory(String directoryName) {
        super(directoryName);
    }

    @Override
    public void printDirectoryInformation() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("directory name: ").append(directoryName).append("\n");
        stringBuilder.append("superior directory: ").append(getSuperiorDirectory());

        for(Directory directory : directories) {
            directory.printDirectoryInformation();
        }
        System.out.println(stringBuilder.toString());
    }
}
