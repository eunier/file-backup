package com.schroth.filerenamerwithtimestampconserved;

public enum SourceDir {
    SOURCE_DIR              ("FileToRename\\source.txt"),
    NEW_NAMES_DIR           ("FileToRename\\newNames.txt"),
    TEST_SOURCE_DIR         ("FileToRename\\testSource.txt"),
    TEST_NEW_NAMES_DIR      ("FileToRename\\testNewNames.txt");

    private String sourceDir;

    SourceDir(String sourceDir) {
        this.sourceDir = sourceDir;
    }

    public String toString() {
        return sourceDir;
    }
}
