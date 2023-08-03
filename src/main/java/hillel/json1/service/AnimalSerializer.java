package hillel.json1.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import hillel.json1.enums.Extension;
import hillel.json1.model.Animal;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

/**
 * @author Serhii Klunniy
 * расширяемый класс
 * изменяемый
 * может покрыть несколько требований
 */
@Data
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AnimalSerializer<T extends ObjectMapper> {

    final T mapper;
    final File path;

    public AnimalSerializer(T mapper) {
        this.mapper = mapper;
        Extension extension = Extension.TXT;
        if (mapper instanceof JsonMapper) extension = Extension.JSON;
        if (mapper instanceof XmlMapper) extension = Extension.XML;
        if (mapper instanceof YAMLMapper) extension = Extension.YAML;
        this.path = new File("src/main/resources/animal" + extension);
    }

    public static void main(String[] args) {
        final Animal dog = new Animal("sharik66", "2015.03.11", 7, false, "doberman");
        final AnimalSerializer<JsonMapper> animalSerializer = new AnimalSerializer<>(new JsonMapper());
        animalSerializer.serialize(dog);
    }

    public void serialize(Animal animal) {
        try {
            mapper.writeValue(path, animal);
        } catch (IOException e) {
            System.out.println("Cannot create file");
            e.printStackTrace();
        }
    }

    public void serialize(List<Animal> animals) {
        try {
            mapper.writeValue(path, animals);
        } catch (IOException e) {
            System.out.println("Cannot create file");
            e.printStackTrace();
        }
    }

    public Optional<Animal> deserialize() {
        try {
            return Optional.of(mapper.readValue(path, Animal.class));
        } catch (IOException e) {
            System.out.println("Cannot read file");
            e.printStackTrace();
            return Optional.empty();
        }
    }

}
