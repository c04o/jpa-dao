package services.dao;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import util.JPAConexion;

public class MyDao implements ICRUD {
    @Override
    public <T> List<T> getAll(String nameQuery, Class<T> clazz) {
        EntityManager em = JPAConexion.getEntityManager();
        try {
            TypedQuery<T> query = em.createNamedQuery(nameQuery, clazz);
            return query.getResultList();
        } catch (Exception ex){ex.printStackTrace();}
        finally{em.close();}
        return null;
    }
}
