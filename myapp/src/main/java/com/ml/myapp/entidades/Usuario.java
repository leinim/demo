package com.ml.myapp.entidades;

import com.ml.myapp.enums.Rol;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Entity
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class Usuario {
    
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    
    private String nombre;
    private String apellido;
    private String email;
    private String password;
    @OneToOne
    private Imagen imagen;
    @Temporal(TemporalType.DATE)
    private Date alta;
    @Temporal(TemporalType.DATE)
    private Date baja;
    private Rol rol;
    
}
