package com.interview.utilities;

import com.github.javafaker.Faker;
import com.interview.pojo.Category;
import com.interview.pojo.Pet;
import com.interview.pojo.Tag;

public class CreateRandomPet {

    public static Pet createRandomPet() {

        Faker faker =  new Faker();

        Pet pet = new Pet();
        Category category = new Category();
        Tag tag = new Tag();

        category.setName("category1");
        tag.setName("tag1");

        pet.setName(faker.dog().name());
        pet.setCategory(category);
        pet.addPhotoUrl("\"" + faker.internet().url() + "\"");
        pet.addPhotoUrl("\"" + faker.internet().url() + "\"");
        pet.addTag(tag);
        pet.setStatus("available");

        return pet;

    }

}
