--
-- PostgreSQL database dump
--

-- Dumped from database version 9.2.1
-- Dumped by pg_dump version 9.2.1
-- Started on 2013-09-04 19:31:33

SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 177 (class 3079 OID 11727)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 1995 (class 0 OID 0)
-- Dependencies: 177
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

-- Database: audit

-- DROP DATABASE audit;

-- CREATE DATABASE audit
--   WITH OWNER = postgres
--        ENCODING = 'UTF8'
--        TABLESPACE = pg_default
--        LC_COLLATE = 'English_United States.1252'
--        LC_CTYPE = 'English_United States.1252'
--        CONNECTION LIMIT = -1;


--
-- TOC entry 174 (class 1259 OID 16624)
-- Name: ad; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE ad (
    ad_id integer NOT NULL,
    ad_product_name character varying(128),
    ad_location integer,
    ad_description character varying(256),
    ad_verified_status integer,
    ad_agency_id integer,
    ad_corporate_id integer
);


ALTER TABLE public.ad OWNER TO postgres;

--
-- TOC entry 168 (class 1259 OID 16506)
-- Name: ad_agency; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE ad_agency (
    agency_id integer NOT NULL,
    agency_name character varying(128)
);


ALTER TABLE public.ad_agency OWNER TO postgres;

--
-- TOC entry 175 (class 1259 OID 16645)
-- Name: audit_plan; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE audit_plan (
    audit_plan_id integer NOT NULL,
    audit_plan_date date,
    audit_plan_ad_id integer,
    audit_plan_auditor_id integer
);


ALTER TABLE public.audit_plan OWNER TO postgres;

--
-- TOC entry 176 (class 1259 OID 16686)
-- Name: audit_plan_detail; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE audit_plan_detail (
    apd_detail_id integer NOT NULL,
    apd_plan_id integer,
    apd_verified_status integer,
    apd_comment character varying(256),
    apd_time timestamp without time zone
);


ALTER TABLE public.audit_plan_detail OWNER TO postgres;

--
-- TOC entry 169 (class 1259 OID 16512)
-- Name: auditor; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE auditor (
    auditor_id integer NOT NULL,
    auditor_name character varying(128),
    auditor_email character varying(128)
);


ALTER TABLE public.auditor OWNER TO postgres;

--
-- TOC entry 170 (class 1259 OID 16515)
-- Name: corporate; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE corporate (
    corporate_id integer NOT NULL,
    corporate_name character varying
);


ALTER TABLE public.corporate OWNER TO postgres;

--
-- TOC entry 171 (class 1259 OID 16521)
-- Name: distance; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE distance (
    distance_id integer NOT NULL,
    distance_from_location integer,
    distance_to_location integer,
    distance_distance integer
);


ALTER TABLE public.distance OWNER TO postgres;

--
-- TOC entry 172 (class 1259 OID 16524)
-- Name: location; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE location (
    location_id integer NOT NULL,
    location_name character varying
);


ALTER TABLE public.location OWNER TO postgres;

--
-- TOC entry 173 (class 1259 OID 16533)
-- Name: verified_status; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE verified_status (
    verified_status_id integer NOT NULL,
    verified_status_name character varying(128)
);


ALTER TABLE public.verified_status OWNER TO postgres;


--
-- TOC entry 1949 (class 2606 OID 16537)
-- Name: ad_agency_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY ad_agency
    ADD CONSTRAINT ad_agency_pkey PRIMARY KEY (agency_id);


--
-- TOC entry 1961 (class 2606 OID 16628)
-- Name: ad_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY ad
    ADD CONSTRAINT ad_pkey PRIMARY KEY (ad_id);


--
-- TOC entry 1968 (class 2606 OID 16690)
-- Name: apd_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY audit_plan_detail
    ADD CONSTRAINT apd_pkey PRIMARY KEY (apd_detail_id);


--
-- TOC entry 1964 (class 2606 OID 16649)
-- Name: audit_plan_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY audit_plan
    ADD CONSTRAINT audit_plan_pkey PRIMARY KEY (audit_plan_id);


--
-- TOC entry 1951 (class 2606 OID 16543)
-- Name: auditor_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY auditor
    ADD CONSTRAINT auditor_pkey PRIMARY KEY (auditor_id);


--
-- TOC entry 1953 (class 2606 OID 16545)
-- Name: corporate_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY corporate
    ADD CONSTRAINT corporate_pkey PRIMARY KEY (corporate_id);


--
-- TOC entry 1955 (class 2606 OID 16547)
-- Name: distance_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY distance
    ADD CONSTRAINT distance_pkey PRIMARY KEY (distance_id);


--
-- TOC entry 1957 (class 2606 OID 16549)
-- Name: location_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY location
    ADD CONSTRAINT location_pkey PRIMARY KEY (location_id);


--
-- TOC entry 1959 (class 2606 OID 16553)
-- Name: verified_status_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY verified_status
    ADD CONSTRAINT verified_status_pkey PRIMARY KEY (verified_status_id);


--
-- TOC entry 1962 (class 1259 OID 16644)
-- Name: fki_ad_ad_agency_id; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX fki_ad_ad_agency_id ON ad USING btree (ad_agency_id);


--
-- TOC entry 1965 (class 1259 OID 16660)
-- Name: fki_audit_plan_auditor_id_fkey; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX fki_audit_plan_auditor_id_fkey ON audit_plan USING btree (audit_plan_auditor_id);


--
-- TOC entry 1966 (class 1259 OID 16661)
-- Name: fki_audit_plan_plan_detial_fkey; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX fki_audit_plan_plan_detial_fkey ON audit_plan USING btree (audit_plan_ad_id);


--
-- TOC entry 1969 (class 1259 OID 16696)
-- Name: fki_plan_detail_ad_id; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX fki_plan_detail_ad_id ON audit_plan_detail USING btree (apd_plan_id);


--
-- TOC entry 1970 (class 1259 OID 16697)
-- Name: fki_plan_detail_status_verified_id; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX fki_plan_detail_status_verified_id ON audit_plan_detail USING btree (apd_verified_status);


--
-- TOC entry 1973 (class 2606 OID 16629)
-- Name: ad_ad_agency_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ad
    ADD CONSTRAINT ad_ad_agency_id_fkey FOREIGN KEY (ad_agency_id) REFERENCES ad_agency(agency_id);


--
-- TOC entry 1974 (class 2606 OID 16634)
-- Name: ad_location_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ad
    ADD CONSTRAINT ad_location_fkey FOREIGN KEY (ad_location) REFERENCES location(location_id);


--
-- TOC entry 1975 (class 2606 OID 16639)
-- Name: ad_verified_status_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ad
    ADD CONSTRAINT ad_verified_status_fkey FOREIGN KEY (ad_verified_status) REFERENCES verified_status(verified_status_id);


--
-- TOC entry 1978 (class 2606 OID 16691)
-- Name: apd_verified_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY audit_plan_detail
    ADD CONSTRAINT apd_verified_id_fkey FOREIGN KEY (apd_verified_status) REFERENCES verified_status(verified_status_id);


--
-- TOC entry 1976 (class 2606 OID 16650)
-- Name: audit_plan_ad_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY audit_plan
    ADD CONSTRAINT audit_plan_ad_id_fkey FOREIGN KEY (audit_plan_ad_id) REFERENCES ad(ad_id);


--
-- TOC entry 1977 (class 2606 OID 16655)
-- Name: audit_plan_auditor_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY audit_plan
    ADD CONSTRAINT audit_plan_auditor_id_fkey FOREIGN KEY (audit_plan_auditor_id) REFERENCES auditor(auditor_id);


--
-- TOC entry 1971 (class 2606 OID 16604)
-- Name: distance_from_location_location_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY distance
    ADD CONSTRAINT distance_from_location_location_fkey FOREIGN KEY (distance_from_location) REFERENCES location(location_id);


--
-- TOC entry 1972 (class 2606 OID 16609)
-- Name: distance_to_location_location_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY distance
    ADD CONSTRAINT distance_to_location_location_fkey FOREIGN KEY (distance_to_location) REFERENCES location(location_id);


--
-- TOC entry 1994 (class 0 OID 0)
-- Dependencies: 6
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2013-09-04 19:31:34

--
-- PostgreSQL database dump complete
--

