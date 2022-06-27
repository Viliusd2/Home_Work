package org.example.eshop.api.file;

import lombok.RequiredArgsConstructor;
import org.example.eshop.api.product.dto.ProductsResponse;
import org.example.eshop.product.dto.ProductDto;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
public class FileController {

    private final FileService fileService;

    @PostMapping("/api/file/upload")
    public FileResponse saveFile(@RequestParam MultipartFile file, ProductDto productDto) {
        return fileService.saveFile(file, productDto);
    }
    @GetMapping("/api/file/download")
    public ResponseEntity<Resource> getFileByFileName(@RequestParam String fileName) {
        return ResponseEntity.ok()
                .headers(getContentDispositionHttpHeader(fileName))
                .contentType(fileService.getFileMediaTypeByFileName(fileName))
                .body(fileService.getFile(fileName));
    }

    private HttpHeaders getContentDispositionHttpHeader(String fileName) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=\"" + fileName + "\"");

        return headers;
    }

}
