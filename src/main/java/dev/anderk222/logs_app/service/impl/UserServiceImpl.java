package dev.anderk222.logs_app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import dev.anderk222.logs_app.domain.entity.User;
import dev.anderk222.logs_app.domain.repository.UserRepository;
import dev.anderk222.logs_app.service.contract.UserService;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public List<User> match(User user, Pageable pageable){

        return userRepository.findAll(Example.of(user), pageable).getContent();
    }

    public List<User> search(User user, Pageable pageable){

        ExampleMatcher matcher = ExampleMatcher.matching()
        .withIgnoreNullValues()
        .withMatcher("username", (m)->m.ignoreCase().contains())
        .withMatcher("email", (m)->m.ignoreCase().contains())
        .withMatcher("name", (m)->m.ignoreCase().contains())
        .withMatcher("lastname", (m)->m.ignoreCase().contains());

        return userRepository.findAll(Example.of(user, matcher), pageable).getContent();
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
