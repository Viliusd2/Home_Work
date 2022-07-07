package org.example.eshop.api.file.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.example.eshop.api.file.dto.FileResponse;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("/api")
@Api(tags = "File Management")
public interface FileApiSPec {


    @PostMapping("/file/upload")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Upload File",
            httpMethod = "POST",
            notes = "Saves a file")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully saved file"),
    })
     FileResponse saveFile(@RequestParam MultipartFile file);



    @GetMapping("/file/download")
    @ApiOperation(value = "Download File",
            httpMethod = "GET",
            notes = "Retrieve file by file name")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved file"),
    })
     ResponseEntity<Resource> getFileByFileName(@RequestParam String fileName);
}
