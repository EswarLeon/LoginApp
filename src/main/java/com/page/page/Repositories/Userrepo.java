package com.page.page.Repositories;

import com.page.page.models.Userdetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Userrepo extends JpaRepository<Userdetails, Integer> {
    Optional<Userdetails> findByemail(String email);
}