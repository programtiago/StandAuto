package ExameFinal;

public abstract class Carro {

    private String cor;
    private String marca;
    private String modelo;
    private String matricula;
    private int cilindrada;
    private int ano;
    private double preco;
    public abstract double getValorImposto();
    public abstract String getTipo();


    public Carro(String cor, String marca, String modelo, String matricula, int cilindrada, int ano, double preco) {
        this.cor = cor;
        this.marca = marca;
        this.modelo = modelo;
        this.matricula = matricula;
        this.cilindrada = cilindrada;
        this.ano = ano;
        this.preco = preco;

    }


    public String getCor() {
        return cor;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMatricula() {
        return matricula;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public int getAno() {
        return ano;
    }

    public double getPreco() {
        return preco;
    }

    public String toString() {

        return getTipo() + ": " + matricula + ", " + marca + ", " + modelo + ", " + ano + ", " + cor + ", " + cilindrada + ", " + preco;
    }

    public void imprimeDetalhes() {

        System.out.println(toString());
    }
}
