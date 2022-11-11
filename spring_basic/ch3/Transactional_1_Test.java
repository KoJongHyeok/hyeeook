package com.fastcampus.ch3;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.sql.DataSource;

// ************************** TransactionManager를 수동으로 주입해서 처리하는 코드 **************************

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class A1DaoTest extends TestCase {

    @Autowired
    DataSource ds;
    @Autowired
    A1Dao a1Dao;

//    @Test   // test(1)
//    public void insertTest() throws Exception {
//            a1Dao.insert(1, 100);     // 성공, DB에 값이 저장됨.
//            a1Dao.insert(2, 200);     // 성공, DB에 값이 저장됨.
//    }

//    @Test   // test(2)
//    public void insertTest() throws Exception {
//            a1Dao.insert(1, 100);       // 성공, DB에 값이 저장됨.
//            a1Dao.insert(1, 200);       // 실패, Transaction이 다르므로 실패해도 insert(1, 100) 값은 DB에 저장된 상태로 rollback.
//    }

    // 모두 성공해야 commit 할 수 있고, 하나라도 실패하면 rollback 하도록 하는 방법?
    // 그것이 Transaction.

    @Test   // test(3)
    public void insertTest() throws Exception {

        // TransactionManager 생성
        PlatformTransactionManager tm = new DataSourceTransactionManager(ds);
        TransactionStatus status = tm.getTransaction(new DefaultTransactionDefinition());   // Default 값으로 Transaction의 속성을 설정.

        // Transaction 시작

        try {
            a1Dao.deleteAll();      // 매번 삭제하기 번거로워서 추가한 코드.
            a1Dao.insert(1, 100);
//            a1Dao.insert(2, 200);
            a1Dao.insert(1, 200);
            tm.commit(status);      // 모두 성공해야 commit.
        } catch (Exception e) {
            e.printStackTrace();
            tm.rollback(status);    // 하나라도 실패하면 rollback.
        } finally {                 // DB에 아무것도 저장되지 않아야 성공.
        }
    }

}
