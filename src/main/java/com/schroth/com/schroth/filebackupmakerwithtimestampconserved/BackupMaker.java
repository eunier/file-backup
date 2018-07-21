package com.schroth.com.schroth.filebackupmakerwithtimestampconserved;

import org.apache.commons.io.FileUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.ArrayList;
import java.util.List;

class BackupMaker {
    void makeBackup() {
        try {
            copyFileWithTimeStampPreservation(getBackupSourceFiles(), getBackupDestFiles());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private List<File> getBackupSourceFiles() throws Exception {
        List<File> backupSourceFiles = new ArrayList<>();
        addSourceFileContentToList(SourceDir.BACKUP_SOURCE_DIR.toString(), backupSourceFiles);
        return backupSourceFiles;
    }

    private List<File> getBackupDestFiles() throws Exception {
        List<File> backupDesFiles = new ArrayList<>();
        addSourceFileContentToList(SourceDir.BACKUP_DEST_DIR.toString(), backupDesFiles);
        return backupDesFiles;
    }

    private void addSourceFileContentToList(String souceFilePath, List<File> list) throws Exception {
        File sourceFile = new File(souceFilePath);
        BufferedReader reader = new BufferedReader(new FileReader(sourceFile));

        String line;
        while ((line = reader.readLine()) != null) {
            list.add(new File(line));
        }
    }

    private void copyFileWithTimeStampPreservation(List<File> source, List<File> dest) throws Exception {
        if (source.size() == dest.size()) {
            for (int i = 0; i < source.size(); i++) {
                System.out.println((i + 1) + "_CopingFile: " + source.get(i).getAbsolutePath() + System.lineSeparator() +
                        "           to : " + dest.get(i).getAbsolutePath());
                FileUtils.copyFile(source.get(i), dest.get(i), true);
                copyFileTimeStamp(source.get(i), dest.get(i));
            }
        }
        else {
            System.out.println("Error, list must be the same size.");
        }
    }

    private void copyFileTimeStamp(File sourceFileTimeStamp, File destFileTimeStamp) throws Exception {
        BasicFileAttributes sourceAttr = Files.readAttributes(sourceFileTimeStamp.toPath(), BasicFileAttributes.class);
        BasicFileAttributeView destAttr = Files.getFileAttributeView(destFileTimeStamp.toPath(),
                BasicFileAttributeView.class);

        FileTime lastModifiedTime = FileTime.fromMillis(sourceAttr.lastModifiedTime().toMillis());
        FileTime lastAccessTime = FileTime.fromMillis(sourceAttr.lastAccessTime().toMillis());
        FileTime createTime = FileTime.fromMillis(sourceAttr.creationTime().toMillis());

        destAttr.setTimes(lastModifiedTime,lastAccessTime,createTime);
    }
}

