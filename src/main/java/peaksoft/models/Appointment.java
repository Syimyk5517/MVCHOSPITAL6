package peaksoft.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

import static jakarta.persistence.CascadeType.*;
import static jakarta.persistence.CascadeType.PERSIST;
import static jakarta.persistence.FetchType.EAGER;
import static jakarta.persistence.GenerationType.SEQUENCE;


@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "appointments")
public class Appointment {
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "appointment_id_gen")
    @SequenceGenerator(name = "appointment_id_gen", sequenceName = "appointment_id_seq", allocationSize = 1)
    private Long id;

    private LocalDate date;


    @ManyToOne(cascade = {REFRESH, DETACH, MERGE, PERSIST},fetch = EAGER)
    private Patient patient;

    @ManyToOne(cascade = {REFRESH, DETACH, MERGE, PERSIST},fetch = EAGER)
    private Doctor doctor;

    @ManyToOne(fetch = EAGER, cascade = {REFRESH, DETACH, MERGE, PERSIST})
    private Department department;
}
