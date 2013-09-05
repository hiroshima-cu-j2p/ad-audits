-- Sequence: adidseq

DROP SEQUENCE adidseq;

CREATE SEQUENCE adidseq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE adidseq
  OWNER TO postgres;

-- Set auto-increment value to primary key column ad_id
ALTER TABLE ad
ALTER COLUMN ad_id
SET DEFAULT NEXTVAL('adidseq');

-- Add Login functionality
ALTER TABLE corporate
  ADD COLUMN corporate_uid character varying(50) NOT NULL DEFAULT 'user@corp.com';
ALTER TABLE corporate
  ADD COLUMN corporate_pwd character varying(40) NOT NULL DEFAULT 'cG9zdGdyZXM=';
ALTER TABLE auditor
  ADD COLUMN auditor_pwd character varying(40) NOT NULL DEFAULT 'cG9zdGdyZXM=';
ALTER TABLE auditor
  ADD COLUMN auditor_is_mgr boolean NOT NULL DEFAULT FALSE;


CREATE SEQUENCE audit_plan_detail_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE audit_plan_detail_seq
  OWNER TO postgres;
  
-- Set auto-increment value to primary key column ad_id
ALTER TABLE audit_plan_detail
ALTER COLUMN apd_detail_id
SET DEFAULT NEXTVAL('audit_plan_detail_seq'); 
