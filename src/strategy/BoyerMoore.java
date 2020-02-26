package strategy;

import composite.FileDirectory;

public class BoyerMoore implements ISearchAlgorithm {
    @Override
    public boolean search(VirusSignature virusSignature, FileDirectory fileDirectory) {
        return false;
    }
}
