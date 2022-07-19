package com.example.springdboperations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userDao;

    @Transactional
    public User storeUser(User user){ // user has info from the user -> no id
        return userDao.save(user); // adds id and processes user into an entity stored in the table
    }
    // return all the user entities
    public List<User> getUsers(){
        return userDao.findAll(); // returns all the Users in the list
    }

    public User getUser(int id){
        return userDao.findById(id).orElse(null);
    }

    public User deleteUser(int id){
        User usr = getUser(id);
        if (usr != null){
            userDao.deleteById(id);
            return usr;
        }else
            return null;
    }
}
