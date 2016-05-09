package entity;

import entity.Entrada;
import entity.Proyecto;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-05-08T18:51:01")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, String> apellidos;
    public static volatile CollectionAttribute<Usuario, Proyecto> proyectoCollection1;
    public static volatile SingularAttribute<Usuario, String> nickname;
    public static volatile SingularAttribute<Usuario, BigDecimal> id;
    public static volatile CollectionAttribute<Usuario, Proyecto> proyectoCollection;
    public static volatile SingularAttribute<Usuario, String> nombre;
    public static volatile SingularAttribute<Usuario, String> email;
    public static volatile CollectionAttribute<Usuario, Entrada> entradaCollection;
    public static volatile SingularAttribute<Usuario, String> contraseña;

}