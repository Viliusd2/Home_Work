package org.example.eshop.api.file.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Builder
@Getter
public class FileResponse {

    private String originalFileName;


}
