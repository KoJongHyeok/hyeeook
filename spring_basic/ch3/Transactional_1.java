package com.fastcampus.ch3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// ************************** TransactionManager를 수동으로 주입해서 처리하는 코드 **************************

@Repository     // Dao에 붙이는 애너테이션
public class A1Dao {

    @Autowired
    DataSource ds;

//    public int insert(int key, int value) throws Exception {   // 하나의 Transaction으로 묶어주기 이전의 코드.
//        Connection conn = null;
//        PreparedStatement pstmt = null;
//
//        try {
//            conn = ds.getConnection();
//            pstmt = conn.prepareStatement("insert into a1 values(?, ?)");
//            pstmt.setInt(1, key);
//            pstmt.setInt(2, value);
//
//            return pstmt.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            close(conn, pstmt);
//        }
//        return 0;
//    }

    public int insert(int key, int value) throws Exception {   // 하나의 Transaction으로 묶어준 후의 코드.
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DataSourceUtils.getConnection(ds);       // *** 바뀐 부분
            pstmt = conn.prepareStatement("insert into a1 values(?, ?)");
            pstmt.setInt(1, key);
            pstmt.setInt(2, value);
            System.out.println("conn = " + conn);     // 하나의 Transaction으로 묶이면 Connection이 같아야 함. 묶였는지 확인하는 코드.

            return pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            close(pstmt);
            DataSourceUtils.releaseConnection(conn, ds);    // *** 바뀐 부분
        }
    }

    private void close(AutoCloseable... acs) {
        for (AutoCloseable ac : acs) {
            try{ac.close();}
            catch(Exception e) {e.printStackTrace();}
        }
    }

    public void deleteAll() throws Exception {      // 하나의 Transaction으로 묶이면 안되므로 이렇게 작성. 개별 Transaction으로 작동해야 함.
        Connection conn = ds.getConnection();
        String sql = "delete from a1";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.executeUpdate();
        close(pstmt);
    }

}
/*
- DAO의 각 메서드는 개별 Connection을 사용.
- 하나의 Transaction으로 처리되려면 하나의 Connection에서 이루어져야 함.
- 그래서 필요한 것이 TransactionManager. 같은 Transaction 내에서 같은 Connection을 사용할 수 있게 관리하는 역할.
- @Transactional : AOP를 이용해서 핵심 기능과 부가 기능을 분리하는 역할을 하는 애너테이션.
*/
