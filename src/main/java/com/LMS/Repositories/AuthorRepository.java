package com.LMS.Repositories;

import com.LMS.Entites.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository  extends JpaRepository<Author , Integer> {
}
