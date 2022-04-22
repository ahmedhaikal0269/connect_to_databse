package com.example.connect_to_databse.Repositories;

import com.example.connect_to_databse.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Transactional
    @Query(
            value = "SELECT username " +
                    "FROM user_info " +
                    "WHERE username = ?1", nativeQuery = true
    )
    List<String> getMail(
            String username
    );

}
