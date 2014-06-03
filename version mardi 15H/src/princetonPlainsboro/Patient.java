package princetonPlainsboro;

import static java.lang.String.valueOf;
import javax.swing.DefaultListModel;

class Patient {

    private String nom;
    private String prenom;
    private String adresse;
    private Long numSecu;
    private Date dateDeNaissance;
    private int cle;

    

    public String getNom() {
        return nom;
    }

    public void setNumSecu(Long numSecu) {
        if (cle == 97 - numSecu % 97) {
          this.numSecu = numSecu;
        } else {
         this.numSecu=null;
       }
    }
    

    public String getPrenom() {
        return prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public Long getNumSecu() {
        return numSecu;
    }

    public int getCle() {
        return cle;
    }
    
    

    public Date getDateDeNaissance() {
        return dateDeNaissance;
    }

   /*public Patient(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }*/

    public Patient(String nom, String prenom, Long numSecu, int cle,Date dateDeNaissance, String adresse) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.dateDeNaissance = dateDeNaissance;
        this.cle=cle;
       if (cle == 97 - numSecu % 97) {
          this.numSecu = numSecu;
        } else {
           this.numSecu=null;
       }

    }

    public String toString() {
        String s = prenom + " " + nom ;
        return s;

    }

    public String fichePatient() {
        String s = prenom + " " + nom;
        s += "\n" + "numéro de sécurité sociale: " + valueOf(numSecu);
        s += "\n" + "date de naissance: " + dateDeNaissance;
        s += "\n" + "adresse: " + adresse;
        return s;
    }

    public boolean equals(Object o) {
        if (o instanceof Patient) {
            Patient p = (Patient) o;
            return nom.equals(p.nom) && prenom.equals(p.prenom);
        } else {
            return false;
        }
    }

}
