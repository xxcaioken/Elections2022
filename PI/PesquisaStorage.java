import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PesquisaStorage {
    private static List<Pesquisa> pesquisas = new ArrayList<>();

    public List<Pesquisa> selectList() {
        Pesquisa p = new Pesquisa();
        try {
            Connection con = MysqlCon.getConexao();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from pesquisa_eleitoral");
            List<Pesquisa> lista;
            lista = new ArrayList<Pesquisa>();
            while (rs.next()) {
                p.setId(rs.getInt(1));
                p.setIdCandidato(rs.getInt(2));
                p.setData(rs.getString(3));
                p.setIntencaoDeVoto(rs.getInt(4));
                p.setFontePesquisa(rs.getString(5));
                lista.add(p);
            }
            System.out.println(lista);
            return lista;
        } catch (Exception e) {
            System.out.println(e);

        }
        return null;
    }

    public void insertList(Pesquisa p) {

        pesquisas.add(p);
        ResultSet resultSet = null;

        try {

            Connection con = MysqlCon.getConexao();

            PreparedStatement stmt = con.prepareStatement("insert into pesquisa_eleitoral(id_candidato,data_pesquisa,intencao_voto,Fonte_pesquisa)values(?,?,?,?,?)");
            stmt.setInt(2, p.getIdCandidato());
            stmt.setString(3, p.getData());
            stmt.setInt(4, p.getIntencaoDeVoto());
            stmt.setString(5, p.getFontePesquisa());
            stmt.execute();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {

                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();

            }
        }
    }

    public void updatetList(Pesquisa p) {
        try {

            Connection con = MysqlCon.getConexao();
            PreparedStatement stmt = con.prepareStatement("UPDATE pesquisa_eleitoral SET id_candidato = ?,data_pesquisa=?,intencao_voto=?,Fonte_pesquisa=? WHERE id = ?");
            stmt.setInt(1, p.getIdCandidato());
            stmt.setString(2, p.getData());
            stmt.setInt(3, p.getIntencaoDeVoto());
            stmt.setString(4,p.getFontePesquisa());
            stmt.setInt(5, p.getId());
            stmt.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }



    public void deleteList(String c) {
        for(Pesquisa pesquisa : pesquisas)
            if(String.valueOf(pesquisa.getId())== c)
                pesquisas.remove(pesquisa);
        try {
            Connection con = MysqlCon.getConexao();
            PreparedStatement stmt = con.prepareStatement("Delete from pesquisa_eleitoral WHERE id =" + c);
            stmt.execute();
        } catch (Exception e) {
            System.out.println(e);
        } 
    }
}
