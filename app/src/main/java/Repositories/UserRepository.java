package Repositories;

import Common.User;

public interface UserRepository {
    public User getUser();
    public User createUser(User user);
}
