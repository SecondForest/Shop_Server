package com.second.shop.service;

import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

@Service
@Log
public class FileService {

  public String uploadFile(String uploadPath, String originalFileName, byte[] fileData) throws Exception {
    UUID uuid = UUID.randomUUID();
    String extension = originalFileName.substring(originalFileName.lastIndexOf("."));
    String savedFileName = uuid.toString() + extension;
    String fileUploadFullUrl = uploadPath + "/" + savedFileName;
    FileOutputStream fos = new FileOutputStream(fileUploadFullUrl);
    fos.write(fileData);
    fos.close();
    return savedFileName;
  }

  public void deleteFile(String filePath) throws Exception{
    File deleteFile = new File(filePath);

    if (deleteFile.exists()) {
      log.info("파일을 삭제하였습니다.");
    } else {
      log.info("파일일 존재하지 않습니다.");
    }
  }

}
