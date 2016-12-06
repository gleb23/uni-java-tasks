package edu.hlibbabii.points26.dao;

import edu.hlibbabii.points26.service.Point;
import org.apache.commons.dbcp.BasicDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.TreeSet;
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
        dataSource.setUrl("jdbc:mysql://localhost/points26");
        dataSource.setUsername("points26");
        dataSource.setPassword("points26");
    }

    public static synchronized Dao getInstance() {
        if (dao == null) {
            dao = new Dao();
        }
        return dao;
    }

    public Collection<Point> selectPoints() {
        Collection<Point> points = new TreeSet<>();
        Connection conn;
        PreparedStatement st;
        ResultSet rs;
        try {
            conn = dataSource.getConnection();
            st = conn.prepareStatement("Select * from points");
            rs = st.executeQuery();
            while (rs.next()) {
                points.add(new Point(rs.getInt(1), rs.getInt(2)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
        }
        return points;
    }
}
