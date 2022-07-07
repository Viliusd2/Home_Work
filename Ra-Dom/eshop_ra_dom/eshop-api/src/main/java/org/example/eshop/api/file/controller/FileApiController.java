package org.example.eshop.api.file.controller;
import lombok.RequiredArgsConstructor;
import org.example.eshop.api.file.dto.FileResponse;
import org.example.eshop.api.file.FileService;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
public class FileApiController implements FileApiSPec{

    private final FileService fileService;

    public FileResponse saveFile(@RequestParam MultipartFile file) {
        return fileService.saveFile(file);
    }

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
