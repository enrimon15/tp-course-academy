package it.aesys.courses.springboot.utils;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.Base64;

@Service
public class FileUtil {

    public String upload(MultipartFile file) throws IOException {
        String encodedString = Base64.getEncoder().encodeToString(file.getBytes());
        return encodedString;
    }

    public byte[] download(String encoded){
        byte[] decodedBytes = Base64.getDecoder().decode(encoded);
        return decodedBytes;
    }
}
