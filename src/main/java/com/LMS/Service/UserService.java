package com.LMS.Service;

import com.LMS.Entites.User;
import com.LMS.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class UserService {

    private static final Logger logger = Logger.getLogger(UserService.class.getName());

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        logger.info("Fetching all users from the database");
        return userRepository.findAll();
    }

    public User getUserById(Integer id) {
        logger.info("Fetching user with ID: " + id);
        return userRepository.findById(id)
                .orElseThrow(() -> {
                    logger.warning("User not found with ID: " + id);
                    return new RuntimeException("User not found with ID: " + id);
                });
    }

    @Transactional
    public User saveUser(User user) {
        logger.info("Saving user with username: " + user.getUsername());
        if (user.getRole() == null) {
            logger.warning("Role is null for user: " + user.getUsername());
            throw new IllegalArgumentException("User role cannot be null");
        }
        return userRepository.save(user);
    }

    @Transactional
    public void deleteUser(Integer id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            logger.info("Deleting user with ID: " + id);
            userRepository.deleteById(id);
        } else {
            logger.warning("User not found with ID: " + id);
            throw new RuntimeException("User not found with ID: " + id);
        }
    }
}
