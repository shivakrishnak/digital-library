package com.shiva.book.model;

public enum CategoryEnum {

    Fiction("Fiction"),
    NonFiction("Non-Fiction"),
    SoftwareDevelopment("Software Development");

    private String name;

    CategoryEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


}
