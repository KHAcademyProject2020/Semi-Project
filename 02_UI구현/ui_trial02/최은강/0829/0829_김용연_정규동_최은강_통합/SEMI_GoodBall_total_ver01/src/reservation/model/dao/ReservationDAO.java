package reservation.model.dao;

import static common.JDBCTemplate.close;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import reservation.model.vo.PageInfo;
import reservation.model.vo.ReservationInfo;


public class ReservationDAO {
private Properties prop = null;
   
   public ReservationDAO() {
      prop = new Properties();
      String fileName = ReservationDAO.class.getResource("/sql/reservation/reservation-query.properties").getPath();
      
      try {
         prop.load(new FileReader(fileName));
      } catch (FileNotFoundException e) {
         e.printStackTrace();
      }catch (IOException e) {
         e.printStackTrace();
      }
   }

   public int getReservationCount(Connection conn, String userId) {
      PreparedStatement pstmt = null;
      ResultSet rset = null;
      int result = 0;
      
      String query = prop.getProperty("getReservationCount");
      
      try {
         pstmt = conn.prepareStatement(query);
         pstmt.setString(1, userId);
         rset = pstmt.executeQuery();
         
         if(rset.next()) {
            result = rset.getInt(1);
         }
         
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         close(rset);
         close(pstmt);         
      }
      
      return result;
   }

   public ArrayList<ReservationInfo> selectReservationList(Connection conn, String userId, PageInfo pi) {
      PreparedStatement pstmt = null;
      ResultSet rset = null;
      ArrayList<ReservationInfo> list = null;
      ReservationInfo r = null;
      
      String query = prop.getProperty("selectReservationList");

      int startRow = (pi.getCurrentPage() -1) * pi.getBoardLimit() + 1;
      int endRow = startRow + pi.getBoardLimit() - 1;
      try {
         pstmt = conn.prepareStatement(query);
         pstmt.setString(1, userId);
         pstmt.setInt(2, startRow);
         pstmt.setInt(3, endRow);
         rset = pstmt.executeQuery();
         
         list = new ArrayList<ReservationInfo>();
         while(rset.next()) {
            r = new ReservationInfo(
                           rset.getString("reservation_code"),
                           rset.getString("reservation_email"),
                           rset.getInt("reservation_stadium_num"),
                           rset.getInt("reservation_num"),
                           rset.getInt("reservation_price"),
                           rset.getInt("reservation_usage_start_time"),
                           rset.getInt("reservation_usage_time"),
                           rset.getInt("reservation_usage_end_time"),
                           rset.getDate("reservation_usage_start_date"),
                           rset.getString("reservation_status"),
                           rset.getInt("stadium_num"),
                           rset.getString("stadium_branch_num"),
                           rset.getString("stadium_name"),
                           rset.getString("stadium_match_member"),
                           rset.getInt("stadium_reservation_start_time"),
                           rset.getInt("stadium_reservation_end_time"),
                           rset.getString("stadium_delete_status"));
                              
            list.add(r);
         }
         
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         close(pstmt);
         close(rset);
      }
      
      return list;
   }
   

}