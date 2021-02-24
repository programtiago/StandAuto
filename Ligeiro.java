package ExameFinal;

public abstract class Ligeiro extends Carro{

    @Override
    public double getValorImposto() {
        return 0;
    }

    public Ligeiro(String cor, String marca, String modelo, String matricula, int cilindrada, int ano, double preco) {
        super(cor, marca, modelo, matricula, cilindrada, ano, preco);
    }
}
