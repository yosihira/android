package com.example.demo11;
import org.springframework.data.jpa.repository.JpaRepository;

public interface chatRepository extends JpaRepository<Chat,Integer> {
    
}
