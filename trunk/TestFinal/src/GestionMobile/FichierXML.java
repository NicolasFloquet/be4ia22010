/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionMobile;

import DAO_XML.*;
import DAO_XML.XMLDAOFactory;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Vector;
import org.xmlpull.v1.XmlPullParserException;

/**
 *
 * @author Edith
 */
public class FichierXML {

    //renvoie l'intule d'un ordre
    public String IntitulerOrdre(int idOrdre) {
        
        Ordre ordre = null;
         XMLDAOFactory factory = new XMLDAOFactory();


        MissionDAO mDao = factory.getMissionDAO();
        try {
            Mission mission = mDao.extractMission(true, true);
            ordre = mission.findOrdre(idOrdre);

        } catch (XmlPullParserException ex) {
            ex.printStackTrace();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return ordre.getContenu();
        
    }

    //renvoie un vecteur (de String) avec tous les choix possibles d'un ordre
    public Vector ChoixPossible(int idOrdre) {

        Ordre ordre = null;
        ReponsePossible repP;

        Vector reponses = new Vector();
        XMLDAOFactory factory = new XMLDAOFactory();


        MissionDAO mDao = factory.getMissionDAO();
        try {
            Mission mission = mDao.extractMission(true, true);
            ordre = mission.findOrdre(idOrdre);

        } catch (XmlPullParserException ex) {
            ex.printStackTrace();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        int i = 0;

        Vector tabReponses = ordre.getReponses();
        while (i < tabReponses.size()) {
            repP = (ReponsePossible) tabReponses.get(i);
            reponses.add(repP.getReponse());
        }

        return reponses;
    }


}
