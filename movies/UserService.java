package dev.farhan.movieist.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public User findUserByUserName(String userName){ return  repository.findUserByUserName(userName);}

    public void save(User user) {
        repository.insert(user);
    }


}
