package model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import javax.persistence.Id;

// POJO
@Entity
@Table(name="TestPuppy")

@JsonIdentityInfo(
        //this is to stop recursive hibernate joins
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)
public class TestPuppy {

    @Id
    public int puppy_id;
    public String puppy_name;
    public String puppy_breed;

    //Getters and Setters
    public int getPuppy_id() {
        return puppy_id;
    }

    public void setPuppy_id(int puppy_id) {
        this.puppy_id = puppy_id;
    }

    public String getPuppy_name() {
        return puppy_name;
    }

    public void setPuppy_name(String puppy_name) {
        this.puppy_name = puppy_name;
    }

    public String getPuppy_breed() {
        return puppy_breed;
    }

    public void setPuppy_breed(String puppy_breed) {
        this.puppy_breed = puppy_breed;
    }

    @Override
    public String toString() {
        return "TestPuppy{" +
                "puppy_id=" + puppy_id +
                ", puppy_name='" + puppy_name + '\'' +
                ", puppy_breed='" + puppy_breed + '\'' +
                '}';
    }
}
