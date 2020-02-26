package strategy;

import composite.FileDirectory;

public interface ISearchAlgorithm {
    boolean search(VirusSignature virusSignature, FileDirectory fileDirectory);
}
