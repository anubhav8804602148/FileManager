package com.shaan31.fmi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shaan31.fmi.entities.FileData;

@Repository
public interface FileDataRepository extends JpaRepository<FileData, Long> {

}
