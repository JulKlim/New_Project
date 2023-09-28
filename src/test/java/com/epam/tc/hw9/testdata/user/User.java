package com.epam.tc.hw9.testdata.user;

public class User {
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;

    private User() {
    }

    public static class UserBuilder {
        private final User user = new User();

        public UserBuilder setUsername(String username) {
            user.username = username;
            return this;
        }

        public UserBuilder setFirstName(String firstName) {
            user.firstName = firstName;
            return this;
        }

        public UserBuilder setLastName(String lastName) {
            user.lastName = lastName;
            return this;
        }

        public UserBuilder setEmail(String email) {
            user.email = email;
            return this;
        }

        public UserBuilder setPassword(String password) {
            user.password = password;
            return this;
        }

        public UserBuilder setPhone(String phone) {
            user.phone = phone;
            return this;
        }

        public User build() {
            return user;
        }
    }

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }
}
