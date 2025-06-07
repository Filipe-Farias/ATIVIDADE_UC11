/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */

import java.awt.List;
import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;


public class ProdutosDAO {
    
    Connection conn;
    PreparedStatement prep;
    ResultSet resultset;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();
    
    public void cadastrarProduto (ProdutosDTO produto){
        
        
        //conn = new conectaDAO().connectDB();
        
        String sql = "INSERT INTO produtos (nome, valor) VALUES (?, ?)";

    try (Connection conn = new conectaDAO().connectDB();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, produto.getNome());
        stmt.setDouble(2, produto.getValor());

        stmt.executeUpdate();

    } catch (SQLException e) {
        throw new RuntimeException("Erro ao inserir produto no banco: ");
    }
        
    }
    
    public void venderProduto(int id) {
    String sql = "UPDATE produtos SET status = 'Vendido' WHERE id = ?";

    try (Connection conn = new conectaDAO().connectDB();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setInt(1, id);
        stmt.executeUpdate();

    } catch (SQLException e) {
        throw new RuntimeException("Erro ao marcar produto como vendido: " + e.getMessage(), e);
    }
}
    
    public List<ProdutosDTO> listarProdutosVendidos() {
    List<ProdutosDTO> lista = new ArrayList<>();
    String sql = "SELECT * FROM produtos WHERE status = 'Vendido'";

    try (Connection conn = new conectaDAO().connectDB();
         PreparedStatement stmt = conn.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {
            ProdutosDTO produto = new ProdutosDTO();
            produto.setId(rs.getInt("id"));
            produto.setNome(rs.getString("nome"));
            produto.setValor(rs.getDouble("valor"));
            lista.add(produto);
        }

    } catch (SQLException e) {
        throw new RuntimeException("Erro ao listar produtos vendidos: " + e.getMessage(), e);
    }

    return lista;
}


    
    public ArrayList<ProdutosDTO> listarProdutos(){
        
        return listagem;
    }
    
    
    
        
}

