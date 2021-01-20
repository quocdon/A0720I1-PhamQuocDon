package service;

import model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    public void save(User user);

    User findById(int id);

    void update(User user);

    void remove(int id);

    List<User> findByName(String name);
}
