package com.library.automation.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.library.automation.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer>{

}
