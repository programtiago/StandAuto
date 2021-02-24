package ExameFinal;

public class PesadoMercadoria extends Pesado implements Mercadoria {


    public PesadoMercadoria(String cor, String marca, String modelo, String matricula, int cilindrada, int ano, double preco) {
        super(cor, marca, modelo, matricula, cilindrada, ano, preco);
    }

    @Override
    public String getTipo() {
        return "PM";
    }
}
