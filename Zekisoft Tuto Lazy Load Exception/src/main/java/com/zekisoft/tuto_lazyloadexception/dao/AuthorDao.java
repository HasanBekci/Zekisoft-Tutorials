package com.zekisoft.tuto_lazyloadexception.dao;


import com.zekisoft.tuto_lazyloadexception.model.Author;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorDao extends JpaRepository<Author, Long> {

}
