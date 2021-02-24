package ExameFinal;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Venda {

    String matricula;
    double precoVenda;
    Date dataVenda;
    Carro veiculo;

    public Venda(String matricula, double precoVenda, Date dataVenda, Carro veiculo) {
        this.matricula = matricula;
        this.precoVenda = precoVenda;
        this.dataVenda = dataVenda;
        this.veiculo = veiculo;
    }

    public String getMatricula() {
        return matricula;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }


    public void setPrecoVenda(double precoVenda) {
        this.precoVenda = precoVenda;
    }
    
    public String toString() {

    	DateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
    	return veiculo + " : " + precoVenda + ", " + formatoData.format(dataVenda);
    }

}
