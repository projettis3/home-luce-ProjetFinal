package princetonPlainsboro;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultListModel;

class DossierMedical {

    private List<FicheDeSoins> fiches;     // contient des objets de classe 'FicheDeSoins'
    private DefaultListModel modelPatient; //contient la liste des patient
    private DefaultListModel modelCoutPatient; //contient la liste des couts patients
    private DefaultListModel modelMedecin; //contient la liste des medecins
    private DefaultListModel modelCoutMedecin; //contient la liste des couts medecins
    private DefaultListModel modelSpecialite; //contient la liste des spécialités
    private DefaultListModel modelCoutSpecialite; //contient la liste des couts des spécialités

    public DossierMedical() {
        fiches = new Vector<FicheDeSoins>();  // liste vide
        modelPatient = new DefaultListModel();
        modelCoutPatient = new DefaultListModel();
        modelMedecin = new DefaultListModel();
        modelCoutMedecin = new DefaultListModel();
        modelSpecialite = new DefaultListModel();
        modelCoutSpecialite = new DefaultListModel();
    }

    public List<FicheDeSoins> getFiches() {
        return fiches;
    }

    public DefaultListModel getModelPatient() {
        return modelPatient;
    }

    public DefaultListModel getModelCoutPatient() {
        return modelCoutPatient;
    }

    public DefaultListModel getModelMedecin() {
        return modelMedecin;
    }

    public DefaultListModel getModelCoutMedecin() {
        return modelCoutMedecin;
    }

    public DefaultListModel getModelSpecialite() {
        return modelSpecialite;
    }

    public DefaultListModel getModelCoutSpecialite() {
        return modelCoutSpecialite;
    }


    public void ajouterFiche(FicheDeSoins fiche) {

        fiches.add(fiche);

        if (!modelPatient.contains(fiche.getPatient())) {
            modelPatient.addElement(fiche.getPatient());
        }
        if (!modelMedecin.contains(fiche.getMedecin())) {
            modelMedecin.addElement(fiche.getMedecin());
        }
        if (!modelSpecialite.contains(fiche.getMedecin().getSpecialite())) {
            System.out.println("ne contient pas la spécialité");
            modelSpecialite.addElement(fiche.getMedecin().getSpecialite());
            modelCoutSpecialite.addElement(coutSpecialite((Specialite) fiche.getMedecin().getSpecialite()));//cast de 'getSpecialite()' en Specialite car Enum dans Medecin
           
        }
            if (modelSpecialite.contains(fiche.getMedecin().getSpecialite())){
            int position=modelSpecialite.indexOf(fiche.getMedecin().getSpecialite());
            Object cout = modelCoutSpecialite.get(position);
            double prix= new Double(cout.toString());
            prix=prix+coutSpecialite((Specialite) fiche.getMedecin().getSpecialite());
            modelCoutSpecialite.setElementAt(prix, position);
        }
        modelCoutPatient.addElement(coutPatient(fiche.getPatient()));
        modelCoutMedecin.addElement(coutMedecin(fiche.getMedecin()));

    }

    public void afficher() {
        System.out.println("Dossier medical informatise :");
        System.out.println("-----------------------------");
        for (int i = 0; i < fiches.size(); i++) {
            FicheDeSoins f = fiches.get(i);
            f.afficher();
            // pour separer les fiches de soins :
            System.out.println("--------------------------------------");
        }
    }

    public void afficherListeActes(Patient p) {
        System.out.println("Liste des actes medicaux :");
        System.out.println("--------------------------");
        for (int i = 0; i < fiches.size(); i++) {
            FicheDeSoins f = fiches.get(i);
            if (p.equals(f.getPatient())) {
                for (int j = 0; j < fiches.get(i).getActes().size(); j++) {
                    //Definir getActe() dans Acte
                    Acte a = fiches.get(i).getActes().get(j);
                    System.out.println("-" + a.toString());
                }
            }
        }
    }

    public void afficherListePatients() {
        System.out.println("Liste de tous les patients:");
        Vector<Patient> liste = new Vector<Patient>();
        for (int i = 0; i < fiches.size(); i++) {
            FicheDeSoins f = fiches.get(i);
            Patient p = f.getPatient();
            if (!liste.contains(p)) {
                System.out.println(" - " + p.toString());
                liste.add(p);
            }
        }
    }

    public void afficherListeMedecin() {
        System.out.println("Liste de tous les medecins:");
        Vector<Medecin> liste = new Vector<Medecin>();
        for (int i = 0; i < fiches.size(); i++) {
            FicheDeSoins f = fiches.get(i);
            Medecin m = f.getMedecin();
            if (!liste.contains(m)) {
                System.out.println("-" + m.toString());
                liste.add(m);
            }
        }
    }

    public double nbMedecin() {
        double nbM = 0.0;
        System.out.println("Nombre de medecins au total:");
        Vector<Medecin> liste = new Vector<Medecin>();
        for (int i = 0; i < fiches.size(); i++) {
            FicheDeSoins f = fiches.get(i);
            Medecin m = f.getMedecin();
            if (!liste.contains(m)) {
                liste.add(m);
            } else {
                i++;
            }
        }
        for (int j = 0; j < liste.size(); j++) {
            nbM++;
        }
        return nbM;
    }

    public double nbPatient() {
        double nbP = 0.0;
        System.out.println("Nombre de patients au total:");
        Vector<Patient> liste = new Vector<Patient>();
        for (int i = 0; i < fiches.size(); i++) {
            FicheDeSoins f = fiches.get(i);
            Patient p = f.getPatient();
            if (!liste.contains(p)) {
                liste.add(p);
            } else {
                i++;
            }
        }
        for (int j = 0; j < liste.size(); j++) {
            nbP++;
        }
        return nbP;
    }

    public double coutPatient(Patient p) {
        double cout = 0;
        for (int i = 0; i < fiches.size(); i++) {
            FicheDeSoins f = fiches.get(i);
            if (p.equals(f.getPatient())) {
                cout += f.coutTotal();
            }
        }
        return cout;
    }

    public double coutMedecin(Medecin m) {
        double cout = 0;
        for (int i = 0; i < fiches.size(); i++) {
            FicheDeSoins f = fiches.get(i);
            if (m.equals(f.getMedecin())) {
                cout += f.coutTotal();
            }
        }
        return cout;
    }

    public double coutSpecialite(Specialite specialite) {
        double cout = 0;
        for (int i = 0; i < fiches.size(); i++) {
            FicheDeSoins f = fiches.get(i);
            if (specialite.equals(f.getMedecin().getSpecialite())) {
                cout += f.coutTotal();
            }
        }
        return cout;
    }
//affichage de la liste des patients du mï¿½decin m

    public void afficherListePatients(Medecin m) {
        System.out.println("> liste des patients du " + m.toString() + " :");
        Vector<Patient> liste = new Vector<Patient>();
        for (int i = 0; i < fiches.size(); i++) {
            FicheDeSoins f = fiches.get(i);
            if (m.equals(f.getMedecin())) {
                Patient p = f.getPatient();
                if (!liste.contains(p)) {
                    System.out.println(" - " + p.toString());
                    liste.add(p);
                }
            }
        }
    }
//affichage de toutes les fiches d'un patient et de son cout total

    public void afficherPatient(Patient p) {
        System.out.println("> Fiches de soins du patient " + p + "\n" + "------------------------");
        double cout = 0;
        for (int i = 0; i < fiches.size(); i++) {
            if (fiches.get(i).getPatient() == p) {
                cout += fiches.get(i).coutTotal();
                fiches.get(i).afficher();
            }
        }
        System.out.println("_______________" + "\n" + "COUT TOTAL: " + cout);
    }

    //affichage de le liste des medecins du patient p
    public void afficherListeMedecins(Patient p) {
        System.out.println("> liste des medecins du patient " + p);
        Vector<Medecin> l = new Vector<Medecin>();
        for (int i = 0; i < fiches.size(); i++) {
            if (fiches.get(i).getPatient() == p && !l.contains(fiches.get(i).getMedecin())) {
                System.out.println(fiches.get(i).getMedecin());
                l.add(fiches.get(i).getMedecin());
            }
        }
    }

    public int nombreFichesIntervalle(Date d1, Date d2) {
        int n = 0;
        for (int i = 0; i < fiches.size(); i++) {
            FicheDeSoins f = fiches.get(i);
            Date d = f.getDate();
            if (d.compareTo(d1) >= 0 && d.compareTo(d2) <= 0) {
                n++;
            }
        }
        return n;
    }

//affichages des fiches comprises entres 2 dates
    public void afficherFichesIntervalle(Date d1, Date d2) {
        System.out.println("ensemble des fiches comprises entre le " + d1 + " et le " + d2 + ": " + "\n" + "---------------------");
        this.trierDates();
        int i = 0;
        while (fiches.get(i).getDate().compareTo(d1) < 0) {
            i++;
        }
        for (int j = i; j < (i + this.nombreFichesIntervalle(d1, d2)); j++) {
            fiches.get(j).afficher();
        }
    }
    //tri et affichage par couts

    public void afficherFichesTrieesCouts() {
        System.out.println("fiches triees par couts: ");
        Vector<FicheDeSoins> copieFiches = new Vector<FicheDeSoins>(fiches);
        ComparaisonFichesCouts c;
        System.out.println("------------------------");
        c = new ComparaisonFichesCouts();
        while (!copieFiches.isEmpty()) {
            // on cherche la fiche de soins de cout minimale :
            int imin = 0;
            FicheDeSoins f1 = copieFiches.get(imin);
            for (int i = 1; i < copieFiches.size(); i++) {
                FicheDeSoins f2 = copieFiches.get(i);
                if (c.comparer(f2, f1) < 0) {
                    imin = i;
                    f1 = f2;
                }
            }
            // on affiche la fiche de soins trouvee :
            f1.afficher();
            System.out.println("------------------------");
            //on la supprime de la liste :
            copieFiches.remove(imin);
        }
    }

//tri et affichage par dates
    public void trierDates() {
        Vector<FicheDeSoins> copieFiches = new Vector<FicheDeSoins>(fiches);

        while (!copieFiches.isEmpty()) {
            // on cherche la fiche de soins de date minimale :
            int imin = 0;
            FicheDeSoins f1 = copieFiches.get(imin);
            for (int i = 1; i < copieFiches.size(); i++) {
                FicheDeSoins f2 = copieFiches.get(i);
                if (f2.getDate().compareTo(f1.getDate()) < 0) {
                    imin = i;
                    f1 = f2;
                }
            }
            // on affiche la fiche de soins trouvee :
            f1.afficher();
            System.out.println("------------------------");
            //on la supprime de la liste :
            copieFiches.remove(imin);
        }
    }

    // tri generique :
    public void trier(ComparaisonFiches c) {
        Vector<FicheDeSoins> copieFiches = new Vector<FicheDeSoins>(fiches);

        while (!copieFiches.isEmpty()) {
            // on cherche la fiche de soins minimale :
            int imin = 0;
            FicheDeSoins f1 = copieFiches.get(imin);
            for (int i = 1; i < copieFiches.size(); i++) {
                FicheDeSoins f2 = copieFiches.get(i);
                if (c.comparer(f2, f1) < 0) {
                    imin = i;
                    f1 = f2;
                }
            }
            // on affiche la fiche de soins trouvee :
            f1.afficher();
            System.out.println("------------------------");
            //on la supprime de la liste :
            copieFiches.remove(imin);
        }
    }

    //renvoie la liste des medecins (vector)
    public Vector<Medecin> renvoieListeMedecins() {
        Vector<Medecin> liste = new Vector<Medecin>();
        for (int i = 0; i < fiches.size(); i++) {
            FicheDeSoins f = fiches.get(i);
            Medecin m = f.getMedecin();
            if (!liste.contains(m)) {
                liste.add(m);
            }
        }
        return liste;
    }

    public Vector<Patient> renvoieListePatients() {
        Vector<Patient> liste = new Vector<Patient>();
        for (int i = 0; i < fiches.size(); i++) {
            FicheDeSoins f = fiches.get(i);
            Patient p = f.getPatient();
            if (!liste.contains(p)) {
                liste.add(p);
            }
        }
        return liste;
    }

    public String afficherString() {
        System.out.println("afficherString dm");
        String s = "Dossier medical informatise :";
        s += "\n" + "-----------------------------";
        for (int i = 0; i < fiches.size(); i++) {
            System.out.println("boucle dm");
            FicheDeSoins f = fiches.get(i);
            s += "\n" + f.afficherString();
            // pour separer les fiches de soins :
            s += "\n" + "-------------------------------------";
        }
        return s;
    }

    public String afficherPatientString(Patient p) {
        String s = "> Fiches de soins du patient " + p + "\n" + "------------------------";
        double cout = 0;
        for (int i = 0; i < fiches.size(); i++) {
            if (fiches.get(i).getPatient() == p) {
                cout += fiches.get(i).coutTotal();
                s += fiches.get(i).afficherString();
            }
        }
        s += "\n" + "_______________" + "\n" + "COUT TOTAL: " + cout;
        return s;
    }

    public String afficherFichesIntervalleString(Date d1, Date d2) {
        ComparaisonFiches c = new ComparaisonFichesDates();
        String s = "ensemble des fiches comprises entre le " + d1 + " et le " + d2 + ": " + "\n" + "---------------------";
        //création et remplissage d'un vecteur contenant les fiches entre les deux dates
        Vector<FicheDeSoins> copieFiches = new Vector<FicheDeSoins>();
        for (int i = 0; i < fiches.size(); i++) {
            Date di = fiches.get(i).getDate();
            if (di.compareTo(d2) < 0 && di.compareTo(d1) > 0) {
                copieFiches.add(fiches.get(i));
            }
        }
        //puis on trie en fonction des dates et on affiche au fur et à mesure
        while (!copieFiches.isEmpty()) {
            // on cherche la fiche de soins minimale :
            int jmin = 0;
            FicheDeSoins f1 = copieFiches.get(jmin);
            for (int j = 1; j < copieFiches.size(); j++) {
                FicheDeSoins f2 = copieFiches.get(j);

                if (c.comparer(f2, f1) < 0) {
                    jmin = j;
                    f1 = f2;
                }
            }
            s += "\n" + f1.afficherString();
            s += "\n" + "_______________" + "\n";
            copieFiches.remove(jmin);

        }

        return s;

    }

    //tri et affichage par couts
    public String afficherFichesTrieesCoutsString() {
        String s = "fiches triees par couts: ";
        Vector<FicheDeSoins> copieFiches = new Vector<FicheDeSoins>(fiches);
        ComparaisonFichesCouts c;
        s += "\n" + "------------------------";
        c = new ComparaisonFichesCouts();
        while (!copieFiches.isEmpty()) {
            // on cherche la fiche de soins de cout minimale :
            int imin = 0;
            FicheDeSoins f1 = copieFiches.get(imin);
            for (int i = 1; i < copieFiches.size(); i++) {
                FicheDeSoins f2 = copieFiches.get(i);
                if (c.comparer(f2, f1) < 0) {
                    imin = i;
                    f1 = f2;
                }
            }
            // on affiche la fiche de soins trouvee :
            s += "\n" + f1.afficherString();
            s += "\n" + "------------------------";
            //on la supprime de la liste :
            copieFiches.remove(imin);
        }
        return s;
    }

    // tri generique :
    public String trierString(ComparaisonFiches c) {
        Vector<FicheDeSoins> copieFiches = new Vector<FicheDeSoins>(fiches);
        String s = "fiches triees par dates: ";
        while (!copieFiches.isEmpty()) {
            // on cherche la fiche de soins minimale :
            int imin = 0;
            FicheDeSoins f1 = copieFiches.get(imin);
            for (int i = 1; i < copieFiches.size(); i++) {
                FicheDeSoins f2 = copieFiches.get(i);
                if (c.comparer(f2, f1) < 0) {
                    imin = i;
                    f1 = f2;
                }
            }
            // on affiche la fiche de soins trouvee :
            s += "\n" + f1.afficherString();
            s += "\n" + "------------------------";
            //on la supprime de la liste :
            copieFiches.remove(imin);
        }
        return s;
    }
    //affichage de la liste des patients du mï¿½decin m

    public void afficherListePatientsString(Medecin m) {
        String s = "> liste des patients du " + m.toString() + " :";
        Vector<Patient> liste = new Vector<Patient>();
        // 'liste' contient tous les patients deja affiches
        // --> ceci permet de ne pas reafficher un patient deja affiche
        for (int i = 0; i < fiches.size(); i++) {
            FicheDeSoins f = fiches.get(i);
            if (m.equals(f.getMedecin())) {
                Patient p = f.getPatient();
                if (!liste.contains(p)) {
                    s += "\n" + " - " + p.toString();
                    liste.add(p);
                }
            }
        }
    }
}
