package entity;

import entity.Proyecto;
import entity.Usuario;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-05-09T23:06:01")
@StaticMetamodel(Entrada.class)
public class Entrada_ { 

    public static volatile SingularAttribute<Entrada, String> texto;
    public static volatile SingularAttribute<Entrada, Proyecto> proyectoId;
    public static volatile SingularAttribute<Entrada, Date> fechacreacion;
    public static volatile SingularAttribute<Entrada, BigDecimal> id;
    public static volatile SingularAttribute<Entrada, Usuario> usuarioId;

}