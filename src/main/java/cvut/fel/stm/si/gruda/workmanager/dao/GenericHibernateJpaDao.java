/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cvut.fel.stm.si.gruda.workmanager.dao;

import cvut.fel.stm.si.gruda.workmanager.bo.AbstractBusinessObject;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.EntityManagerFactoryUtils;
import org.springframework.stereotype.Component;

/**
 *
 * @author Grudik-stolni
 */
/**
 * Implementuje (hibernatem) akce GenericDao zpusobem obvyklym pro prumerne dao.
 *
 * Tato implementace je postavena nad JPA + rozsirenimi frameworku Hibernate
 *
 *
 */
@Component(value = "genericDao")
public class GenericHibernateJpaDao implements GenericDao {

    @Autowired
    protected EntityManagerFactory entityManagerfactory;

    /**
     * Get entity manager for the current transaction
     *
     * @return
     */
    protected EntityManager getEntityManager() {
        return EntityManagerFactoryUtils.getTransactionalEntityManager(entityManagerfactory);//entity manager with @Transactional support
    }

    /**
     * Vrati vsechny objekty dane tridy
     *
     * @return vsechny objekty tridy, jez je injektovana jako clazz, serazene
     * dle id sestupne
     */
    @SuppressWarnings("unchecked")
    @Override
    public <ENTITY> List<ENTITY> getAll(Class<ENTITY> clazz) {
        return getEntityManager().createQuery("SELECT e FROM " + clazz.getSimpleName() + " e").getResultList();
    }

    /**
     * Vrati vsechny objekty serazene sestupne dle dane property
     *
     * @param property
     * @return
     */
    @SuppressWarnings("unchecked")
    @Override
    public <ENTITY> List<ENTITY> getAllOrderedDesc(String property, Class<ENTITY> clazz) {
        return getEntityManager().createQuery(
                "SELECT e FROM " + clazz.getSimpleName()
                + " e ORDER BY " + property + "d esc").getResultList();
    }

    /**
     * Vrati vsechny objekty serazene vzestupne dle dane property
     *
     * @param property
     * @return
     */
    @SuppressWarnings("unchecked")
    @Override
    public <ENTITY> List<ENTITY> getAllOrderedAsc(String property, Class<ENTITY> clazz) {
        return getEntityManager().createQuery(
                "SELECT e FROM " + clazz.getSimpleName()
                + " e ORDER BY " + property + " asc").getResultList();
    }

    /**
     * Vrati objekty dane tridy, jejichz property se rovna objektu predanemu v
     * parametru, serazene dle id sestupne
     *
     * @param property property, kterou porovnavame
     * @param value hodnota, se kterou porovnavame
     * @return vsechny vyhovujici zaznamy
     */
    @SuppressWarnings("unchecked")
    @Override
    public <ENTITY> List<ENTITY> getByProperty(String property, Object value, Class<ENTITY> clazz) {
        String queryString = "SELECT e FROM " + clazz.getSimpleName() + " e WHERE e." + property + " = :value";
        return getEntityManager().createQuery(queryString).setParameter("value", value).getResultList();
    }

    /**
     * Smaze objekt dle daneho ID
     *
     * @param id id objektu je smazani
     */
    @Override
    public <ENTITY extends AbstractBusinessObject> void removeById(long id, Class<ENTITY> clazz) {
        ENTITY e = getEntityManager().find(clazz, id);
        if (e != null) {
            getEntityManager().remove(e);
        }
    }

    /**
     * smaze danou entitu
     *
     * @param o entita ke smazani
     */
    @Override
    public <ENTITY extends AbstractBusinessObject> void remove(ENTITY o) {
        getEntityManager().remove(o);
    }

    /**
     * Vrati objekt (pomoci get) dane tridy dle ID
     *
     * @param id id objektu k vraceni
     * @return objekt identifikovany id,
     * @null pokud neexistuje
     */
    @SuppressWarnings("unchecked")
    @Override
    public <ENTITY> ENTITY getById(Long id, Class<ENTITY> clazz) {
        return getEntityManager().find(clazz, id);
    }

    @SuppressWarnings("unchecked")
    @Override
    public <ENTITY> ENTITY loadById(long id, Class<ENTITY> clazz) {
        return (ENTITY) ((Session) getEntityManager().getDelegate()).load(clazz, id);
    }

    @Override
    public <ENTITY extends AbstractBusinessObject> ENTITY saveOrUpdate(ENTITY o) {
        if (o.getId() == null) {
            getEntityManager().persist(o);
        } else {
            getEntityManager().merge(o);
        }
        return o;
    }

    @Override
    public <ENTITY> ENTITY getByPropertyUnique(String property, Object value, Class<ENTITY> clazz) {
        ENTITY e;
        if (value == null) {
            e = clazz.cast(getEntityManager().createQuery("FROM " + clazz.getSimpleName() + " WHERE " + property + " IS NULL").getSingleResult());
        } else {
            e = clazz.cast(getEntityManager().createQuery("FROM " + clazz.getSimpleName() + " WHERE " + property + " = :value").setParameter("value", value).getSingleResult());
        }
        return e;
    }

    @Override
    public Long getCount(Class clazz) {

        return (Long) getEntityManager().createQuery("SELECT COUNT(*) FROM " + clazz.getSimpleName() + " e").getSingleResult();
    }

    @Override
    public <ENTITY> List<ENTITY> getPage(int from, int maxResults, Class<ENTITY> clazz) {
        return getEntityManager().createQuery("SELECT e FROM "
                + clazz.getSimpleName() + " e").setFirstResult(from).setMaxResults(maxResults).getResultList();
    }

    public void merge(Object o) {
        getEntityManager().merge(o);
    }
}