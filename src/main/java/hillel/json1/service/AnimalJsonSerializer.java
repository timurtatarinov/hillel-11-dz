package hillel.json1.service;

import com.fasterxml.jackson.databind.json.JsonMapper;
import hillel.json1.model.Animal;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

/**
 * @author Serhii Klunniy
 */
public class AnimalJsonSerializer {

    public void serialize(Animal animal) {
        JsonMapper jsonMapper = new JsonMapper();
        try {
            jsonMapper.writeValue(new File("src/main/resources/animal.json"), animal);
        } catch (IOException e) {
            System.out.println("Cannot create file");
            e.printStackTrace();
        }
    }

    public void serialize(List<Animal> animals) {
        JsonMapper jsonMapper = new JsonMapper();
        try {
            jsonMapper.writeValue(new File("src/main/resources/animal.json"), animals);
        } catch (IOException e) {
            System.out.println("Cannot create file");
            e.printStackTrace();
        }
    }

    public Optional<Animal> deserialize() {
        JsonMapper jsonMapper = new JsonMapper();
        try {
            return Optional.of(jsonMapper.readValue(new File("src/main/resources/animal.json"), Animal.class));
        } catch (IOException e) {
            System.out.println("Cannot read file");
            e.printStackTrace();
            return Optional.empty();
        }
    }
}
