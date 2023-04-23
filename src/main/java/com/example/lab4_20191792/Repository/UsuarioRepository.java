package com.example.lab4_20191792.Repository;

import com.example.lab4_20191792.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<User,Integer>{



    @Query(value = "SELECT COUNT(*) FROM user WHERE  (email = ?1 and password =?2)", nativeQuery = true)
    int findByEmailAndPassword(String email, String password);


}


