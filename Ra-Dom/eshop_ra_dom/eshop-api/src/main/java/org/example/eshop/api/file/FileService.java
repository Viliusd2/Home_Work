package org.example.eshop.api.file;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Objects;

@Service
@Slf4j
public class FileService {

    private final Path fileLocation = Path.of("./pictures").toAbsolutePath().normalize();

    public void saveFile(MultipartFile file) {
        createDirectory();
        try {
            Path filePathWithFileName = fileLocation.resolve(Objects.requireNonNull(file.getOriginalFilename()));

            Files.copy(file.getInputStream(), filePathWithFileName, StandardCopyOption.REPLACE_EXISTING);

        }catch (IOException e) {
        log.error("Cannot create File");
        e.printStackTrace();
    }



    }

    private void createDirectory() {
        try {
            if (!Files.exists(fileLocation)) {
                Files.createDirectory(fileLocation);
            }
        } catch (IOException e) {
            log.error("Cannot create directory");
            e.printStackTrace();
        }
    }

}
