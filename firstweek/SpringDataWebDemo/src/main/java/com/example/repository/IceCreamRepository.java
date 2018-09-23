package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.IceCream;

@Repository
public interface IceCreamRepository extends JpaRepository<IceCream, String> {

}
