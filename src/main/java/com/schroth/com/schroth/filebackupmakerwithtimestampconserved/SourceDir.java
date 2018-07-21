package com.schroth.com.schroth.filebackupmakerwithtimestampconserved;

public enum SourceDir {
    BACKUP_SOURCE_DIR       ("BackupSourceTestFiles\\backupSource.txt"),
    BACKUP_DEST_DIR         ("BackupSourceTestFiles\\backupDest.txt");

    private String sourceDir;

    SourceDir(String sourceDir) {
        this.sourceDir = sourceDir;
    }

    public String toString() {
        return sourceDir;
    }
}
