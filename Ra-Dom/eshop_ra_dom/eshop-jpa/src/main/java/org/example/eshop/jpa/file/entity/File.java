package org.example.eshop.jpa.file.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.example.eshop.jpa.product.entity.Product;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class File {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private Long id;

    @Builder.Default
    private UUID fileId = UUID.randomUUID();

    @Column(length = 100)
    private String fileName;

    private String fileExtension;

    private String mediaType;

    private long size;

    public String getUniqFileName() {
        return fileId.toString() + "." + fileExtension;
    }
    public UUID getId() {
        return fileId;
    }
}