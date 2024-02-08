package com.csc340.mvcdemo.service;

import com.csc340.mvcdemo.model.User;
import java.util.Collection;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.TreeMap;
import org.springframework.stereotype.Service;

/**
 *
 * @author csc340-sp24
 */
@Service
public class UserService {

    NavigableMap<Integer, User> users = new TreeMap<>();

    /**
     * Get entire list of users.
     *
     * @return the user list.
     */
    public Collection getAllUsers() {

        if (users.isEmpty()) {
            users.put(0, new User(0,
                    "sample", "sample@domain.com"));
        }
        return users.values();
    }

    /**
     * Get a specific user using id.
     *
     * @param id
     * @return the user.
     */
    public User getUserById(int id) {

        return users.get(id);
    }

    /**
     * Add a new user to the list.
     *
     * @param user
     */
    public void createUser(User user) {
        Entry<Integer, User> lastEntry = users.lastEntry();
        int index = lastEntry.getKey() + 1;
        user.setId(index);
        users.put(user.getId(), user);

    }

    /**
     * Delete a specific user using id.
     *
     * @param id
     */
    public void deleteUser(int id) {
        users.remove(id);
    }
}
