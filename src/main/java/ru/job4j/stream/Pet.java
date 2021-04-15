package ru.job4j.stream;

/**
 * 9. Шаблоны проектирования в Stream API [#340684]
 */
public class Pet {
    private Type type;
    private String name;
    private String gender;
    private byte age;
    private boolean hasOwner;
    private String nameOwner;

    public static void main(String[] args) {
        Pet pet = new Builder().buildName("Totoshka")
                .buildType(Type.Dog)
                .buildGender("male")
                .buildAge((byte) 3)
                .buildHasOwner(true)
                .buildNameOwner("Elli")
                .build();
        System.out.println(pet);

        Pet pet2 = new Builder().buildName("Kesha")
                .buildType(Type.Parrot)
                .buildGender("male")
                .buildAge((byte) 1)
                .buildHasOwner(true)
                .buildNameOwner("Vovka")
                .build();
        System.out.println(pet2);

    }

    @Override
    public String toString() {
        return "Pet{" +
                "type=" + type +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", hasOwner=" + hasOwner +
                ", nameOwner='" + nameOwner + '\'' +
                '}';
    }

    static class Builder {
        private Type type;
        private String name;
        private String gender;
        private byte age;
        private boolean hasOwner;
        private String nameOwner;

        Builder buildType(Type type) {
            this.type = type;
            return this;
        }

        Builder buildName(String name) {
            this.name = name;
            return this;
        }

        Builder buildGender(String gender) {
            this.gender = gender;
            return this;
        }

        Builder buildAge(byte age) {
            this.age = age;
            return this;
        }

        Builder buildHasOwner(boolean hasOwner) {
            this.hasOwner = hasOwner;
            return this;
        }

        Builder buildNameOwner(String nameOwner) {
            this.nameOwner = nameOwner;
            return this;
        }

        Pet build() {
            Pet pet = new Pet();
            pet.type = type;
            pet.name = name;
            pet.gender = gender;
            pet.age = age;
            pet.hasOwner = hasOwner;
            pet.nameOwner = nameOwner;
            return pet;
        }
    }
}
