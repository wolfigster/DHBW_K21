package strategy;

import composite.FileDirectory;

public class Context {
    private ISearchAlgorithm searchAlgorithm;

    public Context(ISearchAlgorithm searchAlgorithm) {
        this.searchAlgorithm = searchAlgorithm;
    }

    public boolean executeSearchAlgorithm(VirusSignature virusSignature, FileDirectory fileDirectory) {
        return searchAlgorithm.search(virusSignature, fileDirectory);
    }
}
