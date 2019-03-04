package preverificadocenti;

public class Docente {

    private String cognome;
    private String giornoRicevimento;
    private String oraRicevimento;
    
    public Docente() {
        cognome="";
        giornoRicevimento="";
        oraRicevimento="";
        
    }

    public Docente(String cognome, String giornoRicevimento, String oraRicevimento ) {
        this.cognome=cognome;
        this.giornoRicevimento=giornoRicevimento;
        this.oraRicevimento=oraRicevimento;
    }

    public Docente(Docente docente) {
        this.cognome = docente.cognome;
        this.giornoRicevimento = docente.giornoRicevimento;
        this.oraRicevimento = docente.oraRicevimento;
    }

    public String getNome() {
        return cognome;
    }

    public void setNome(String cognome) {
        this.cognome = cognome;
    }

    public String getCognome() {
        return giornoRicevimento;
    }

    public void setCognome(String giornoRicevimento) {
        this.giornoRicevimento = giornoRicevimento;
    }

    public String getMateria() {
        return oraRicevimento;
    }

    public void setMateria(String oraRicevimento) {
        this.oraRicevimento = oraRicevimento;
    }
    

    @Override
    public String toString() {
        return "Docente{" + "cognome=" + cognome + ", giornoRicevimento=" + giornoRicevimento + ", oraRicevimento=" + oraRicevimento + '}';
    }


}
