package models;

import io.ebean.Model;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "employee")
public class Employee extends Model {

    @Id
    private Integer id;

    private String name;

    private String passport;

}
