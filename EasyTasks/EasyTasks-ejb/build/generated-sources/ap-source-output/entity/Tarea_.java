package entity;

import entity.Proyecto;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-05-10T14:52:48")
@StaticMetamodel(Tarea.class)
public class Tarea_ { 

    public static volatile SingularAttribute<Tarea, String> descripcion;
    public static volatile SingularAttribute<Tarea, String> estado;
    public static volatile SingularAttribute<Tarea, Proyecto> proyectoId;
    public static volatile SingularAttribute<Tarea, BigDecimal> id;

}