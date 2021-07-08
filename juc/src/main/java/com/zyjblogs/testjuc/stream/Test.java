package com.zyjblogs.testjuc.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        List<User> users = Arrays.asList(
                User.builder()
                        .id(1)
                        .name("a")
                        .age(23)
                        .build(),
                User.builder()
                        .id(2)
                        .name("d")
                        .age(21)
                        .build(),
                User.builder()
                        .id(3)
                        .name("c")
                        .age(24)
                        .build(),
                User.builder()
                        .id(4)
                        .name("b")
                        .age(25)
                        .build()
        );
        users.stream()
                .filter(u->u.getId()%2==0)
                .filter(u -> u.getAge() >20)
                .map(User::getName)
//                .collect(Collectors.toList())
                .sorted(String::compareTo)
                .forEach(System.out::println);
    }
}
