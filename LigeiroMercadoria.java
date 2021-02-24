package ExameFinal;

public class LigeiroMercadoria extends Ligeiro implements Mercadoria {

    public LigeiroMercadoria(String cor, String marca, String modelo, String matricula, int cilindrada, int ano, double preco) {
        super(cor, marca, modelo, matricula, cilindrada, ano, preco);
    }

    @Override
    public String getTipo() {
        return "LM";
    }


}
