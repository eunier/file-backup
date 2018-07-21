package com.schroth.com.schroth.filebackupmakerwithtimestampconserved;

public enum SourceDir {
    SOURCE_DIR              ("FileToRename\\source.txt"),
    NEW_NAMES_DIR           ("FileToRename\\newNames.txt"),
    TEST_SOURCE_DIR         ("FileToRename\\testSource.txt"),
    TEST_NEW_NAMES_DIR      ("FileToRename\\testNewNames.txt"),
    BACKUP_SOUCE_DIR        ("FileToRename\\backupSource.txt"),
    BACKUP_DEST_DIR         ("FileToRename\\backupDest.txt");

    private String sourceDir;

    SourceDir(String sourceDir) {
        this.sourceDir = sourceDir;
    }

    public String toString() {
        return sourceDir;
    }
}
