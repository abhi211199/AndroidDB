package com.example.resedue.resedue;

public class users{

    private String name;
    private String age;
    private String timestamp;

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public users(String name, String age, String timestamp) {
        this.name = name;
        this.age = age;
        this.timestamp = timestamp;
    }

    public users() {

        }

        public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
