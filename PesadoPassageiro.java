package ExameFinal;

public class PesadoPassageiro extends Pesado implements Passageiro {

    public PesadoPassageiro(String cor, String marca, String modelo, String matricula, int cilindrada, int ano, double preco) {
        super(cor, marca, modelo, matricula, cilindrada, ano, preco);
    }

    @Override
    public String getTipo() {
        return "PP";
    }
}
