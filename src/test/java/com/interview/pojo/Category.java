package com.interview.pojo;

import lombok.*;
import lombok.NoArgsConstructor;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Category {

    private Long id;
    private String name;

    @Override
    public String toString() {

        return "{" +
                "\"id\":" + id + ",\n" +
                "\"name\":" + "\"" + name + "\"" + "\n" +
                "}";

    }


}
