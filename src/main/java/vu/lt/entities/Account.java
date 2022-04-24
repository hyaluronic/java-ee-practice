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
        @NamedQuery(name = "Account.findAll", query = "select a from Account as a")
})
@Table(name = "ACCOUNT")
@Getter @Setter
public class Account implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 50)
    @Column(name = "NUMBER")
    private String number;

    @OneToOne
    @JoinColumn(name="CLIENT_ID")
    private Client client;

    @Version
    @Column(name = "OPT_LOCK_VERSION")
    private Integer version;

    public Account() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account client = (Account) o;
        return Objects.equals(id, client.id) &&
                Objects.equals(number, client.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, number);
    }
}
