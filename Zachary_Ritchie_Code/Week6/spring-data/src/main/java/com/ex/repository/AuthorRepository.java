package com.ex.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ex.beans.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer>
{
	public List<Author> findByFirstName(String firstname);
	
	@Query("SELCT a FROM Author a WHERE LOWER(a.bio) like LOWER(%bio%")
	public List<Author> findByBio(@Param("bio") String keywords);
	
}
