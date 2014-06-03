//package princetonPlainsboro;
//
//import princetonPlainsboro.Acte.TypeActe;
//
//class Test {
//
//    public static void main(String[] args) {
//        LectureXML test = new LectureXML("dossiers.xml");
//        DossierMedical dm = test.getDossier();
//        dm.afficher();
//        System.out.println("\n********\n");
//        dm.afficherListePatients();
//        //
//        ////tests des fonctions de la classe Patient
//        //        Patient p1;
//        //        p1 = new Patient("Bole", "Pat", "290106806621855", new Date(18, 06, 1993, 07, 20), "20 rue du Roussillon, 34000 Lafre,France ");
//        //        System.out.println(p1.fichePatient());
//        //        /*System.out.println("tests des fonctions de la classe Patient");
//        //         System.out.println("fichePatient: ");
//        //         System.out.println(p1.fichePatient());
//        //         System.out.println("toString():");
//        //         System.out.println(p1.toString());
//        //         System.out.println("getNumSecu():");
//        //         System.out.println(p1.getNumSecu());
//        //         System.out.println("setNumSecu() bon");
//        //         p1.setNumSecu(293064410952163L);
//        //         System.out.println("setNumSecu() faux");
//        //         p1.setNumSecu(293064410952164L);*/
//        //        System.out.println("++++++++++++++");
//        //
//        ////tests de la classe medecin
//        //        Medecin m1 = new Medecin("Deblouze", "Agathe", Specialite.anesthegiologie, "06 58 46 57 35", "mdp");
//        //        /*System.out.println("test fiche medecin:");
//        //         System.out.println(m1.ficheMedecin());
//        //         System.out.println("test spécialité medecin");
//        //         System.out.println(m1.getSpecialite());
//        //         System.out.println("test toString medecin");
//        //         System.out.println(m1.toString());*/
//        //
//        ////tests de la classe date
//        //        Date d1 = new Date(1, 11, 2005);
//        //        Date d2 = new Date(5, 1, 2006, 03, 20);/*
//        //         //test de compare dates (avec formats 3 et 5 mélangés)
//        //         System.out.println(d2.compareTo(d1));
//        //         //affichage de la date en format 3 puis en format 5
//        //         System.out.println(d1.toString());
//        //         System.out.println(d2.toString());*/
//        //
//        ////tests de la classe acte 
//        //        Acte a1 = new Acte(Code.CS, 1, TypeActe.diagnostique, "suture du menton", "aucun commentaire à faire", d1);
//        //        /*System.out.println(a1.cout());
//        //         System.out.println(a1.toString());
//        //         System.out.println(a1.ficheActe());*/
//        //
//        ////test de la classe fiche de soin
//        //        FicheDeSoins f1 = new FicheDeSoins(p1, m1, d2);
//        //        f1.ajouterActe(a1);
//        //        f1.ajouterActe(Code.KC, 100);
//        //        /*System.out.println("test afficher fiche de soins");
//        //         f1.afficher();
//        //         System.out.println("test cout total");
//        //         System.out.println(f1.coutTotal());
//        //         System.out.println("test getActes");
//        //         System.out.println(f1.getActes());*/
//        //
//        ////test de la classe dossier médical
//        //        DossierMedical dm1 = new DossierMedical();
//        //        dm1.ajouterFiche(f1);
//        //        System.out.println("test coutMedecin m");
//        //        System.out.println(dm1.coutMedecin(m1));
//        //        System.out.println("test coutPatient p");
//        //        System.out.println(dm1.coutPatient(p1));
//        //        System.out.println("test coutSpecialite s");
//        //        System.out.println(dm1.coutSpecialite(Specialite.cardiologie));
//        //        System.out.println("test nbMedecin");
//        //        System.out.println(dm1.nbMedecin());
//        //        dm1.afficher();
//        //        System.out.println("\n" + "******" + "\n");
//        //        System.out.println("fiches intervalle d1 d2");
//        //        dm1.afficherFichesIntervalle(d1, d2);
//        //        System.out.println("\n" + "******" + "\n");
//        //        System.out.println("triées couts");
//        //        dm1.afficherFichesTrieesCouts();
//        //        System.out.println("\n" + "******" + "\n");
//        //        System.out.println("liste actes");
//        //        dm1.afficherListeActes(p1);
//        //        System.out.println("\n" + "******" + "\n");
//        //        System.out.println("liste medecins");
//        //        dm1.afficherListeMedecin();
//        //        System.out.println("\n" + "******" + "\n");
//        //        System.out.println("liste patients");
//        //        dm1.afficherListePatients();
//        //        System.out.println("\n" + "******" + "\n");
//        //        System.out.println("liste patients(medecin m)");
//        //        dm1.afficherListePatients(m1);
//        //        System.out.println("\n" + "******" + "\n");
//        //        System.out.println("patient p");
//        //        dm1.afficherPatient(p1);
//        //        System.out.println("\n" + "******" + "\n");
//        //        System.out.println("liste medecin (patient p)");
//        //        dm1.afficherListeMedecins(p1);
//        //     
//    InterfaceMedecin intmed=new InterfaceMedecin();
//        System.out.println(dm.afficherFichesIntervalleString( intmed.StringToDate("10/09/2005"),  intmed.StringToDate("18/06/2006")));
//        
//
//
//    }
//
//}
