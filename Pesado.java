package ExameFinal;

public abstract class Pesado extends Carro {

    private int neixos; // getters setters

    @Override
    public double getValorImposto() {
        return 0;
    }

    public Pesado(String cor, String marca, String modelo, String matricula, int cilindrada, int ano, double preco) {
        super(cor, marca, modelo, matricula, cilindrada, ano, preco);
    }
}
