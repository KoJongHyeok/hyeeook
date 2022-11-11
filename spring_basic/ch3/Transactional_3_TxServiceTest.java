package com.fastcampus.ch3;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

// ************************** @Transactional을 사용해서 처리하는 코드 **************************

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class TxServiceTest extends TestCase {

    @Autowired
    TxService txService;

    @Test
    public void insertA1WithoutTxTest() throws Exception {

        txService.insertA1WithoutTx();
        // conn = com.mysql.cj.jdbc.ConnectionImpl@4d74c3ba
        // conn = com.mysql.cj.jdbc.ConnectionImpl@28d79cba
        // 하나의 Transaction으로 묶이지 않음.

    }

    @Test
    public void insertA1WithTxSuccessTest() throws Exception {

        txService.insertA1WithTxSuccess();
        // conn = com.mysql.cj.jdbc.ConnectionImpl@52a70627
        // conn = com.mysql.cj.jdbc.ConnectionImpl@52a70627
        // 하나의 Transaction으로 묶임.

    }

    @Test
    public void insertA1WithTxFailTest() throws Exception {

        txService.insertA1WithTxFail();

        // 테스트(1)
        // conn = com.mysql.cj.jdbc.ConnectionImpl@5631962
        // conn = com.mysql.cj.jdbc.ConnectionImpl@5631962
        // 하나의 Transaction으로 묶였으나 전체 rollback 안됨.

        // 테스트(2)
        // conn = com.mysql.cj.jdbc.ConnectionImpl@19569ebd
        // conn = com.mysql.cj.jdbc.ConnectionImpl@19569ebd
        // 하나의 Transaction으로 묶이고 전체 rollback 됨.

    }


    @Test
    public void insertA1WithTxFailTestTest() throws Exception {

        txService.insertA1WithTxFailTest();

        // 테스트(3)
        // RuntimeException 발생으로 전체 rollback 됨.

        // 테스트(4)
        // Exception 발생으로 전체 rollback 안됨.

    }

}
