package ir.darkdeveloper.sma.Users.Models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="roles")
public class UserRoles implements Serializable {
    

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique=true)
    private String name;

    @ElementCollection(targetClass = Authority.class, fetch=FetchType.EAGER)
    @CollectionTable(name="authorities", joinColumns=@JoinColumn(name="role_id", referencedColumnName="id"))
    @Enumerated(EnumType.STRING)
    private List<Authority> authorities;
}
