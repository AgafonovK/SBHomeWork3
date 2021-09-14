package com.company.duplicates;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Duplicates {


    public static void main(String[] args) {
        Duplicates scratch = new Duplicates();
        User user1 = new User();
        user1.setName("Henry");
        User user2 = new User();
        user2.setName("Garry");
        User user3 = new User();
        user3.setName("Henry");
        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        System.out.println(userList.toString());
        System.out.println(scratch.removeDuplicates(userList).toString());
    }

    <T> Collection<T> removeDuplicates(Collection<T> collection){
        return collection.stream()
                .distinct()
                .collect(Collectors.toList());
    }

    static class User{
        private String name = "";

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            User user = (User) o;
            return name.equals(user.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }


}
