import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class EditWizard extends MainEditor<Wizard, String> {

    public EditWizard(EntityManagerFactory emf)
    {
        super(emf, Wizard.class);
    }

    public List<Wizard> findTheParticularWizards(int level, School school)
    {
        EntityManager em = getEmf().createEntityManager();
        List<Wizard> wizards = (List<Wizard>) em.createQuery("select c from Wizard c where c.level > :level and c.school = '" + school.getName() + "' order by c.name", Wizard.class)
                .setParameter("level", level)
                .getResultList();
        em.close();
        return wizards;
    }

}
