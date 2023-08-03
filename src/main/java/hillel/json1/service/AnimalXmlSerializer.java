package hillel.json1.service;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import hillel.json1.model.Animal;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

/**
 * @author Serhii Klunniy
 */
public class AnimalXmlSerializer {

    public void serialize(Animal animal) {
        XmlMapper xmlMapper = new XmlMapper();
        try {
            xmlMapper.writeValue(new File("src/main/resources/animal.xml"), animal);
        } catch (IOException e) {
            System.out.println("cannot write file");
            e.printStackTrace();
        }
    }

    public Optional<Animal> deserialize() {
        XmlMapper xmlMapper = new XmlMapper();
        try {
            return Optional.of(xmlMapper.readValue(new File("src/main/resources/animal.json"), Animal.class));
        } catch (IOException e) {
            System.out.println("cannot read file");
            e.printStackTrace();
            return Optional.empty();
        }
    }

}
