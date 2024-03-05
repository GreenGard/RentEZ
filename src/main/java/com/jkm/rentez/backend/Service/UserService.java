package com.jkm.rentez.backend.service;
import com.jkm.rentez.backend.entity.UserEntity;
import com.jkm.rentez.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
// import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    // private PasswordEncoder passwordEncoder;
    
    // public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
    //     this.userRepository = userRepository;
    //     this.passwordEncoder = passwordEncoder;
    // }
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
       
    }

    public List<UserEntity> getAllUsers() {
        return (List<UserEntity>) userRepository.findAll();
    }

    public Optional<UserEntity> getUserById(Long id) {
        return userRepository.findById(id);
    }

    // public UserEntity createUser(UserEntity user) {
    //     user.setPassword(passwordEncoder.encode(UserEntity.getPassword()));
    //     return userRepository.save(user);
    // }
    public UserEntity createUser(UserEntity user) {
        return userRepository.save(user);
    }
    
    // public UserEntity updateUser(Long id, UserEntity user) {
    //     Optional<UserEntity> userData = userRepository.findById(id);

    //     if (userData.isPresent()) {
    //         UserEntity user = userData.get();
    //         // user.setName(user.getName());
    //         // user.setLastname(user.getLastname());
    //         user.setUsername(user.getUsername());
    //         // user.setEmail(user.getEmail());
    //         // user.setCity(user.getCity());
    //         // user.setCompany(user.getCompany());
    //         user.setPassword(UserEntity.getPassword());
    //         return userRepository.save(user);
    //     } else {
    //         throw new IllegalArgumentException("User not found with id: " + id);
    //     }
    // }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}