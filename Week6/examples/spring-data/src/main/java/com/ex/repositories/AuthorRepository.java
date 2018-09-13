package com.ex.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ex.beans.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer>{
	
	//firstname isnt unique. make a list just in case
	public List<Author> findByFirstName(String firstName);
	
	@Transactional(propagation=Propagation.REQUIRES_NEW, isolation=Isolation.SERIALIZABLE)
	@Query("SELECT a FROM Author a WHERE LOWER(a.bio) like LOWER(%:bio%)")
	public List<Author> findByBio(@Param("bio") String keywords);
}
