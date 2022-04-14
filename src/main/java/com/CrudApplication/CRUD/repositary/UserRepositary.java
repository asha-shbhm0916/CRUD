package com.CrudApplication.CRUD.repositary;

import com.CrudApplication.CRUD.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositary extends JpaRepository<User,Integer> {


}
