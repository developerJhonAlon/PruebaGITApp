/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt_investigacion.session;

import ec.edu.espe_ctt_investigacion.entity.SeaObjetivosProg;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author PC1
 */
@Stateless
public class SeaObjetivosProgFacade extends AbstractFacade<SeaObjetivosProg> {
    @PersistenceContext(unitName = "Investigacion-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SeaObjetivosProgFacade() {
        super(SeaObjetivosProg.class);
    }
    public List<SeaObjetivosProg> findObjetivoProgramabyPro( BigDecimal codPro){
        List<SeaObjetivosProg> result = null;
        Query query = em.createQuery("SELECT o FROM SeaObjetivosProg o WHERE o.datgeprogId.datgeprogId =:codPro");
        query.setParameter("codPro", codPro);
        query.setHint("eclipselink.refresh",true);
        result = query.getResultList();
        return result == null || result.isEmpty() ? null : result;
    }
    
}
