package reservation.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import reservation.model.dao.ReservationDAO;
import reservation.model.vo.PageInfo;
import reservation.model.vo.ReservationInfo;



public class ReservationService {

   public int getReservationCount(String userId) {
      Connection conn = getConnection();
      
      int result = new ReservationDAO().getReservationCount(conn, userId);
      
      close(conn);
      
      return result;
   }

   public ArrayList<ReservationInfo> selectReservationList(String userId, PageInfo pi) {
      Connection conn = getConnection();
      
      ArrayList<ReservationInfo> list = new ReservationDAO().selectReservationList(conn, userId, pi);
      
      close(conn);
      
      return list;
   }

}