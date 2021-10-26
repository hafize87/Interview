package com.interview.pojo;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Tag {

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
