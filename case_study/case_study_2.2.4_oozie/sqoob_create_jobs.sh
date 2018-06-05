# hadoop fs -rm /Credit_Card_System_224
hadoop fs -mkdir /Credit_Card_System_224
sqoop-metastore
# ctrl-z, then bg

#sqoop job --meta-connect jdbc:hsqldb:hsql://localhost:16000/sqoop --list

sqoop job \
--meta-connect jdbc:hsqldb:hsql://localhost:16000/sqoop \
--create updateBranch \
-- import \
-m 1 \
--connect jdbc:mysql://localhost/CDW_SAPP \
--driver com.mysql.jdbc.Driver \
--query "SELECT BRANCH_CODE, BRANCH_NAME, BRANCH_STREET, BRANCH_CITY, BRANCH_STATE, BRANCH_ZIP, CONCAT('(',SUBSTRING(BRANCH_PHONE, 1, 3),')',SUBSTRING(BRANCH_PHONE, 4, 3),'-',SUBSTRING(BRANCH_PHONE, 7, 4) ) AS FORMATTED_PHONE, LAST_UPDATED FROM CDW_SAPP_BRANCH WHERE \$CONDITIONS"  \
--append \
--incremental lastmodified \
--check-column LAST_UPDATED \
--last-value '2017-12-31' \
--target-dir /Credit_Card_System_224/branch \
--fields-terminated-by ','

sqoop job --meta-connect jdbc:hsqldb:hsql://localhost:16000/sqoop --exec updateBranch

# mysql> insert into CDW_SAPP_BRANCH (BRANCH_CODE,BRANCH_NAME,BRANCH_STREET,BRANCH_CITY,BRANCH_STATE,BRANCH_ZIP,BRANCH_PHONE) VALUES (199,'Example Bank','Floral Boulevard','Floral Park','NY','11001','1234567890');
# mysql> insert into CDW_SAPP_BRANCH (BRANCH_CODE,BRANCH_NAME,BRANCH_STREET,BRANCH_CITY,BRANCH_STATE,BRANCH_ZIP,BRANCH_PHONE) VALUES (200,'Example Bank','Floral Boulevard','Floral Park','NY','11001','1234567891');
# mysql> insert into CDW_SAPP_BRANCH (BRANCH_CODE,BRANCH_NAME,BRANCH_STREET,BRANCH_CITY,BRANCH_STATE,BRANCH_ZIP,BRANCH_PHONE) VALUES (201,'Example Bank','Floral Boulevard','Floral Park','NY','11001','1234567892');

sqoop job \
--meta-connect jdbc:hsqldb:hsql://localhost:16000/sqoop \
--create updateCustomer \
-- import \
-m 1 \
--connect jdbc:mysql://localhost/CDW_SAPP \
--driver com.mysql.jdbc.Driver \
--query "SELECT SSN, FIRST_NAME, lower(MIDDLE_NAME), LAST_NAME, CREDIT_CARD_NO, CONCAT(APT_NO,' ',STREET_NAME), CUST_CITY, CUST_STATE, CUST_COUNTRY, CUST_ZIP, CONCAT(SUBSTRING(CUST_PHONE, 1, 3),'-',SUBSTRING(CUST_PHONE, 4, 4) ) as FORMATTED_PHONE, CUST_EMAIL, LAST_UPDATED FROM CDW_SAPP_CUSTOMER WHERE \$CONDITIONS" \
--append \
--incremental lastmodified \
--check-column LAST_UPDATED \
--last-value '2017-12-31' \
--target-dir /Credit_Card_System_224/customer \
--fields-terminated-by ','

sqoop job --meta-connect jdbc:hsqldb:hsql://localhost:16000/sqoop --exec updateCustomer

#mysql> insert into CDW_SAPP_CUSTOMER (FIRST_NAME, MIDDLE_NAME, LAST_NAME, SSN, CREDIT_CARD_NO, APT_NO, STREET_NAME, CUST_CITY, CUST_STATE, CUST_COUNTRY, CUST_ZIP, CUST_PHONE, CUST_EMAIL) values ( 'Florence', 'Joy', 'Morris', 211111111, '2111111111111111', '211', 'Main Street', 'Floral Park', 'NY', 'United States', '11001', 1237818, 'fmorris@example.com');
#mysql> insert into CDW_SAPP_CUSTOMER (FIRST_NAME, MIDDLE_NAME, LAST_NAME, SSN, CREDIT_CARD_NO, APT_NO, STREET_NAME, CUST_CITY, CUST_STATE, CUST_COUNTRY, CUST_ZIP, CUST_PHONE, CUST_EMAIL) values ( 'Florence', 'Joy', 'Morris', 211111112, '2111111111111112', '211', 'Main Street', 'Floral Park', 'NY', 'United States', '11001', 1237818, 'fmorris@example.com');

sqoop job \
--meta-connect jdbc:hsqldb:hsql://localhost:16000/sqoop \
--create updateCreditCard \
-- import \
-m 1 \
--connect jdbc:mysql://localhost/CDW_SAPP \
--driver com.mysql.jdbc.Driver \
--query "SELECT TRANSACTION_ID, CREDIT_CARD_NO, DATE_FORMAT(CONCAT(CAST(YEAR AS CHAR(4)),'-',CAST(MONTH AS CHAR(2)),'-',CAST(DAY AS CHAR(2))),'%Y%m%d') AS TIMEID, CUST_SSN, BRANCH_CODE, TRANSACTION_TYPE, TRANSACTION_VALUE FROM CDW_SAPP_CREDITCARD WHERE \$CONDITIONS" \
--incremental append \
--check-column TRANSACTION_ID \
--last-value '0' \
--target-dir /Credit_Card_System_224/credit_card \
--fields-terminated-by ','

sqoop job --meta-connect jdbc:hsqldb:hsql://localhost:16000/sqoop --exec updateCreditCard

#mysql> insert into CDW_SAPP_CREDITCARD (TRANSACTION_ID, DAY, MONTH, YEAR, CREDIT_CARD_NO, CUST_SSN, BRANCH_CODE, TRANSACTION_TYPE, TRANSACTION_VALUE) VALUES (46695, 31, 12, 2018, '2111111111111111', 211111111, 199, 'Healthcare', 1.000);
#mysql> insert into CDW_SAPP_CREDITCARD (TRANSACTION_ID, DAY, MONTH, YEAR, CREDIT_CARD_NO, CUST_SSN, BRANCH_CODE, TRANSACTION_TYPE, TRANSACTION_VALUE) VALUES (46696, 31, 12, 2018, '2111111111111112', 211111112, 200, 'Healthcare', 1.000);