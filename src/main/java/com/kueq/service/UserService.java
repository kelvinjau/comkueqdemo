package com.kueq.service;


        import java.util.List;
        import java.util.Optional;

        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

        import com.kueq.exceptions.RecordNotFoundException;
        import com.kueq.model.User;
        import com.kueq.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository repository;


    public List<User> getAllUsers()
    {
        List<User> userList = (List<User>) repository.findAll();
            return userList;
    }



//
//    public Iterable<User> getAllUsers()
//    {
//        Iterable<User> UserList = repository.findAll();
//        //return new ArrayList<User>();
//        return  UserList;
//    }




    public User getUserById(Long id) throws RecordNotFoundException
    {
        Optional<User>   user = repository.findById(id);

        if(user.isPresent()) {
            return user.get();
        } else {
            throw new RecordNotFoundException("No User record exist for given id");
        }
    }

    public User createOrUpdateUser(User user) throws RecordNotFoundException
    {
        Optional<User> userr = repository.findById(user.getId()); //user is pasred from url, cast it as optional

        if(userr.isPresent())
        {
            User userEntity = userr.get();
            userEntity.setEmail(user.getEmail());
            userEntity.setId(user.getId());
            userEntity.setName(user.getName());

            userEntity = repository.save(userEntity);

            return userEntity;
        } else {
            user = repository.save(user);

            return user;
        }
    }

    public void deleteUserById(Long id) throws RecordNotFoundException
    {
        Optional<User> user = repository.findById(id);

        if(user.isPresent())
        {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No User record exist for id : "+id);
        }
    }
}