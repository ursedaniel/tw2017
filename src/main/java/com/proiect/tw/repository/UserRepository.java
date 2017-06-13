package com.proiect.tw.repository;

import com.proiect.tw.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.jws.soap.SOAPBinding;


/**
 * Created by JACK on 6/13/2017.
 */
public interface UserRepository extends JpaRepository<User, Integer> {

    User findById(String id);
}
