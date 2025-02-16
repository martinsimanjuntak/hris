-- HRIS.LMP_EMPLOYEE definition
-- HRIS.LMP_ROLE definition

CREATE TABLE "HRIS"."LMP_ROLE" 
   (	"ID" VARCHAR2(70) NOT NULL ENABLE, 
	"VERSION" NUMBER(5,0), 
	"NAME" VARCHAR2(70), 
	"DETAILS" CLOB, 
	"CREATED_DATE" DATE, 
	"CREATED_BY" VARCHAR2(50), 
	"CREATED_BY_USERNAME" VARCHAR2(50), 
	"UPDATED_DATE" DATE, 
	"UPDATED_BY" VARCHAR2(50), 
	"UPDATED_BY_USERNAME" VARCHAR2(50), 
	"IS_DELETE" NUMBER(1,0), 
	"STATUS" VARCHAR2(50), 
	 PRIMARY KEY ("ID")

CREATE TABLE "HRIS"."LMP_EMPLOYEE" 
   (	"ID" VARCHAR2(70) NOT NULL ENABLE, 
	"USER_ID" VARCHAR2(70), 
	"VERSION" NUMBER(5,0), 
	"NIP" VARCHAR2(50), 
	"NAME" VARCHAR2(70), 
	"BIRTH_DATE" DATE, 
	"GENDER" VARCHAR2(5), 
	"RELIGION" VARCHAR2(20), 
	"PHONE_NUMBER" VARCHAR2(20), 
	"ADDRESS" VARCHAR2(100), 
	"EMAIL" VARCHAR2(30), 
	"DEPARTMENT" VARCHAR2(30), 
	"ENTRY_DATE" DATE, 
	"POSITION" VARCHAR2(20), 
	"DETAILS" CLOB, 
	"CREATED_DATE" DATE, 
	"CREATED_BY" VARCHAR2(50), 
	"CREATED_BY_USERNAME" VARCHAR2(50), 
	"UPDATED_DATE" DATE, 
	"UPDATED_BY" VARCHAR2(50), 
	"UPDATED_BY_USERNAME" VARCHAR2(50), 
	"IS_DELETE" NUMBER(1,0), 
	"STATUS" VARCHAR2(50), 
	 PRIMARY KEY ("ID")


-- HRIS.LMP_EMPLOYEE foreign keys

ALTER TABLE "HRIS"."LMP_EMPLOYEE" ADD FOREIGN KEY ("USER_ID")
	  REFERENCES "HRIS"."LMP_USER" ("ID") ENABLE;
	 

-- HRIS.LMP_USER definition

CREATE TABLE "HRIS"."LMP_USER" 
   (	"ID" VARCHAR2(70) NOT NULL ENABLE, 
	"VERSION" NUMBER(5,0), 
	"ROLE_ID" VARCHAR2(50), 
	"NAME" VARCHAR2(70), 
	"USERNAME" VARCHAR2(100), 
	"PASSWORD" VARCHAR2(100), 
	"DETAILS" CLOB, 
	"CREATED_DATE" DATE, 
	"CREATED_BY" VARCHAR2(50), 
	"CREATED_BY_USERNAME" VARCHAR2(50), 
	"UPDATED_DATE" DATE, 
	"UPDATED_BY" VARCHAR2(50), 
	"UPDATED_BY_USERNAME" VARCHAR2(50), 
	"IS_DELETE" NUMBER(1,0), 
	"STATUS" VARCHAR2(50), 
	 PRIMARY KEY ("ID")


-- HRIS.LMP_USER foreign keys

ALTER TABLE "HRIS"."LMP_USER" ADD FOREIGN KEY ("ROLE_ID")
	  REFERENCES "HRIS"."LMP_ROLE" ("ID") ENABLE;	  
	 
	 