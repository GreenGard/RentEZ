package com.jkm.rentez.backend.Service;
import com.jkm.rentez.backend.Entity.User;
import com.jkm.rentez.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Long id, User user) {
        Optional<User> userData = userRepository.findById(id);

        if (userData.isPresent()) {
            User _user = userData.get();
            _user.setName(user.getName());
            _user.setLastname(user.getLastname());
            _user.setUsername(user.getUsername());
            _user.setEmail(user.getEmail());
            _user.setCity(user.getCity());
            _user.setCompany(user.getCompany());
            _user.setPassword(user.getPassword());
            return userRepository.save(_user);
        } else {
            throw new IllegalArgumentException("User not found with id: " + id);
        }
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}