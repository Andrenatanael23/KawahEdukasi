package id.kawahedukasi.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "items")
public class Item extends PanacheEntityBase {
    @Id
    @SequenceGenerator(name = "itemSequence", sequenceName = "item_sequence", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "itemSequence", strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    public long id;

    @Column(name = "name", nullable = false)
    public String name;

    @Column(name = "count" , nullable = false)
    public Integer count;

    @Column(name = "price" , nullable = false)
    public Double price;

    @Column(name = "type" , nullable = false)
    public String type;

    @Column(name = "description" , nullable = false)
    public String description;

    @CreationTimestamp
    @Column(name = "createdAt" , nullable = false)
    public LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updatedAt" , nullable = false)
    public LocalDateTime updatedAt;
}
