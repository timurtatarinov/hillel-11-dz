package hillel.json1.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

/**
 * @author Serhii Klunniy
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Animal {

    String nikName;
    String dateOfArrival;
    int age;
    boolean gender;
    String bread;
    Type type;
       //add(new Type(1, "first", "string1"));
//       add(new Type(2, "second", "string2"));
//       add(new Type(3, "theard", "string3"));


    public Animal(String nikName, String dateOfArrival, int age, boolean gender, String bread) {
        this.nikName = nikName;
        this.dateOfArrival = dateOfArrival;
        this.age = age;
        this.gender = gender;
        this.bread = bread;
    }
}
