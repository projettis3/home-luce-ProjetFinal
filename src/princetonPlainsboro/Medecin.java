package princetonPlainsboro;

class Medecin {
    private String nom;
    private String prenom;
    private Enum specialite;
    private String numTel;
    private String motDePasse;
    
    public Medecin(String nom, String prenom, Specialite specialite) {
        this.nom = nom;
        this.prenom = prenom;
        this.specialite = specialite;
        }
    
     public Medecin(String nom, String prenom, Specialite specialite,String numTel,String motDePasse) {
        this.nom = nom;
        this.prenom = prenom;
        this.specialite = specialite;
        this.numTel=numTel;
        this.motDePasse=motDePasse;
        }
    
    public Enum getSpecialite() { return specialite; }
    
    public String toString() {
        return "Dr " + prenom + " " + nom + " , " + specialite + " , " + numTel + " , " + motDePasse ;
        }
    public String ficheMedecin(){
        String s= "Dr " + prenom + " " + nom + ", " + specialite;
        s+="\n"+"numéro de téléphone: "+numTel;
        return s;
    }
    
    public boolean equals(Object o) {
        if (o instanceof Medecin) {
            Medecin p = (Medecin)o;
            return nom.equals(p.nom) && prenom.equals(p.prenom);
            }
        else
            return false;
        }    

    public String getPrenom() {
        return prenom;
    }

    public String getNumTel() {
        return numTel;
    }

    public String getNom() {
        return nom;
    }

    public String getMotDePasse() {
        return motDePasse;
    }
    }


