package princetonPlainsboro;

import java.text.DateFormat;

class Acte {

    private Code code;
    private int coef;
    private String nomActe;
    private TypeActe typeActe;

    public Code getCode() {
        return code;
    }

    public int getCoef() {
        return coef;
    }

    public String getNomActe() {
        return nomActe;
    }

    public TypeActe getTypeActe() {
        return typeActe;
    }

    public String getCommentaire() {
        return commentaire;
    }
    private String commentaire;

    public enum TypeActe {

        diagnostique, therapeutique;
    };

    public Acte(Code code, int coef) {
        this.code = code;
        this.coef = coef;
    }

    public Acte(Code code, int coef, TypeActe typeActe, String nomActe, String commentaire) {
        this.code = code;
        this.coef = coef;
        this.commentaire = commentaire;
        this.typeActe = typeActe;
        this.nomActe = nomActe;
    }
    public Acte(Code code, int coef, TypeActe typeActe, String nomActe, Date date) {
        this.code = code;
        this.coef = coef;
        this.typeActe = typeActe;
        this.nomActe = nomActe;
    }

    public void setCode(Code code) {
        this.code = code;
    }

    public void setCoef(int coef) {
        this.coef = coef;
    }

    public void setNomActe(String nomActe) {
        this.nomActe = nomActe;
    }

    public void setTypeActe(TypeActe typeActe) {
        this.typeActe = typeActe;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }


    public String toString() {
        return code.toString() + ", coefficient : " + coef;
    }
    
    public String ficheActe(){
        String s="\n"+"********"+"Fiche de l'acte "+nomActe;
        s+="\n"+" - code: "+code.toString() + ", coefficient: " + coef;
        s+="\n"+" - type d'acte: "+typeActe;
        if (commentaire!=null){
            s+="\n"+" - commentaire: "+commentaire;
        }
        s+="\n"+"********"+ "\n";
        return s;
    }

    public double cout() {
        return code.calculerCout(coef);
    }
}
