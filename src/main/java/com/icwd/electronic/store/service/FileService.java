package com.icwd.electronic.store.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
@Service
public interface FileService {


    public String uploadFile(MultipartFile file , String path) throws IOException;

    public InputStream getResource(String path ,String name) throws FileNotFoundException;
}
