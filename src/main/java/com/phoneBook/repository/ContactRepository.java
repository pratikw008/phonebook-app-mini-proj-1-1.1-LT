package com.phoneBook.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.phoneBook.model.ContactEntity;


public interface ContactRepository extends JpaRepository<ContactEntity, Serializable> {

}
