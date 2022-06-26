package org.example.eshop.jpa.file.repository;

import org.example.eshop.jpa.file.entity.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<File, Long> {
}
