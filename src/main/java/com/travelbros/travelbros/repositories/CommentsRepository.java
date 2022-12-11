package com.travelbros.travelbros.repositories;

import com.travelbros.travelbros.models.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentsRepository extends JpaRepository<Comments, Long> {
    Comments findById(long id);
}
