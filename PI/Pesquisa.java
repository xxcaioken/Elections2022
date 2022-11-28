
public class Pesquisa {
    private int idDaPesquisa;
    private String data;
    private int idCandidato;
    private int intencaoDeVoto;
    private String fontePesquisa;


    public String getFontePesquisa() {
        return fontePesquisa;
    }

    public void setFontePesquisa(String fontePesquisa) {
        this.fontePesquisa = fontePesquisa;
    }

    public int getIntencaoDeVoto() {
        return intencaoDeVoto;
    }

    public void setIntencaoDeVoto(int intencaoDeVoto) {
        this.intencaoDeVoto = intencaoDeVoto;
    }

    public int getIdCandidato() {
        return idCandidato;
    }

    public void setIdCandidato(int idCandidato) {
        this.idCandidato = idCandidato;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getId() {
        return idDaPesquisa;
    }

    public void setId(int id) {
        this.idDaPesquisa = id;
    }

    public Pesquisa get(int rowIdx) {
        return null;
    }

}
