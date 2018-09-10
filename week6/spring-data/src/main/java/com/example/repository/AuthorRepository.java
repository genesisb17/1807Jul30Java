package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.beans.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {
	public List<Author> findByFirstName(String firstname);
	
	@Query("SELECT A FROM AUTHOR A WHERE LOWER(A.BIO) LIKE LOWER(%:BIO%)")
	public List<Author> findByBio(@Param("bio") String keyword);
		
}


