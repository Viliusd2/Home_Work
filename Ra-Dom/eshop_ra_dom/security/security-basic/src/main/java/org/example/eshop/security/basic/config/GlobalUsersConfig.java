package org.example.eshop.security.basic.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@ConfigurationProperties("global")
public class GlobalUsersConfig {
    private final List<GlobalUser> users = new ArrayList<>();

    public Collection<GlobalUser> getUsers() {
        return users;
    }

    @Override
    public String toString() {
        Object[] usersName = users.stream().map(GlobalUser::getUsername).toArray();

        return "ApplicationUsersPropertyConfig{" +
                "users=" + Arrays.toString(usersName) +
                '}';
    }
}
