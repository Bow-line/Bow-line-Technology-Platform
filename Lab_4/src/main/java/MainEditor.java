import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.List;

public abstract class MainEditor<Entity, Key> {
    private EntityManager em;
    private final EntityManagerFactory emf;
    private final Class<Entity> theClass;


    public MainEditor(EntityManagerFactory emf, Class<Entity> theClass)
    {
        this.emf = emf;
        this.theClass = theClass;
    }

    protected EntityManagerFactory getEmf()
    {
        return emf;
    }

    public Entity find(Key id)
    {
        em = emf.createEntityManager();
        Entity entity = em.find(theClass, id);
        em.close();
        return entity;
    }

    public List<Entity> findAllObjects()
    {
        em = emf.createEntityManager();
        List<Entity> list = em.createQuery("select e from "+ theClass.getSimpleName()
                + " e", theClass).getResultList();
        em.close();
        return list;
    }



    public void add (Entity entity)
    {
        em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(entity);
        transaction.commit();
        em.close();
    }

    public void remove (Entity entity)
    {
        em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(em.merge(entity));
        transaction.commit();
        em.close();
    }



}
