package ua.hlibbabii.fileLists7.dao;


import org.apache.commons.dbcp.BasicDataSource;
import ua.hlibbabii.fileLists7.logic.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hlib Babii <hlib.babii at hlibbabii.ua>
 */
public class Dao {
    private static Dao dao = null;

    private BasicDataSource dataSource = null;

    protected Dao() {
        dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/file_list7");
        dataSource.setUsername("file_list7");
        dataSource.setPassword("file_list7");
    }

    public static synchronized Dao getInstance() {
        if (dao == null) {
            dao = new Dao();
        }
        return dao;
    }
    
    public boolean accountExists(Account account) {
        Connection conn;
        PreparedStatement st;
        ResultSet rs;
        try {
            conn = dataSource.getConnection();
            st = conn.prepareStatement
                    ("Select * from accounts");
            //st.setString(1, account.getUsername());
            rs = st.executeQuery();
            if (rs.next()) {
                if (rs.getString(2).equals(account.getPassword())) {
                    return true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnection();
        }
        return false;
    }
    
    public List<String> getFileName(String username) {
        Connection conn;
        PreparedStatement st;
        ResultSet rs;
        List<String> list = new ArrayList<>();
        try {
            conn = dataSource.getConnection();
            st = conn.prepareStatement
                    ("Select files.fileName from files where files.username= ?");
            st.setString(1, username);
            rs = st.executeQuery();
            while (rs.next()) {
                list.add(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnection();
        }
        return list;
    }

    private void closeConnection() {
        try {
            dataSource.close();
        } catch (SQLException ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, "Error when closing connection", ex);
        }
    }
    
}
