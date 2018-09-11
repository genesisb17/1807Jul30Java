package com.iantimothyjohnson.notes.week7.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iantimothyjohnson.notes.week7.model.IceCream;

@Repository
public interface IceCreamRepository extends JpaRepository<IceCream, String> {
}
