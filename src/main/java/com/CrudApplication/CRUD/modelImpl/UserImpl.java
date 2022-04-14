package com.CrudApplication.CRUD.modelImpl;


import com.CrudApplication.CRUD.model.User;
import com.CrudApplication.CRUD.repositary.UserRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserImpl {

    @Autowired
    public UserRepositary userRepositary;

    public User saveuser(User user)
    {
        return userRepositary.save(user);
    }

    public Optional<User> getuser (Integer id)
    {
       Optional<User> user =  userRepositary.findById(id);
       if(user!=null)
           return  user;
       return null;
    }

    public void updateuser(User user)
    {
        Optional<User> user1 = userRepositary.findById(user.getPhone());
        if(user1!=null) {
            userRepositary.deleteById(user.getPhone());
            userRepositary.save(user);
        }

    }
    public boolean deleteuser(Integer number)
    {
        try {

            Optional<User> user = userRepositary.findById(number);
            userRepositary.deleteById(user.get().getPhone());
            return true;
        }
        catch (Exception e)
        {
            System.out.println(e.toString());
        }
        return false;
    }


}
