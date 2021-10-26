package com.interview.pojo;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pet {

    private Long id;
    private Category category;
    private String name;
    private List<String> photoUrls = new ArrayList<>();
    private List<Tag> tags = new ArrayList<>();
    private String status;

    public void addPhotoUrl(String photoUrl) {
        photoUrls.add(photoUrl);
    }

    public void removePhotoUrl(String photoUrl) {
        photoUrls.removeIf(url -> url.equals(photoUrl));
    }

    public void addTag(Tag tag) {
        tags.add(tag);
    }

    public void removeTag(Tag tag) {
        tags.removeIf(t -> t.getName().equals(tag.getName()));
    }

    @Override
    public String toString() {

        return "{" +
                "\"id\":" + id + ",\n" +
                "\"category\":" + category + ",\n" +
                "\"name\":" + "\"" + name + "\"" + ",\n" +
                "\"photoUrls\":" + photoUrls + ",\n" +
                "\"tags\":" + tags + ",\n" +
                "\"status\":" + "\"" + status + "\"" + "\n" +
                "}";

    }

}
