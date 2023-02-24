package peaksoft.models;

import com.sun.istack.NotNull;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.*;
import static jakarta.persistence.CascadeType.PERSIST;
import static jakarta.persistence.FetchType.LAZY;
import static jakarta.persistence.GenerationType.SEQUENCE;


@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "departments")
@EqualsAndHashCode
public class Department {
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "department_id_gen")
    @SequenceGenerator(name = "department_id_gen", sequenceName = "department_id_seq", allocationSize = 12)
    private Long id;
     @Column
    private String name;
    @ManyToMany(cascade = {REFRESH, DETACH, MERGE, PERSIST},fetch = LAZY)
    List<Doctor> doctors = new ArrayList<>();
    public void addDoctor(Doctor doctor){
        if (doctors == null){
            doctors = new ArrayList<>();
        }else {
            doctors.add(doctor);
        }
    }
    @ManyToOne(cascade = {REFRESH, DETACH, MERGE, PERSIST})
    private Hospital hospital;
}
