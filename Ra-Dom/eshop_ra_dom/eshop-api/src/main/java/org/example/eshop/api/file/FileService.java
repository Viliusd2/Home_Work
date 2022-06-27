package org.example.eshop.api.file;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.eshop.jpa.file.entity.File;
import org.example.eshop.jpa.file.repository.FileRepository;
import org.example.eshop.jpa.product.entity.Product;
import org.example.eshop.jpa.product.repository.ProductRepository;
import org.example.eshop.product.dto.ProductDto;
import org.example.eshop.product.service.ProductService;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.UUID;


@Service
@Slf4j
@RequiredArgsConstructor
public class FileService {

    private final Path fileLocation = Path.of("./pictures").toAbsolutePath().normalize();
    private final FileRepository fileRepository;
    private final ProductService productService;

    public FileResponse saveFile(MultipartFile file, ProductDto productDto) {
        createDirectory();
        try {

            String[] splitFile = file.getOriginalFilename().split("\\.");

            File savedFileInDb = fileRepository.save(
                    File.builder()
                            .fileName(splitFile[0])
                            .fileExtension(splitFile[1])
                            .size(file.getSize())
                            .mediaType(file.getContentType())
                            .product(productService.getProductByUUID(productDto))
                            .build());

            Path filePathWithFileName = fileLocation.resolve(savedFileInDb.getUniqFileName());

            Files.copy(file.getInputStream(), filePathWithFileName, StandardCopyOption.REPLACE_EXISTING);
            return FileResponse.builder()
                    .originalFileName(savedFileInDb.getUniqFileName())
                    .fileId(savedFileInDb.getId())
                    .build();

        } catch (IOException e) {
            log.error("Cannot create File");
            e.printStackTrace();
        }
        return null;
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

    public Resource getFile(String fileName) {
        try {
            InputStream inputStream = Files.newInputStream(fileLocation.resolve(fileName));

            return new InputStreamResource(inputStream);
        } catch (IOException e) {
            log.error("Cannot get/create file by file name", e);
            e.printStackTrace();
        }

        return null;
    }

    public MediaType getFileMediaTypeByFileName(String fileName) {
        return MediaType.valueOf(URLConnection.guessContentTypeFromName(fileName));
    }

}
