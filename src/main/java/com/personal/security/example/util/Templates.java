package com.personal.security.example.util;

public interface Templates {

    String ROOT = "index";

    String REGISTRATION = "registration";

    static String redirect(String url) {
        return String.format("redirect:/%s", url);
    }

}
