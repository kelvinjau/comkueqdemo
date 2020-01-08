package com.kueq.repository;

import com.kueq.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserRepository extends CrudRepository<User, Integer> {

    // custom query to search to blog post by title or content

  //  List<User> findByName(String Name);

    User findByName(String Name);
    Optional<User> findById(long id);

    User deleteById(Long id);

}

//@Repository
//public interface {repository name} extends JpaRepository<{Entity class}, {Data Type of Primary key field}>{
//        we can define our queries here
//        }