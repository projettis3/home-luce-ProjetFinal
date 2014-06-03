package princetonPlainsboro;

// Cette enumeration fait intervenir des valeurs qui possedent des
// attributs ('libelle' et 'cout') qui sont initialises par un appel du
// constructeur (arguments entre parentheses apres le nom de chaque valeur).
// Par exemple, la valeur Code.FP a un attribut 'libelle' contenant la chaine
// de caracteres "forfait pediatrique" et un attribut 'cout' ayant la valeur 5.0

enum Code {
    // valeurs de l'enum :
    AIS("actes infirmiers de soins",0.0),
    AMS("reeducation", 0.0),
    AMK("actes masseur-kinesitherapeute cabinet", 0.0),
    AMC("actes masseur-kinesitherapeute etablissement", 0.0),
    AMI("actes infirmiers",0.0),
    AMO("actes par orthophoniste",0.0),
    AMP("actes par le pedicure",0.0),
    AMY("actes par l'orthoptiste",0.0),
    C("consultation au cabinet generaliste",0.0),
    CS("consultation au cabinet specialiste", 23.0),    
    CSC("consultation cardiologie", 45.73),
    CNPSY("consultation neuropsychiatrie", 0.0),
    CDE("consultation depistage de melanome", 0.0),
    D("autres actes d'orthopedie dento-faciale", 0.0),
    DI("demarche des soind infirmiers",0.0),
    FP("forfait pediatrique", 5.0),
    KC("actes de chirurgie et de specialite", 2.09),
    KE("actes d'echographie, de doppler", 1.89),
    KMB("prelvement ponction veineuse", 0.0),
    K("autres actes de specialite", 1.92),
    KFA("forfait A", 30.49),
    KFB("forfait B", 60.98),
    ORT("orthodontie", 2.15),
    POD("actes de prevention",0.0),
    PRO("prothese dentaire", 2.15),
    SC("soins conservateur chirurgien-dentiste", 0.0),
    SCM("soins conservateur", 0.0),
    SF("actes autres sage femme", 0.0),
    SFI("soins infirmiers par sage femme", 0.0),
    SP("suivi postnatal", 0.0),
    SPR("prothese dentaire chirurgien-dentiste", 0.0),
    TO("orthopedie dento-faciale", 0.0),
    V("visite au domicile", 0.0),
    VAC("vaccin grippal",0.0),
    VL("visite au domicile complexe", 0.0),
    VS("visite au domicile specialiste", 0.0),
    VNPSY("visite au domicile neuropsychiatre", 0.0),
    Z("radiations ionisantes", 0.0),
    ;
                             
    // attributs de l'enum :
    private String libelle;
    private double cout;
    
    // constructeur :
    private Code(String libelle, double cout) {
        this.libelle = libelle;
        this.cout = cout;
        }
    
    // m�thodes :
    public String toString() {
        return super.toString() + " : " + libelle + ", cout=" + cout + " euros";
        }
    
    // calcule le prix pour un coefficient donne :
    public double calculerCout(int coefficient) {
        return coefficient * cout;
        }
    }
