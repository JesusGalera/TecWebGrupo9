/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Entrada;
import entity.Proyecto;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author jesus
 */
@Stateless
public class EntradaFacade extends AbstractFacade<Entrada> {

    @PersistenceContext(unitName = "EasyTasks-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EntradaFacade() {
        super(Entrada.class);
    }
    public BigDecimal findMaxEntradaId () {
        Query q;
        q = em.createQuery("select max(e.id) from Entrada e");
        return (BigDecimal)q.getSingleResult();  
    }
    
    public List<Entrada> findByProyectoIdOrderByFecha(Proyecto proyecto){
        return em.createNamedQuery("Entrada.findByProyectoIdOrderByFecha").setParameter("idProyecto", proyecto).getResultList();
    }
}
