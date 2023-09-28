package com.epam.tc.hw9.testdata.pet;

public class Pet {
    private int id;
    private String category;
    private String name;
    private String photoUrls;
    private String[] tags;
    private String status;

    private Pet() {

    }

    public static class PetBuilder {
        private final Pet pet = new Pet();

        public PetBuilder setId(int id) {
            pet.id = id;
            return this;
        }

        public PetBuilder setCategory(String category) {
            pet.category = category;
            return this;
        }

        public PetBuilder setName(String name) {
            pet.name = name;
            return this;
        }

        public PetBuilder setPhotoUrls(String photoUrls) {
            pet.photoUrls = photoUrls;
            return this;
        }

        public PetBuilder setTags(String[] tags) {
            pet.tags = tags;
            return this;
        }

        public PetBuilder setStatus(String status) {
            pet.status = status;
            return this;
        }

        public Pet build() {
            return pet;
        }
    }

    public int getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public String getPhotoUrls() {
        return photoUrls;
    }

    public String[] getTags() {
        return tags;
    }

    public String getStatus() {
        return status;
    }
}
