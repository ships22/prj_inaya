package com.inaya.stockmanagement.service.user;

import com.inaya.stockmanagement.model.User;
import com.inaya.stockmanagement.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * @param user
     * @return
     */
    @Override
    public User add(User user) {
        return userRepository.save(user);
    }

    /**
     * @param user
     * @return
     */
    @Override
    public User update(User user) {
        return userRepository.saveAndFlush(user);
    }

    /**
     * @return
     */
    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    /**
     * @param id
     */
    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
