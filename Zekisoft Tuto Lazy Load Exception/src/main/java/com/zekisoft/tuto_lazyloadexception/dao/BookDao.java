package com.zekisoft.tuto_lazyloadexception.dao;


import com.zekisoft.tuto_lazyloadexception.model.Book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookDao extends JpaRepository<Book, Long> {
	
}
