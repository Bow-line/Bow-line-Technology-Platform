import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;


public class EditSchool extends MainEditor<School, String>{

    public EditSchool(EntityManagerFactory emf)
    {
        super(emf, School.class);
    }

    public List<School> findTheSchoolWithProperInfluence(int influence)
    {
        EntityManager em = getEmf().createEntityManager();
        List<School> schools = (List<School>) em.createQuery("select c from School c where c.influence > :influence", School.class)
                .setParameter("influence", influence)
                .getResultList();
        em.close();
        return schools;
    }
}
