package com.autisme.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.autisme.modal.*;

public interface FilesDao  extends JpaRepository<Files, Long>{
	   List<Files> findByType(String type);
}
