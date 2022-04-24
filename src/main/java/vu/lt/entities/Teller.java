package vu.lt.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@NamedQueries({
        @NamedQuery(name = "Teller.findAll", query = "select t from Teller as t")
})
@Table(name = "TELLER")
@Getter @Setter
public class Teller implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 50)
    @Column(name = "NAME")
    private String name;

    @Column(name = "DEPARTMENT")
    private Integer department;

    @ManyToOne
    @JoinColumn(name="BANK_ID")
    private Bank bank;

    @ManyToMany(mappedBy = "tellers")
    private List<Client> clients = new ArrayList<>();

    @Version
    @Column(name = "OPT_LOCK_VERSION")
    private Integer version;

    public Teller() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teller teller = (Teller) o;
        return Objects.equals(id, teller.id) &&
                Objects.equals(name, teller.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
