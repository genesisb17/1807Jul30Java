package com.revature.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.model.IceCream;

@Repository
public interface IceCreamRepository extends JpaRepository<IceCream,String> {

	List<IceCream> findByFlavor(String flavor);
}
