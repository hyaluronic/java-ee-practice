package vu.lt.entities;

import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.annotations.One;

import javax.faces.convert.FacesConverter;
import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@NamedQueries({
        @NamedQuery(name = "Client.findAll", query = "select c from Client as c")
})
@Table(name = "CLIENT")
@Getter @Setter
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 50)
    @Column(name = "NAME")
    private String name;

    @ManyToMany
    @JoinColumn(name="TELLER_ID")
    private List<Teller> tellers = new ArrayList<>();

    @OneToOne(mappedBy = "client")
    private Account account;

    @Version
    @Column(name = "OPT_LOCK_VERSION")
    private Integer version;

    public Client() {
    }

    public void addTeller(Teller teller){
        if (teller != null && !tellers.contains(teller)) {
            tellers.add(teller);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(id, client.id) &&
                Objects.equals(name, client.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return id.toString();
    }
}
