package ExameFinal;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JTableRow {

	public static Stand std=null;
    public static void start(Stand st){
        
    	std = st;
        // create JFrame and JTable
        JFrame frame = new JFrame();
        JTable table = new JTable(); 
        
        // create a table model and set a Column Identifiers to this model 
        Object[] columns = {"Tipo","Matrícula","Marca","Modelo","Cor","Cilindrada","Ano","Preço"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);
        
        // set the model to the table
        table.setModel(model);
        
        // Change A JTable Background Color, Font Size, Font Color, Row Height
        table.setBackground(Color.LIGHT_GRAY);
        table.setForeground(Color.black);
        Font font = new Font("",1,22);
        table.setFont(font);
        table.setRowHeight(30);
        
        // create JTextFields
        JTextField textTipo = new JTextField();
        JTextField textMatricula = new JTextField();
        JTextField textMarca = new JTextField();
        JTextField textModelo = new JTextField();
        JTextField textCor = new JTextField();
        JTextField textPreco = new JTextField();
        JTextField textCilindrada = new JTextField();
        JTextField textAno = new JTextField();

        JLabel etiqTipo, etiqMatricula, etiqMarca, etiqModelo, etiqPreco, etiqAno, etiqCor, etiqCilindrada;

        etiqTipo = new JLabel("Tipo: ");
        etiqTipo.setBounds(20, 220, 65, 25 );
        etiqMatricula = new JLabel("Matrícula: ");
        etiqMatricula.setBounds(20, 250, 65, 25 );
        etiqMarca = new JLabel("Marca: ");
        etiqMarca.setBounds(20, 280, 65, 25 );
        etiqModelo = new JLabel("Modelo: ");
        etiqModelo.setBounds(20, 310, 65, 25 );
        etiqCor = new JLabel("Cor: ");
        etiqCor.setBounds(20, 340, 65,25);
        etiqCilindrada = new JLabel("Cilindrada: ");
        etiqCilindrada.setBounds(20,370,65,25);
        etiqAno = new JLabel("Ano: ");
        etiqAno.setBounds(20, 400, 65, 25);
        etiqPreco = new JLabel("Preco: ");
        etiqPreco.setBounds(20, 430, 65, 25 );

        frame.add(etiqTipo);
        frame.add(etiqMatricula);
        frame.add(etiqMarca);
        frame.add(etiqModelo);
        frame.add(etiqCor);
        frame.add(etiqCilindrada);
        frame.add(etiqAno);
        frame.add(etiqPreco);
        
        // create JButtons
        JButton btnAdicionar = new JButton("Adicionar");
        JButton btnApagar = new JButton("Apagar");
        JButton btnVender = new JButton("Vender veículo");
        
        textTipo.setBounds(100, 220, 100, 25);
        textMatricula.setBounds(100, 250, 100, 25);
        textMarca.setBounds(100, 280, 100, 25);
        textModelo.setBounds(100, 310, 100, 25);
        textCor.setBounds(100, 340, 100, 25);
        textCilindrada.setBounds(100, 370, 50, 25);
        textAno.setBounds(100, 400, 50,25);
        textPreco.setBounds(100, 430, 100, 25);
        
        btnAdicionar.setBounds(205, 220, 150, 25);
        btnVender.setBounds(205, 265, 150, 25);
        btnApagar.setBounds(205, 310, 150, 25);
        
        // create JScrollPane
        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(0, 0, 880, 200);
        
        frame.setLayout(null);
        
        frame.add(pane);
        
        // add JTextFields to the jframe
        frame.add(textTipo);
        frame.add(textMatricula);
        frame.add(textMarca);
        frame.add(textModelo);
        frame.add(textCor);
        frame.add(textCilindrada);
        frame.add(textAno);
        frame.add(textPreco);
    
        // add JButtons to the jframe
        frame.add(btnAdicionar);
        frame.add(btnApagar);
        frame.add(btnVender);
        
        // create an array of objects to set the row data
        Object[] row = new Object[8];
        
        // Ler carros do Stand
        	  for (Carro carro : std.carros)
              {
                  row[0] = carro.getTipo();
                  row[1] = carro.getMatricula();
                  row[2] = carro.getMarca();
                  row[3] = carro.getModelo();
                  row[4] = carro.getCor();
                  row[5] = Integer.toString(carro.getCilindrada());
                  row[6] = Integer.toString(carro.getAno());
                  row[7] = Double.toString(carro.getPreco());
           
                  // add row to the model
                  model.addRow(row);      // Adiciona na interface grafica
              }
        
        // button add row
        btnAdicionar.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {

                Stand sv = std;

                String tipo = textTipo.getText();
                String matricula = textMatricula.getText();
                String marca = textMarca.getText();
                String modelo = textModelo.getText();
                String cor = textCor.getText();
                int cilindrada = Integer.parseInt(textCilindrada.getText());
                int ano = Integer.parseInt(textAno.getText());
                double preco = Double.parseDouble(textPreco.getText());
                
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
                
                sv.adicionarVeiculo(cc);  // Adiciona no Stand

                row[0] = textTipo.getText();
                row[1] = textMatricula.getText();
                row[2] = textMarca.getText();;
                row[3] = textModelo.getText();
                row[4] = textCor.getText();
                row[5] = textCilindrada.getText();
                row[6] = textAno.getText();
                row[7] = textPreco.getText();
         
                // add row to the model
                model.addRow(row);      // Adiciona na interface grafica
            }
        });
        
        // button remove row
        btnApagar.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
            
                // i = the index of the selected row
                int i = table.getSelectedRow();
                if(i >= 0){
                    // remove a row from jtable
                    model.removeRow(i);
                }
                else{
                    System.out.println("Delete Error");
                }
            }
        });
        
        // get selected row data From table to textfields 
        table.addMouseListener(new MouseAdapter(){
        
        @Override
        public void mouseClicked(MouseEvent e){
            
            // i = the index of the selected row
            int i = table.getSelectedRow();
            
            textTipo.setText(model.getValueAt(i, 0).toString());
            textMatricula.setText(model.getValueAt(i, 1).toString());
            textMarca.setText(model.getValueAt(i, 2).toString());
            textModelo.setText(model.getValueAt(i, 3).toString());
            textCor.setText(model.getValueAt(i, 4).toString());
            textCilindrada.setText(model.getValueAt(i, 5).toString());
            textAno.setText(model.getValueAt(i, 6).toString());
            textPreco.setText(model.getValueAt(i, 7).toString());
        }
        });
        
        // button update row
        btnVender.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	System.out.println("Venda em modo Gui a desenvolver futuramente. Apenas disponivel na interface texto.");

            }
        });
        
        frame.setSize(900,560);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(/*JFrame.EXIT_ON_CLOSE*/JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        
    }
}