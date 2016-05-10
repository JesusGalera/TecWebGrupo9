/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Usuario;
import java.math.BigDecimal;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jesus
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> {

    @PersistenceContext(unitName = "EasyTasks-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
    public Usuario findByNickname(String nickname){
        return (Usuario)em.createNamedQuery("Usuario.findByNickname").setParameter("nickname", nickname).getSingleResult();
    }
    public Usuario findByNicknameOrEmail(String nickname,String email){
        return (Usuario)em.createNamedQuery("Usuario.findByNicknameOrEmail").setParameter("nickname",nickname).setParameter("email", email).getSingleResult();
    }
    public Usuario findByEmail(String email){
        return (Usuario)em.createNamedQuery("Usuario.findByEmail").setParameter("email", email).getSingleResult();
    }
    public BigDecimal findMaxUsuarioId(){
        return (BigDecimal)em.createQuery("select max(user.id) from Usuario user").getSingleResult();
    }

    
}
