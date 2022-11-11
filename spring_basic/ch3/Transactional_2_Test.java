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

// ************************** TransactionManager를 자동으로 주입해서 처리하는 코드 **************************

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class A1DaoTest extends TestCase {
//    @Autowired
//    DataSource ds;

    @Autowired
    DataSourceTransactionManager tm;

    @Autowired
    A1Dao a1Dao;

    @Test
    public void insertTest() throws Exception {

//        PlatformTransactionManager tm = new DataSourceTransactionManager(ds);     // 자동 주입하므로 수동으로 생성할 필요없음.
        TransactionStatus status = tm.getTransaction(new DefaultTransactionDefinition());
        
        try {
            a1Dao.deleteAll();
            a1Dao.insert(1, 100);
//            a1Dao.insert(2, 200);
            a1Dao.insert(1, 200);
            tm.commit(status);
        } catch (Exception e) {
            e.printStackTrace();
            tm.rollback(status);
        } finally {
        }
    }

}
