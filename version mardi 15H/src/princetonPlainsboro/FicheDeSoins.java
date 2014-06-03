package princetonPlainsboro;

import java.util.Vector;
import javax.swing.DefaultListModel;

class FicheDeSoins {
    private Patient patient;
    private Medecin medecin;
    private Date date;
    private Vector<Acte> actes;       // contient des objets de classe 'Acte'
    
    public FicheDeSoins(Patient patient, Medecin medecin, Date date) {
        this.patient = patient;
        this.medecin = medecin;
        this.date = date;
        actes = new Vector<Acte>();   // liste vide
      }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public void setMedecin(Medecin medecin) {
        this.medecin = medecin;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    

    public void setActes(Vector<Acte> actes) {
        this.actes = actes;
    }
       
    public Patient getPatient() { 
        return patient; 
    }
    
    public Medecin getMedecin() {
        return medecin; 
    }
    
    public Date    getDate()    {
        return date; 
    }
    
    public Vector<Acte> getActes() {
        return actes;
    }
    
    public void ajouterActe(Acte acte) {
        actes.add(acte);
        }
    
    public void ajouterActe(Code code, int coefficient) {
        Acte acte = new Acte(code, coefficient);
        actes.add(acte);
        }

    
    
    
    public void afficher() {
        System.out.println("Fiche de soins du " + date.toString());
        System.out.println("- medecin : " + medecin.toString());
        System.out.println("- patient : " + patient.fichePatient());
        System.out.println("- actes medicaux :");
        if(!actes.isEmpty()){
        for (int i=0; i<actes.size(); i++) {
            Acte a = actes.get(i);
            System.out.println("    > " + a.toString());
            }
        System.out.println("- Cout total: "+this.coutTotal()+ " €");
        }}
    
    public double coutTotal() {
        double total = 0;
        for (int i=0; i<actes.size(); i++) {
            Acte a = actes.get(i);
            total += a.cout();
            }
        return total;
        }
    
     public String afficherString() {
           System.out.println("afficherString f");
       String s= "Fiche de soins du " + date.toString();
       s+="\n"+"- medecin : " + medecin.toString();
        s+="\n"+"- patient : " + patient.fichePatient();
       if (!actes.isEmpty()){
           System.out.println("boucle");
        s+="\n"+"- actes medicaux :";
        for (int i=0; i<actes.size(); i++) {
            Acte a = actes.get(i);
             s+="\n"+"    > " + a.toString();
            }
         s+="\n"+"- Cout total: "+this.coutTotal()+ " €";
       }else{
           System.out.println("je suis vide");
           s+="\n"+"- Cout total: 0 €";
       }
        return s;
        }
    }

