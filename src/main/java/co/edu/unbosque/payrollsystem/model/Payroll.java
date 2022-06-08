package co.edu.unbosque.payrollsystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity(name = "Payroll")
@Table(name = "payroll")
public class Payroll implements Serializable {
    public static final String ACTIVE = "A";

    public static final String INACTIVE = "I";

    @Serial
    private static final long serialVersionUID = 232314L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "fk_type_document", nullable = false, referencedColumnName = "id")
    private TypeDocument typeDocument;

    @Column(name = "document_number", unique = true, nullable = false, length = 25)
    private String documentNumber;

    @Column(name = "business_name", unique = true, nullable = false, length = 25)
    private String businessName;

    @Column(name = "reference", unique = true, nullable = false, length = 50)
    private String reference;

    @JsonIgnore
    @Column(name = "state", nullable = false, length = 1)
    private String state = ACTIVE;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Payroll payroll = (Payroll) o;
        return id != null && Objects.equals(id, payroll.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
