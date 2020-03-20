package modele;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.Collection;

public class TestFacade {

    private Facade maFacade;

    @Before
    public void methode1() {
        this.maFacade = Facade.creer();
    }



    @Test
    public void testAjouterCheval() {
        int id = this.maFacade.ajouterCheval("Jolly Jumper", 6);
        Assert.assertEquals(id,0);

    }


    @Test
    public void testGetChevalByIdOk() throws ChevalNotFoundException {
        int id = this.maFacade.ajouterCheval("Jolly Jumper",6);

        Cheval cheval = this.maFacade.getChevalById(id);
        Assert.assertNotNull(cheval);
        Assert.assertEquals(cheval.getNom(),"Jolly Jumper");
        Assert.assertEquals(cheval.getAge(),6);
        Assert.assertEquals(cheval.getIdCheval(),id);
    }

    @Test(expected = ChevalNotFoundException.class)
    public void testGetChevalByIdKO() throws ChevalNotFoundException {
        int id = this.maFacade.ajouterCheval("Jolly Jumper",6);

        Cheval cheval = this.maFacade.getChevalById(id+1);
    }

    @Test
    public void testGetChevaux1() {
        Collection<Cheval> chevaux = this.maFacade.getChevaux();
        Assert.assertEquals(chevaux.size(),0);
    }

    @Test
    public void testGetChevaux2() {
        int id = this.maFacade.ajouterCheval("Jolly Jumper",6);
        Collection<Cheval> chevaux = this.maFacade.getChevaux();
        Assert.assertEquals(chevaux.size(),1);
    }

    @After
    public void reinitialise() {
       Cheval.restartID();
    }
}
