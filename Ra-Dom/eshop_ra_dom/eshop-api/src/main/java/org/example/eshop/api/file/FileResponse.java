package org.example.eshop.api.file;

import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Builder
@Getter
public class FileResponse {

    private String originalFileName;
    private UUID fileId;

}
