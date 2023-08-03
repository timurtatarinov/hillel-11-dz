package hillel.json1.service;

import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import hillel.json1.model.Animal;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

/**
 * @author Serhii Klunniy
 */
public class AnimalYamlSerializer {

    public void serialize(Animal animal) {
        YAMLMapper yamlMapper = new YAMLMapper();
        try {
            yamlMapper.writeValue(new File("src/main/resources/animal.yaml"), animal);
        } catch (IOException e) {
            System.out.println("Cannot create file");
            e.printStackTrace();
        }
    }

    public void serialize(List<Animal> animals) {
        YAMLMapper yamlMapper = new YAMLMapper();
        try {
            yamlMapper.writeValue(new File("src/main/resources/animal.yaml"), animals);
        } catch (IOException e) {
            System.out.println("Cannot create file");
            e.printStackTrace();
        }
    }

    public Optional<Animal> deserialize() {
        YAMLMapper yamlMapper = new YAMLMapper();
        try {
            return Optional.of(yamlMapper.readValue(new File("src/main/resources/animal.yaml"), Animal.class));
        } catch (IOException e) {
            System.out.println("Cannot read file");
            e.printStackTrace();
            return Optional.empty();
        }
    }
}
