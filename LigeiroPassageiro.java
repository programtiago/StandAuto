package ExameFinal;

public class LigeiroPassageiro extends Ligeiro implements Passageiro {

    public LigeiroPassageiro(String cor, String marca, String modelo, String matricula, int cilindrada, int ano, double preco) {
        super(cor, marca, modelo, matricula, cilindrada, ano, preco);
    }

    @Override
    public String getTipo() {
        return "LP";
    }

}
