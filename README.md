# Bank
#SQL SCRIPT FOR USER_INFO TABLE
CREATE TABLE USER_INFO (USER_ID NUMBER PRIMARY KEY,ACCOUNT_ID NUMBER UNIQUE,FIRST_NAME VARCHAR2(20),LAST_NAME VARCHAR2(20),ADDRESS VARCHAR2(40),USER_NAME VARCHAR2(20),
PHONE_NUMBER VARCHAR(30) UNIQUE ,PASSWORD VARCHAR2(20),EMAIL VARCHAR2(30));
