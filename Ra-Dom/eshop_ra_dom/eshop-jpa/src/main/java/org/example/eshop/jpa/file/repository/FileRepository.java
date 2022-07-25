package org.example.eshop.jpa.file.repository;

import org.example.eshop.jpa.file.entity.File;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FileRepository extends JpaRepository<File, Long> {


    Optional<File> findByFileName(String filename);
}
