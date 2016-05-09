/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Tarea;
import java.math.BigDecimal;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author winnielean
 */
@Stateless
public class TareaFacade extends AbstractFacade<Tarea> {

    @PersistenceContext(unitName = "EasyTasks-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TareaFacade() {
        super(Tarea.class);
    }
    
    public BigDecimal findMaxTareaId () {
        Query q;
        
        q = em.createQuery("select max(t.id) from Tarea t");
        return (BigDecimal)q.getSingleResult();
    }
}
