package id.kawahedukasi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;

@Entity
@Table(name = "tugas")
public class Tugas extends PanacheEntityBase {
    @Id
    @SequenceGenerator(name = "tugasSequence", sequenceName = "tugas_Sequence", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "tugasSequence", strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    public Long id;

    @Column(name = "name", nullable = false)
    public String name;

    @Column(name = "score", nullable = false)
    public int score;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "peserta_id")
    public Peserta peserta;
}
