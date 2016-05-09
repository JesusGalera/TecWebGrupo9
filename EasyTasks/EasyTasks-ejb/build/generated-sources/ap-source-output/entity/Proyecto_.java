package entity;

import entity.Entrada;
import entity.Tarea;
import entity.Usuario;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-05-09T23:06:01")
@StaticMetamodel(Proyecto.class)
public class Proyecto_ { 

    public static volatile SingularAttribute<Proyecto, String> descripcion;
    public static volatile SingularAttribute<Proyecto, Date> fechacreacion;
    public static volatile SingularAttribute<Proyecto, BigDecimal> id;
    public static volatile CollectionAttribute<Proyecto, Usuario> usuarioCollection;
    public static volatile CollectionAttribute<Proyecto, Tarea> tareaCollection;
    public static volatile SingularAttribute<Proyecto, String> nombre;
    public static volatile SingularAttribute<Proyecto, Usuario> usuarioId;
    public static volatile CollectionAttribute<Proyecto, Entrada> entradaCollection;

}