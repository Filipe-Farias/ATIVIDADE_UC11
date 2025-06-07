import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class vendasVIEW extends JFrame {

    private JTable tabelaVendas;
    private DefaultTableModel modeloTabela;

    public vendasVIEW() {
        setTitle("Produtos Vendidos");
        setSize(500, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Configurar tabela
        modeloTabela = new DefaultTableModel();
        modeloTabela.addColumn("ID");
        modeloTabela.addColumn("Nome");
        modeloTabela.addColumn("Valor");

        tabelaVendas = new JTable(modeloTabela);
        JScrollPane scrollPane = new JScrollPane(tabelaVendas);
        add(scrollPane, BorderLayout.CENTER);

        // Botão fechar
        JButton btnFechar = new JButton("Fechar");
        btnFechar.addActionListener(e -> dispose());
        add(btnFechar, BorderLayout.SOUTH);

        // Carregar dados
        listarProdutosVendidos();
    }

    private void listarProdutosVendidos() {
        modeloTabela.setRowCount(0); // Limpa a tabela
        ProdutosDAO dao = new ProdutosDAO();
        List<ProdutosDTO> vendidos = dao.listarProdutosVendidos();

        for (ProdutosDTO p : vendidos) {
            modeloTabela.addRow(new Object[]{
                p.getId(),
                p.getNome(),
                p.getValor()
            });
        }
    }

    // Método main para teste isolado (opcional)
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new vendasVIEW().setVisible(true));
    }
}
