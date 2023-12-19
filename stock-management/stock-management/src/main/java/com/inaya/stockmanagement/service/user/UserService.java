package com.inaya.stockmanagement.service.user;

import com.inaya.stockmanagement.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User add(User user);

    User update(User user);

    List<User> getAll();

    Optional<User> findById(Long id);

    void delete(Long id);

}
