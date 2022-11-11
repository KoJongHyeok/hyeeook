/*
- @Transactional 속성
- propagation : Tx의 경계(boundary)를 설정하는 방법을 지정.
- isolation : Tx의 'isolation level'을 지정. DEFAULT, READ_UNCOMMITTED, READ_COMMITTED, REPEATABLE_READ, SERIALIZABLE.
- readOnly : Tx이 데이터를 읽기만 하는 경우, 'true'로 지정하면 성능이 향상.
- rollbackFor : 지정된 예외가 발생하면, Tx을 rollback. RuntimeException, Error는 자동 rollback.
- noRollbackFor : 지정된 예외가 발생해도, Tx을 rollback 안 함.
- timeout : 지정된 시간(초) 내에 Tx이 종료되지 많으면, Tx을 강제 종료.

- propagation 속성의 값
- REQUIRED  : Tx이 진행 중이면 참여하고, 없으면 새로운 Tx 시작(디폴트).
- REQUIRES_NEW : Tx이 진행 중이건 아니건, 새로 Tx 시작(Tx 안에 다른 Tx, 둘의 관계는 다른 Tx).
- NESTED : Tx이 진행 중이면, Tx의 내부 Tx으로 시작(Tx 안에 subTx, 둘의 관계는 같은 Tx, save point).
- MANDATORY : 반드시 진행 중인 Tx 내에서만 실행 가능. 아니면 예외 발생.
- SUPPORTS : Tx이 진행 중이건 아니건 상관없이 실행.
- NOT_SUPPORTED : Tx없이 처리. Tx이 진행 중이면 잠시 중단(suspend).
- NEVER : Tx없이 처리. Tx이 진행 중이면 예외 발생.
*/

