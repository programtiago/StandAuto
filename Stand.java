package ExameFinal;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.StringTokenizer;

public class Stand {

	ArrayList <Carro> carros = new ArrayList<>();
    ArrayList <Venda> vendas = new ArrayList<>();

    public void adicionarVeiculo(Carro lp)
    {
        carros.add(lp);
    }
    
    public void listaCarrosAll()
    {
        for (Carro carro : carros)
        {
        	carro.imprimeDetalhes();
        }
    }

    public void listaCarrosTipo(String tipo)
    {
        for (Carro carro : carros)
        {
        	if(carro.getTipo().equals(tipo))
        		carro.imprimeDetalhes();
        }
    }
    
    public void eliminarCarro(String matricula)
    {
        for (Carro carro : carros)
        {
            if (carro.getMatricula().equals(matricula))
            {
                carros.remove(carro);
                return;
            }
        }
    }

    public void listarMarcas()
    {
        for (Carro carro : carros)
        {
            System.out.println(carro.getMarca()+", ");
        }
    }
    
    public Carro getCarro(String matr) {
    	Carro car = null;
    	
    	for (Carro carro : carros)
        {
            if (carro.getMatricula().equals(matr))
            {
                car = carro;
                break;
            } 
        }
    	
    	return car;
    }

    public boolean existeMatricula(String matr)
    {     
        return getCarro(matr) != null;
    }

    public void efetuarVenda(String matr, double quantiaPagamento)
    {
        boolean vendido = false;


            if (quantiaPagamento <= 0)
            {
                System.out.println("Pagamento efetuado com sucesso");
                vendido = true;

            }
            
            Venda vendaVeiculo  = new Venda(matr, quantiaPagamento, new Date(), getCarro(matr));            
            vendas.add(vendaVeiculo);
            eliminarCarro(matr);

    }

    public void listarVendas()
    {
        for (Venda v : vendas)
        {
            System.out.println(v);
        }
    }

    public void importCSV()
    {
        String csvFile= "C:\\Users\\tiago\\IdeaProjects\\POO 2020\\src\\ExameFinal\\veiculos.csv";

        BufferedReader contentCSV = null;

        String line = "";

        String csvSeparator = ";";
        
        carros.clear();

        try
        {
            contentCSV = new BufferedReader(new FileReader(csvFile));

            while ((line = contentCSV.readLine()) != null)
            {
            	StringTokenizer st = new StringTokenizer(line,csvSeparator);  
            	int ntk = st.countTokens();
            	if(ntk!=8) return; // Erro no ficheiro csv
            	String tipo = st.nextToken();
            	String matricula = st.nextToken();
            	String marca = st.nextToken();
            	String modelo = st.nextToken();
            	String cor = st.nextToken();
            	int cilindrada =Integer.parseInt(st.nextToken());
            	int ano = Integer.parseInt(st.nextToken());
            	Double preco = Double.parseDouble(st.nextToken());
            	
            	Carro cc = null;

                if (tipo.equals("LM"))
                {
                    cc = new LigeiroMercadoria(cor,marca,modelo,matricula,cilindrada,ano,preco);
                }

                if (tipo.equals("LP"))
                {
                    cc = new LigeiroPassageiro(cor,marca,modelo,matricula,cilindrada,ano,preco);
                }

                if (tipo.equals("PM"))
                {
                    cc = new PesadoMercadoria(cor,marca,modelo,matricula,cilindrada,ano,preco);
                }

                if (tipo.equals("PP"))
                {
                    cc = new PesadoPassageiro(cor,marca,modelo,matricula,cilindrada,ano,preco);
                }
                
                adicionarVeiculo(cc);


            }
        }catch (FileNotFoundException e){
            System.out.println("Arquivo não encontrado: \n" +e.getMessage());
        }catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println("IndexOutOfBounds: \n" +e.getMessage());
        }catch (IOException e){
            System.out.println("IO Erro: \n" +e.getMessage());
        }finally{
            if (contentCSV != null)
                try{
                        contentCSV.close();
                }catch(IOException e){
                    System.out.println("IO Erro: \n" +e.getMessage());
                }
        }

    }

    public void exportCSV(ArrayList<Carro> carros)
    {
        String csvSeparator = ";";
        try
        {
            FileWriter stream = new FileWriter("C:\\Users\\tiago\\IdeaProjects\\POO 2020\\src\\ExameFinal\\veiculos.csv"); 

            for (Carro c : carros)
            {
                stream.append(c.getTipo() + csvSeparator + c.getMatricula() + csvSeparator + c.getMarca() + csvSeparator + c.getModelo() + csvSeparator + c.getCor() + csvSeparator + c.getCilindrada() + csvSeparator + c.getAno() + csvSeparator + c.getPreco());
                stream.append("\n");
            }
            stream.close();
        }

        catch (Exception e)
        {
            System.err.println("Erro: " + e);
        }
    }

}
