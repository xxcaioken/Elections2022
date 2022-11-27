import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class CandidatoTable {
    private JTable tabela;
    private CandidatoTableModel tableModel;
    private JButton btnCriar;
    private JButton btnEditar;
    private JButton btnRemover;

    public CandidatoTable(){
        criarTabelaPanel();
        criarComandosPanel();
    }
    private void criarComandosPanel() {
        JPanel panel = new JPanel();
        FlowLayout layout = (FlowLayout) panel.getLayout();
        layout.setAlignment(FlowLayout.RIGHT);

        criarBtnCriar();
        panel.add(btnCriar);

        criarBtnEditar();
        panel.add(btnEditar);

        criarBtnRemover();
        panel.add(btnRemover);

        add(panel, BorderLayout.NORTH);

        desabilitarBtns();
    }
    private void criarTabelaPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        tableModel = new CandidatoTableModel(CandidatoStorage.selectList());
        tabela = new JTable(tableModel);
        tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabela.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    if (tabela.getSelectedRow() >= 0) {
                        habilitarBtns();
                    } else {
                        desabilitarBtns();
                    }
                }
            }
        });
        JScrollPane scrollPane = new JScrollPane(tabela);
        panel.add(scrollPane);

        panel.add(panel, BorderLayout.CENTER);
    }
    private void habilitarBtns() {
        btnEditar.setEnabled(true);
        btnRemover.setEnabled(true);
    }

    private void desabilitarBtns() {
        btnEditar.setEnabled(false);
        btnRemover.setEnabled(false);
    }

}
