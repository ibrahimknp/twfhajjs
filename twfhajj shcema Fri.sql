DROP TABLE TWFHAJJ.CASES_FOLLOWUP CASCADE CONSTRAINTS;

CREATE TABLE TWFHAJJ.CASES_FOLLOWUP
(
  CF_CODE     NUMBER,
  CF_CR_CODE  NUMBER,
  CF_STATUS   NUMBER,
  CF_USER     NUMBER,
  CF_DATE     DATE
)
TABLESPACE SYSTEM
PCTUSED    40
PCTFREE    10
INITRANS   1
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            NEXT             1M
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            FREELISTS        1
            FREELIST GROUPS  1
            BUFFER_POOL      DEFAULT
           )
LOGGING 
NOCOMPRESS 
NOCACHE
NOPARALLEL
MONITORING;


DROP TABLE TWFHAJJ.CASES_REQUEST CASCADE CONSTRAINTS;

CREATE TABLE TWFHAJJ.CASES_REQUEST
(
  CR_CODE         NUMBER(10)                    NOT NULL,
  CR_TYPE         NUMBER(5)                     NOT NULL,
  CR_DESC         VARCHAR2(500 BYTE),
  CR_IN_ID        VARCHAR2(15 BYTE),
  CR_INF_NAME     VARCHAR2(100 BYTE),
  CR_INF_CONTACT  VARCHAR2(100 BYTE),
  CR_CITY_ID      NUMBER(10),
  CR_AREA_ID      NUMBER(10),
  CR_LOCATION     VARCHAR2(500 BYTE),
  CR_DATE_REG     DATE                          DEFAULT sysdate,
  CR_STATUS       NUMBER(1),
  CR_UDATE        DATE,
  CR_TEAM         NUMBER,
  CR_USER         NUMBER
)
TABLESPACE SYSTEM
PCTUSED    40
PCTFREE    10
INITRANS   1
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            NEXT             1M
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            FREELISTS        1
            FREELIST GROUPS  1
            BUFFER_POOL      DEFAULT
           )
LOGGING 
NOCOMPRESS 
NOCACHE
NOPARALLEL
MONITORING;


DROP TABLE TWFHAJJ.CASES_STATUS CASCADE CONSTRAINTS;

CREATE TABLE TWFHAJJ.CASES_STATUS
(
  CS_CODE     NUMBER(1),
  CS_NAME_AR  VARCHAR2(50 BYTE),
  CS_NAME_LA  VARCHAR2(50 BYTE)
)
TABLESPACE SYSTEM
PCTUSED    40
PCTFREE    10
INITRANS   1
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            NEXT             1M
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            FREELISTS        1
            FREELIST GROUPS  1
            BUFFER_POOL      DEFAULT
           )
LOGGING 
NOCOMPRESS 
NOCACHE
NOPARALLEL
MONITORING;


DROP TABLE TWFHAJJ.CASES_TYPES CASCADE CONSTRAINTS;

CREATE TABLE TWFHAJJ.CASES_TYPES
(
  CST_CODE     NUMBER(3),
  CST_NAME_AR  VARCHAR2(50 BYTE),
  CST_NAME_LA  VARCHAR2(50 BYTE),
  CST_STATUS   NUMBER(1)
)
TABLESPACE SYSTEM
PCTUSED    40
PCTFREE    10
INITRANS   1
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            NEXT             1M
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            FREELISTS        1
            FREELIST GROUPS  1
            BUFFER_POOL      DEFAULT
           )
LOGGING 
NOCOMPRESS 
NOCACHE
NOPARALLEL
MONITORING;


DROP TABLE TWFHAJJ.HAJJIES CASCADE CONSTRAINTS;

CREATE TABLE TWFHAJJ.HAJJIES
(
  HJ_CODE           NUMBER,
  HJ_NAME           VARCHAR2(75 BYTE),
  HJ_NATIONALITY    NUMBER,
  HJ_GENDER         NUMBER,
  HJ_IDTYPE         NUMBER,
  HJ_ID_NO          VARCHAR2(15 BYTE),
  HJ_BLOOD          NUMBER,
  HJ_DS_DIABATIC    NUMBER,
  HJ_DS_HYPER       NUMBER(22,-3),
  HJ_DS_CHEST       NUMBER,
  HJ_DS_HEART       NUMBER,
  HJ_DS_OPERATIONS  NUMBER,
  HJ_DS_OP_DESC     VARCHAR2(4000 BYTE),
  HJ_ATTACHMENT     VARCHAR2(250 BYTE),
  HJ_DATE           DATE,
  HJ_UDATE          DATE,
  HJ_USER           NUMBER
)
TABLESPACE SYSTEM
PCTUSED    40
PCTFREE    10
INITRANS   1
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            NEXT             1M
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            FREELISTS        1
            FREELIST GROUPS  1
            BUFFER_POOL      DEFAULT
           )
LOGGING 
NOCOMPRESS 
NOCACHE
NOPARALLEL
MONITORING;


DROP TABLE TWFHAJJ.LUK_AREA CASCADE CONSTRAINTS;

CREATE TABLE TWFHAJJ.LUK_AREA
(
  LAR_ID            NUMBER(10)                  NOT NULL,
  LAR_AREA_NAME_AR  VARCHAR2(50 BYTE)           NOT NULL,
  LAR_AREA_NAME_LA  VARCHAR2(50 BYTE)           NOT NULL,
  LAR_CITY_ID       NUMBER(10)                  NOT NULL,
  LAR_STATUS        NUMBER(1),
  LAR_RES_NAME      VARCHAR2(100 BYTE),
  LAR_RES_PHONE     VARCHAR2(50 BYTE),
  LAR_RES_MOBILE    VARCHAR2(50 BYTE),
  EDATE             DATE                        DEFAULT sysdate,
  UDATE             DATE
)
TABLESPACE SYSTEM
PCTUSED    40
PCTFREE    10
INITRANS   1
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            NEXT             1M
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            FREELISTS        1
            FREELIST GROUPS  1
            BUFFER_POOL      DEFAULT
           )
LOGGING 
NOCOMPRESS 
NOCACHE
NOPARALLEL
MONITORING;


DROP TABLE TWFHAJJ.LUK_BLOOD_GROUP CASCADE CONSTRAINTS;

CREATE TABLE TWFHAJJ.LUK_BLOOD_GROUP
(
  LBG_CODE  NUMBER,
  LBG_NAME  VARCHAR2(3 BYTE)
)
TABLESPACE SYSTEM
PCTUSED    40
PCTFREE    10
INITRANS   1
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            NEXT             1M
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            FREELISTS        1
            FREELIST GROUPS  1
            BUFFER_POOL      DEFAULT
           )
LOGGING 
NOCOMPRESS 
NOCACHE
NOPARALLEL
MONITORING;


DROP TABLE TWFHAJJ.LUK_CITY CASCADE CONSTRAINTS;

CREATE TABLE TWFHAJJ.LUK_CITY
(
  LCT_ID       NUMBER(10)                       NOT NULL,
  LCT_NAME_AR  VARCHAR2(75 BYTE)                NOT NULL,
  LCT_NAME_LA  VARCHAR2(75 BYTE)                NOT NULL,
  LCT_STATUS   NUMBER(1)                        NOT NULL,
  EDATE        DATE,
  UDATE        DATE
)
TABLESPACE SYSTEM
PCTUSED    40
PCTFREE    10
INITRANS   1
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            NEXT             1M
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            FREELISTS        1
            FREELIST GROUPS  1
            BUFFER_POOL      DEFAULT
           )
LOGGING 
NOCOMPRESS 
NOCACHE
NOPARALLEL
MONITORING;


DROP TABLE TWFHAJJ.LUK_GENDER CASCADE CONSTRAINTS;

CREATE TABLE TWFHAJJ.LUK_GENDER
(
  GEN_ID       NUMBER(1),
  GEN_NAME_AR  VARCHAR2(25 BYTE),
  GEN_NAME_LA  VARCHAR2(25 BYTE)
)
TABLESPACE SYSTEM
PCTUSED    40
PCTFREE    10
INITRANS   1
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            NEXT             1M
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            FREELISTS        1
            FREELIST GROUPS  1
            BUFFER_POOL      DEFAULT
           )
LOGGING 
NOCOMPRESS 
NOCACHE
NOPARALLEL
MONITORING;


DROP TABLE TWFHAJJ.LUK_HEALTH_STATUS CASCADE CONSTRAINTS;

CREATE TABLE TWFHAJJ.LUK_HEALTH_STATUS
(
  HST_CODE     NUMBER(3),
  HST_NAME_AR  VARCHAR2(50 BYTE),
  HST_NANE_LA  VARCHAR2(50 BYTE),
  HST_STATUS   NUMBER(1)
)
TABLESPACE SYSTEM
PCTUSED    40
PCTFREE    10
INITRANS   1
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            NEXT             1M
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            FREELISTS        1
            FREELIST GROUPS  1
            BUFFER_POOL      DEFAULT
           )
LOGGING 
NOCOMPRESS 
NOCACHE
NOPARALLEL
MONITORING;


DROP TABLE TWFHAJJ.LUK_ID_TYPE CASCADE CONSTRAINTS;

CREATE TABLE TWFHAJJ.LUK_ID_TYPE
(
  LIT_CODE     NUMBER(1),
  LIT_NAME_AR  VARCHAR2(25 BYTE),
  LIT_NAME_LA  VARCHAR2(25 BYTE)
)
TABLESPACE SYSTEM
PCTUSED    40
PCTFREE    10
INITRANS   1
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            NEXT             1M
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            FREELISTS        1
            FREELIST GROUPS  1
            BUFFER_POOL      DEFAULT
           )
LOGGING 
NOCOMPRESS 
NOCACHE
NOPARALLEL
MONITORING;


DROP TABLE TWFHAJJ.LUK_JOBS CASCADE CONSTRAINTS;

CREATE TABLE TWFHAJJ.LUK_JOBS
(
  LJB_CODE     NUMBER,
  LJB_NAME_AR  VARCHAR2(40 BYTE),
  LJB_NAME_LA  VARCHAR2(40 BYTE)
)
TABLESPACE SYSTEM
PCTUSED    40
PCTFREE    10
INITRANS   1
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            NEXT             1M
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            FREELISTS        1
            FREELIST GROUPS  1
            BUFFER_POOL      DEFAULT
           )
LOGGING 
NOCOMPRESS 
NOCACHE
NOPARALLEL
MONITORING;


DROP TABLE TWFHAJJ.LUK_MEDCEN_TYPES CASCADE CONSTRAINTS;

CREATE TABLE TWFHAJJ.LUK_MEDCEN_TYPES
(
  LMT_CODE     NUMBER,
  LMT_NAME_AR  VARCHAR2(25 BYTE),
  LMT_NAME_LA  VARCHAR2(25 BYTE)
)
TABLESPACE SYSTEM
PCTUSED    40
PCTFREE    10
INITRANS   1
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            NEXT             1M
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            FREELISTS        1
            FREELIST GROUPS  1
            BUFFER_POOL      DEFAULT
           )
LOGGING 
NOCOMPRESS 
NOCACHE
NOPARALLEL
MONITORING;


DROP TABLE TWFHAJJ.LUK_NATIONALITY CASCADE CONSTRAINTS;

CREATE TABLE TWFHAJJ.LUK_NATIONALITY
(
  NAT_ID       NUMBER(5),
  NAT_NAME_AR  VARCHAR2(50 BYTE),
  NAT_NAME_LA  VARCHAR2(50 BYTE)
)
TABLESPACE SYSTEM
PCTUSED    40
PCTFREE    10
INITRANS   1
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            NEXT             1M
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            FREELISTS        1
            FREELIST GROUPS  1
            BUFFER_POOL      DEFAULT
           )
LOGGING 
NOCOMPRESS 
NOCACHE
NOPARALLEL
MONITORING;


DROP TABLE TWFHAJJ.MEDICAL_CENTER CASCADE CONSTRAINTS;

CREATE TABLE TWFHAJJ.MEDICAL_CENTER
(
  MDC_CODE      NUMBER(5),
  MDC_NAME_AR   VARCHAR2(100 BYTE),
  MDC_NAME_LA   VARCHAR2(100 BYTE),
  MDC_CITY      NUMBER(3),
  MDC_AREA      NUMBER(3),
  MDC_LOCATION  VARCHAR2(500 BYTE),
  MDC_STATUS    NUMBER(1),
  MDC_TYPE      NUMBER(1)
)
TABLESPACE SYSTEM
PCTUSED    40
PCTFREE    10
INITRANS   1
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            NEXT             1M
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            FREELISTS        1
            FREELIST GROUPS  1
            BUFFER_POOL      DEFAULT
           )
LOGGING 
NOCOMPRESS 
NOCACHE
NOPARALLEL
MONITORING;


DROP TABLE TWFHAJJ.TEAM CASCADE CONSTRAINTS;

CREATE TABLE TWFHAJJ.TEAM
(
  TM_CODE    NUMBER,
  TM_NAME    VARCHAR2(250 BYTE),
  TM_STATUS  NUMBER
)
TABLESPACE SYSTEM
PCTUSED    40
PCTFREE    10
INITRANS   1
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            NEXT             1M
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            FREELISTS        1
            FREELIST GROUPS  1
            BUFFER_POOL      DEFAULT
           )
LOGGING 
NOCOMPRESS 
NOCACHE
NOPARALLEL
MONITORING;


DROP TABLE TWFHAJJ.USERS CASCADE CONSTRAINTS;

CREATE TABLE TWFHAJJ.USERS
(
  USR_CODE    NUMBER(5),
  USR_NAME    VARCHAR2(50 BYTE),
  USR_LOGIN   VARCHAR2(25 BYTE),
  USR_PASS    VARCHAR2(25 BYTE),
  USR_STATUS  NUMBER(1),
  USR_PRV     NUMBER(1)
)
TABLESPACE SYSTEM
PCTUSED    40
PCTFREE    10
INITRANS   1
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            NEXT             1M
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            FREELISTS        1
            FREELIST GROUPS  1
            BUFFER_POOL      DEFAULT
           )
LOGGING 
NOCOMPRESS 
NOCACHE
NOPARALLEL
MONITORING;
DROP VIEW TWFHAJJ.V_CASES_REQUEST;

/* Formatted on 03/08/2018 07:51:07 AM (QP5 v5.149.1003.31008) */
CREATE OR REPLACE FORCE VIEW TWFHAJJ.V_CASES_REQUEST
(
   CR_CODE,
   CR_TYPE,
   CR_CITY_ID,
   CR_CITY_NAME_AR,
   CR_CITY_NAME_LA,
   CR_AREA_ID,
   CR_AREA_NAME_AR,
   CR_AREA_NAME_LA,
   CR_LOCATION,
   CR_C,
   CR_DESC,
   CR_IN_ID,
   CR_INF_NAME,
   CR_INF_CONTACT,
   CR_DATE_REG,
   CR_STATUS,
   CR_STATUS_AR,
   CR_STATUS_LA,
   CR_TEAM,
   CR_REPLY,
   CR_UDATE,
   CR_MEDCR_ID,
   CR_MEDCR_NAME_AR,
   CR_MEDCR_NAME_LA,
   CR_TEAM_ID,
   CR_TEAM_NAME,
   CR_DATE_STATUS
)
AS
   SELECT cr_code,
          cr_type,
          cr_city_id,
          lct_name_ar AS cr_city_name_ar,
          lct_name_ar AS cr_city_name_la,
          cr_area_id,
          LAR_AREA_NAME_AR AS cr_AREA_NAME_ar,
          LAR_AREA_NAME_LA AS cr_AREA_NAME_LA,
          lct_name_ar AS cr_location,
          '' AS cr_c,
          cr_desc,
          cr_in_id,
          cr_inf_name,
          cr_inf_contact,
          cr_date_reg,
          cr_status,
          CS_NAME_AR AS cr_status_ar,
          CS_NAME_LA AS cr_status_la,
          '' AS cr_team,
          '' AS cr_reply,
          cr_udate,
          '' AS cr_medcr_id,
          '' AS cr_medcr_name_ar,
          '' AS cr_medcr_name_la,
          '' AS cr_team_id,
          '' AS cr_team_name,
          '' AS cr_date_status
     FROM cases_request r,
          cases_status s,
          luk_city c,
          luk_area a
    WHERE     r.cr_city_id = c.LCT_ID
          AND r.cr_area_id = a.lar_id
          AND r.cr_status = s.cs_code;


DROP VIEW TWFHAJJ.V_CASES_TYPES;

/* Formatted on 03/08/2018 07:51:07 AM (QP5 v5.149.1003.31008) */
CREATE OR REPLACE FORCE VIEW TWFHAJJ.V_CASES_TYPES
(
   CST_CODE,
   CST_NAME_AR,
   CST_NAME_LA,
   CST_STATUS
)
AS
   SELECT CST_CODE,
          CST_NAME_AR,
          CST_NAME_LA,
          CST_STATUS
     FROM TWFHAJJ.CASES_TYPES;


DROP VIEW TWFHAJJ.V_HAJJIES;

/* Formatted on 03/08/2018 07:51:07 AM (QP5 v5.149.1003.31008) */
CREATE OR REPLACE FORCE VIEW TWFHAJJ.V_HAJJIES
(
   HJ_CODE,
   HJ_NAME,
   HJ_NATIONALITY,
   HJ_NATIONALITY_AR,
   HJ_NATIONALITY_LA,
   HJ_GENDER,
   HJ_GENDER_AR,
   HJ_GENDER_LA,
   HJ_IDTYPE,
   HJ_ID_NO,
   HJ_BLOOD,
   HJ_BLOOD_GROUP,
   HJ_DS_DIABATIC,
   HJ_DS_HYPER,
   HJ_DS_CHEST,
   HJ_DS_HEART,
   HJ_DS_OPERATIONS,
   HJ_DS_OP_DESC,
   HJ_ATTACHMENT,
   HJ_DATE,
   HJ_UDATE,
   HJ_USER
)
AS
   SELECT hj_code,
          hj_name,
          hj_nationality,
          NAT_NAME_AR AS hj_nationality_ar,
          NAT_NAME_LA AS hj_nationality_la,
          hj_gender,
          gen_name_ar AS hj_gender_ar,
          gen_name_la AS hj_gender_la,
          hj_idtype,
          hj_id_no,
          hj_blood,
          LBG_NAME AS hj_blood_group,
          hj_ds_diabatic,
          hj_ds_hyper,
          hj_ds_chest,
          hj_ds_heart,
          hj_ds_operations,
          hj_ds_op_desc,
          hj_attachment,
          hj_date,
          hj_udate,
          hj_user
     FROM hajjies h,
          luk_nationality n,
          luk_gender g,
          luk_blood_group b,
          luk_id_type t
    WHERE     h.hj_nationality = nat_id
          AND h.hj_gender = gen_id
          AND h.hj_blood = b.lbg_code
          AND h.hj_idtype = t.lit_code;


DROP VIEW TWFHAJJ.V_LUK_AREA;

/* Formatted on 03/08/2018 07:51:07 AM (QP5 v5.149.1003.31008) */
CREATE OR REPLACE FORCE VIEW TWFHAJJ.V_LUK_AREA
(
   LAR_ID,
   LAR_AREA_NAME_AR,
   LAR_AREA_NAME_LA,
   LAR_CITY_ID,
   LAR_STATUS,
   LAR_RES_NAME,
   LAR_RES_PHONE,
   LAR_RES_MOBILE,
   EDATE,
   UDATE
)
AS
   SELECT LAR_ID,
          LAR_AREA_NAME_AR,
          LAR_AREA_NAME_LA,
          LAR_CITY_ID,
          LAR_STATUS,
          LAR_RES_NAME,
          LAR_RES_PHONE,
          LAR_RES_MOBILE,
          EDATE,
          UDATE
     FROM TWFHAJJ.LUK_AREA;


DROP VIEW TWFHAJJ.V_LUK_CITY;

/* Formatted on 03/08/2018 07:51:07 AM (QP5 v5.149.1003.31008) */
CREATE OR REPLACE FORCE VIEW TWFHAJJ.V_LUK_CITY
(
   LCT_ID,
   LCT_NAME_AR,
   LCT_NAME_LA,
   LCT_STATUS,
   EDATE,
   UDATE
)
AS
   SELECT LCT_ID,
          LCT_NAME_AR,
          LCT_NAME_LA,
          LCT_STATUS,
          EDATE,
          UDATE
     FROM TWFHAJJ.LUK_CITY;


DROP VIEW TWFHAJJ.V_LUK_ID_TYPE;

/* Formatted on 03/08/2018 07:51:07 AM (QP5 v5.149.1003.31008) */
CREATE OR REPLACE FORCE VIEW TWFHAJJ.V_LUK_ID_TYPE
(
   LIT_CODE,
   LIT_NAME_AR,
   LIT_NAME_LA
)
AS
   SELECT LIT_CODE, LIT_NAME_AR, LIT_NAME_LA FROM TWFHAJJ.LUK_ID_TYPE;


DROP VIEW TWFHAJJ.V_LUK_JOBS;

/* Formatted on 03/08/2018 07:51:07 AM (QP5 v5.149.1003.31008) */
CREATE OR REPLACE FORCE VIEW TWFHAJJ.V_LUK_JOBS
(
   LJB_CODE,
   LJB_NAME_AR,
   LJB_NAME_LA
)
AS
   SELECT LJB_CODE, LJB_NAME_AR, LJB_NAME_LA FROM TWFHAJJ.LUK_JOBS;


DROP VIEW TWFHAJJ.V_LUK_NATIONALITY;

/* Formatted on 03/08/2018 07:51:07 AM (QP5 v5.149.1003.31008) */
CREATE OR REPLACE FORCE VIEW TWFHAJJ.V_LUK_NATIONALITY
(
   NAT_ID,
   NAT_NAME_AR,
   NAT_NAME_LA
)
AS
   SELECT NAT_ID, NAT_NAME_AR, NAT_NAME_LA FROM TWFHAJJ.LUK_NATIONALITY;
ALTER TABLE TWFHAJJ.CASES_REQUEST MODIFY 
  CR_CODE NULL;

ALTER TABLE TWFHAJJ.CASES_REQUEST MODIFY 
  CR_TYPE NULL;

ALTER TABLE TWFHAJJ.CASES_REQUEST ADD (
  CR_CODE NOT NULL,
  CR_TYPE NOT NULL);

ALTER TABLE TWFHAJJ.LUK_AREA MODIFY 
  LAR_ID NULL;

ALTER TABLE TWFHAJJ.LUK_AREA MODIFY 
  LAR_AREA_NAME_AR NULL;

ALTER TABLE TWFHAJJ.LUK_AREA MODIFY 
  LAR_AREA_NAME_LA NULL;

ALTER TABLE TWFHAJJ.LUK_AREA MODIFY 
  LAR_CITY_ID NULL;

ALTER TABLE TWFHAJJ.LUK_AREA ADD (
  LAR_ID NOT NULL,
  LAR_AREA_NAME_AR NOT NULL,
  LAR_AREA_NAME_LA NOT NULL,
  LAR_CITY_ID NOT NULL);

ALTER TABLE TWFHAJJ.LUK_CITY MODIFY 
  LCT_ID NULL;

ALTER TABLE TWFHAJJ.LUK_CITY MODIFY 
  LCT_NAME_AR NULL;

ALTER TABLE TWFHAJJ.LUK_CITY MODIFY 
  LCT_NAME_LA NULL;

ALTER TABLE TWFHAJJ.LUK_CITY MODIFY 
  LCT_STATUS NULL;

ALTER TABLE TWFHAJJ.LUK_CITY ADD (
  LCT_ID NOT NULL,
  LCT_NAME_AR NOT NULL,
  LCT_NAME_LA NOT NULL,
  LCT_STATUS NOT NULL);
