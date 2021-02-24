package ExameFinal;

public class TesteCarro {

    public static void main(String[] args)
    {
        Stand sv = new Stand();

        Integer opcao;

        do {

            System.out.print("Gestao de Vendas de Automóveis:\n1 - Adicionar um Automóvel\n2 - Eliminar Automóvel\n" +
                    "3 - Listar Marcas disponíveis para venda\n4 - Listar todas as vendas\n5 - Total de Vendas de um Automóvel\n6 - Listar veículos\n"+
            		"7 - Exportar lista de veículos\n8 - Importar lista veículos\n9 - Vender veículo\n10 - Gui\n11 - Sair\n");
            opcao= Menu.lerIntMsg("Escolha uma opção: ");

            switch (opcao)
            {
                case 1:

                    String tipo = Menu.lerStringMsg("Indique o tipo de veículo que pretende criar:\nLM - Ligeiro de Mercadorias\nLP - Ligeiro de Passageiros\nPM - Pesado de Mercadorias\nPP - Pesado de Passageiros");

                    if(! (tipo.equals("LM") || tipo.equals("LP") || tipo.equals("PM") || tipo.equals("PP"))) {
                    	System.out.println("Selecione um tipo de carro correto.");
                    	break;
                    }
                    
                    String matricula = Menu.lerStringMsg("Indique a matrícula do veículo:\n");

                    //se a matrícula já existir então não deixa introduzir o registo
                    if(sv.existeMatricula(matricula))
                    {
                        System.out.println("Matrícula já existe ! Impossível adicionar o veículo");
                        break;
                    }
                    
                    String marca = Menu.lerStringMsg("Indique a marca:\n");
                    String modelo = Menu.lerStringMsg("Indique o modelo:\n");
                    String cor = Menu.lerStringMsg("Indique a cor:\n");
                    Integer cilindrada = Menu.lerIntMsg("Indique a cilindrada:\n");
                    Integer ano = Menu.lerIntMsg("Indique o ano (veículo)\n");
                    double preco = Menu.lerDoubleMsg("Indique o preço:\n");
                    
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
                    
                    sv.adicionarVeiculo(cc);
                    System.out.println("VEÍCULO INSERIDO COM SUCESSO !!!!");

                    break;

                case 2:
                        String matRemove = Menu.lerStringMsg("Indique a matrícula do veículo:\n");
                        sv.eliminarCarro(matRemove);
                        System.out.println("Veículo removido com sucesso !");
                        
                    break;

                case 3:

                    sv.listarMarcas();
                    System.out.println("Marcas disponíveis para venda");
                    break;

                case 4:

                    sv.listarVendas();
                    break;

                case 5:

                    break;

                case 6:

                   String listaTipo = Menu.lerStringMsg("Escolha a categoria do veículo que pretende listar:\nLM - Ligeiros Mercadorias\nLP - Ligeiro de Passageiros\nPM - Pesado de Mercadorias\nPP - Pesado de Passageiros\nAA - Todos");

                   if(listaTipo.equals("AA")) {
                	   sv.listaCarrosAll();
                	   break;
                   }
                   
                   if(listaTipo.equals("LM") || listaTipo.equals("LP") || listaTipo.equals("PM") || listaTipo.equals("PP")) {
                	   sv.listaCarrosTipo(listaTipo);
                   } else {
                	   System.out.println("Tipo incorreto, selecione uma das opcoes");
                   }

                   break;

                case 7:

                    sv.exportCSV(sv.carros);
                    break;

                case 8:

                    sv.importCSV();
                    break;

                case 9:

                    sv.listaCarrosAll();

                    String matVenda = Menu.lerStringMsg("Indique a matrícula do veículo que quer efetuar a venda");
                    
                    //se a matrícula já existir então não continua a venda
                    if(!sv.existeMatricula(matVenda))
                    {
                        System.out.println("Matrícula nao existe ! Impossível efectuar a venda");
                        break;
                    }

                    double quantiaPagamento = Menu.lerDoubleMsg("Indique a quantia: ");
                    
                    sv.efetuarVenda(matVenda, quantiaPagamento);

                case 10:
                	
                    ExameFinal.JTableRow.start(sv);
                    break;

                case 11:
                	
                    System.out.println("Obrigado pela utilização. Até breve !");
                    System.exit(0);
                    break;
                    
                default:
                	
                    System.out.println("OPÇÃO INVÁLIDA");
                    break;

            }

        }while(opcao != 11);
    }
}
