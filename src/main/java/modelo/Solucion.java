package modelo;

public class Solucion {

    private String textoBD;
    private String textoSolucion;
    private String solucionOculta;
    private String categoria;
    private String[] respuesta = {textoBD , categoria};

    public Solucion(String[] respuesta) {
        this.textoBD = respuesta[0];
        setTextoSolucion(this.textoBD);
        setSolucionOculta(this.textoBD.toUpperCase());
        this.categoria = respuesta[1];
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getTextoBD() {
        return textoBD;
    }

    public String getTextoSolucion() {
        return textoSolucion;
    }

    public String getSolucionOculta() {
        return solucionOculta;
    }

    public void setTextoSolucion(String textoBD) {
        this.textoSolucion = textoBD.toUpperCase();
    }

    public void setSolucionOculta(String textoSolucion) {
        this.solucionOculta = "";
        for (int i = 0; i < textoSolucion.length(); i++) {
            char c = textoSolucion.charAt(i);
            if((c > 64) && (c < 91)){
                solucionOculta += "_";
            } else {
                solucionOculta += c;
            }
        }
    }
    public void actualizarSolucionOculta(String texto){
        this.solucionOculta = texto;
    }

    @Override
    public String toString() {
        return "Solucion{" +
                "textoBD='" + textoBD + '\'' +
                ", textoSolucion='" + textoSolucion + '\'' +
                ", solucionOculta='" + solucionOculta + '\'' +
                ", categoria='" + categoria + '\'' +
                '}';
    }
}
