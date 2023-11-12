package com.poly.truongnvph29176.service.impl;

import com.poly.truongnvph29176.service.UploadService;
import jakarta.servlet.ServletContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Service
@RequiredArgsConstructor
public class UploadServiceImpl implements UploadService {
    private final ServletContext servletContext;

    @Override
    public File save(MultipartFile file, String folder) {
        File dir = new File(servletContext.getRealPath("/assets/" + folder));
        if(!dir.exists()) {
            dir.mkdirs();
        }
        String s = System.currentTimeMillis() + file.getOriginalFilename();
        String name = Integer.toHexString(s.hashCode()) + s.substring(s.lastIndexOf("."));
        try {
            File savedFile = new File(dir, name);
            file.transferTo(savedFile);
            System.out.println(savedFile.getAbsolutePath());
            return savedFile;
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
