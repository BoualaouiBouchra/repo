package com.autisme.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.autisme.modal.*;

public interface DocumentDao extends JpaRepository<Document, Long> {

}
