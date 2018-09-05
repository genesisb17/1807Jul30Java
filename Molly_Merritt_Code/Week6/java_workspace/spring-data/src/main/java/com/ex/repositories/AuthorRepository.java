package com.ex.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ex.beans.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {
	
	// firstname isn't unique. make a list just in case
	// return a list whenever something isn't unique
	public List<Author> findByFirstName(String firstName);
	
	@Query("SELECT a FROM Author a WHERE LOWER(a.bio) like LOWER(%:bio%)")
	public List<Author> findByBio(@Param("bio") String keywords);

}
