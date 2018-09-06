package com.iantimothyjohnson.notes.week6.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iantimothyjohnson.notes.week6.beans.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {
	public List<Author> findByFirstName(String firstName);
	
	// Here, we can write some custom JPQL.
	@Query("SELECT a FROM Author a WHERE LOWER(a.bio) LIKE LOWER(%:bio%)")
	public List<Author> findByBio(@Param("bio") String keywords);
}
