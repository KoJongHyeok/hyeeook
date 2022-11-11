package com.fastcampus.ch3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// ************************** @Transactional을 사용해서 처리하는 코드 **************************

@Service
public class TxService {

    @Autowired A1Dao a1Dao;
    @Autowired B1Dao b1Dao;

    public void insertA1WithoutTx() throws Exception {
        a1Dao.insert(1, 100);
        a1Dao.insert(1, 200);
    }

    @Transactional
    public void insertA1WithTxSuccess() throws Exception {
        a1Dao.insert(1, 100);
        a1Dao.insert(2, 200);
    }

//    @Transactional      // 테스트(1)
    @Transactional(rollbackFor = Exception.class)     // 테스트(2)
    public void insertA1WithTxFail() throws Exception {
        a1Dao.insert(1, 100);
        a1Dao.insert(1, 200);

        // @Transactional : RuntimeException, Error만 rollback 처리.
    }



    // @Transactional이 rollback 처리하는 종류 테스트
    @Transactional
    public void insertA1WithTxFailTest() throws Exception {

        // 테스트(3)
//        a1Dao.insert(1, 100);
//        throw new RuntimeException();

        // 테스트(4)
        a1Dao.insert(1, 100);
        throw new Exception();
    }

}
