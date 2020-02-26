import composite.Directory;
import composite.FileDirectory;
import composite.MainDirectory;
import composite.SubDirectory;
import strategy.Context;
import strategy.KnuthMorrisPratt;
import strategy.VirusSignature;

public class Application {

    public static void main(String... args) {
        Directory mainDir = new MainDirectory("mainDir");
        mainDir.addIdTag("mainDir");

        Directory subDir01 = new SubDirectory("subDir01");
        subDir01.addIdTag("subDir01");
        Directory subDir02 = new SubDirectory("subDir02");
        subDir02.addIdTag("subDir02");

        Directory file01 = new FileDirectory("file01");
        file01.addIdTag("file01");
        Directory file02 = new FileDirectory("file02");
        file02.addIdTag("file02");
        Directory file03 = new FileDirectory("file03");
        file03.addIdTag("file03");

        Directory file04 = new FileDirectory("file04");
        file04.addIdTag("file04");
        Directory file05 = new FileDirectory("file05");
        file05.addIdTag("file05");

        subDir01.addDirectory(file01);
        subDir01.addDirectory(file02);
        subDir01.addDirectory(file03);
        subDir02.addDirectory(file04);
        subDir02.addDirectory(file05);
        mainDir.addDirectory(subDir01);
        mainDir.addDirectory(subDir02);

        mainDir.printStructure();
        System.out.println();
        mainDir.printDirectoryInformation();

        Context context = new Context(new KnuthMorrisPratt());
        System.out.println("Virus Signature found: " + context.executeSearchAlgorithm(VirusSignature.VC2PO, (FileDirectory) file02));
    }

}
