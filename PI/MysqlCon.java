import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

class MysqlCon {
    
    public List<Pesquisa> conectaPesquisa(String query) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pi", "root",
                    "dev1");

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            Pesquisa p = new Pesquisa();
            List<Pesquisa> lista;
            lista = new ArrayList<Pesquisa>();
            while (rs.next()) {
                p.addParaLista(rs.getInt(1), rs.getInt(2), rs.getString(3));
                lista.add(p);
            }
            con.close();
            return lista;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}