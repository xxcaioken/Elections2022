import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListModel;

public class Desempenho extends javax.swing.JFrame {

    private JButton jButton1;
    private JButton jButton2;
    private JLabel jLabel1;
    private JList listaDeDesempenho;

    public Desempenho() {
        initComponents();
    }

    private void initComponents() {
        //private List<Pesquisa> oi = this.lista();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        listaDeDesempenho = new JList<>();
        jButton1 = new javax.swing.JButton();
        jButton2.setText("jButton2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jLabel1.setText("Desempenho das Pesquisas");

        jButton1.setText("Voltar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        listaDeDesempenho.setSelectedIndex(2);
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(40, 40, 40)
                                                .addComponent(listaDeDesempenho))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(40, 40, 40)
                                                .addComponent(jLabel1))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(24, 24, 24)
                                                .addComponent(jButton1)))
                                .addContainerGap(178, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jLabel1)
                                .addGap(24, 24, 24)
                                .addComponent(listaDeDesempenho)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 203,
                                        Short.MAX_VALUE)
                                .addComponent(jButton1)
                                .addGap(40, 40, 40)));
                                
                                

        pack();

    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
        Inicio inicio = new Inicio();

        inicio.setDefaultCloseOperation(Inicio.DISPOSE_ON_CLOSE);
        inicio.setVisible(true);

    }
    // private  List<Pesquisa> lista(){
    //     List<Pesquisa> s;
    //     s = new ArrayList<Pesquisa>();
    //     for (Pesquisa p : new CandidatoStorage().selectList()) {
    //         s.add(p);
    //     }
    //         return s;
    // }
   
    // public static void main(String args[]) {
    //     java.awt.EventQueue.invokeLater(new Runnable() {
    //         public void run() {
    //             new Desempenho().setVisible(true);
    //         }
    //     });
    // }

}
