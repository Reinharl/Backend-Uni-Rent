package com.unirent.repository;

import com.unirent.entity.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
public interface ChatRepository extends JpaRepository<Chat, Long> {

}
