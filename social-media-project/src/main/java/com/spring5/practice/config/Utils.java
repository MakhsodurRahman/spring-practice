package com.spring5.practice.config;

import com.spring5.practice.entity.Attachment;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Utils {


    public static Attachment saveFile(MultipartFile file, String path) {
        Path rootLocation = Paths.get(Properties.WRITE_PATH + path);

        if (!file.isEmpty()) {
            String fileName = file.getOriginalFilename();
            Path destinationFile = rootLocation.resolve(fileName);

            if (!destinationFile.toFile().exists()) {
                destinationFile.toFile().mkdirs();
            }
            try (InputStream inputStream = file.getInputStream()) {
                Files.copy(inputStream, destinationFile, StandardCopyOption.REPLACE_EXISTING);

                Attachment attachment = new Attachment();
                attachment.setAttachmentName(fileName);
                attachment.setAttachmentPath(path + fileName);
                attachment.setAttachmentType(file.getContentType());

                return attachment;
            }catch (IOException e) {
                e.printStackTrace();
            }
        }



        return null;

    }
}
