--
-- PostgreSQL database dump
--

-- Dumped from database version 9.1.3
-- Dumped by pg_dump version 9.1.3
-- Started on 2013-09-04 17:54:05

SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

SET search_path = public, pg_catalog;

--
-- TOC entry 1912 (class 0 OID 34511)
-- Dependencies: 162
-- Data for Name: ad_agency; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO ad_agency VALUES (1, 'Dentsu');
INSERT INTO ad_agency VALUES (2, 'Yomiuri');


--
-- TOC entry 1918 (class 0 OID 34532)
-- Dependencies: 168
-- Data for Name: location; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO location VALUES (5, 'Asakusa');
INSERT INTO location VALUES (4, 'Odaiba');
INSERT INTO location VALUES (3, 'Harajyuku Station (North Entrance)');
INSERT INTO location VALUES (2, 'Akihabara Station (North Entrance)');
INSERT INTO location VALUES (1, 'Shinjuku Station (East Entrance)');
INSERT INTO location VALUES (6, 'Sinagawa');
INSERT INTO location VALUES (7, 'Ginza');
INSERT INTO location VALUES (-1, 'Office One');


--
-- TOC entry 1919 (class 0 OID 34538)
-- Dependencies: 169
-- Data for Name: verified_status; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 1911 (class 0 OID 34508)
-- Dependencies: 161 1912 1918 1919
-- Data for Name: ad; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 1915 (class 0 OID 34520)
-- Dependencies: 165
-- Data for Name: auditor; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO auditor VALUES (1, 'Auditor One', 'a1@audit.co.jp');
INSERT INTO auditor VALUES (2, 'Auditor Two', 'a2@audit.co.jp');
INSERT INTO auditor VALUES (3, 'Third Auditor', 'a3@audit.co.jp');
INSERT INTO auditor VALUES (4, 'Auditor Four', 'a4@audit.co.jp');


--
-- TOC entry 1913 (class 0 OID 34514)
-- Dependencies: 163 1911 1915
-- Data for Name: audit_plan; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 1914 (class 0 OID 34517)
-- Dependencies: 164 1919
-- Data for Name: audit_plan_detail; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 1916 (class 0 OID 34523)
-- Dependencies: 166
-- Data for Name: corporate; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO corporate VALUES (1, 'Panasonic');
INSERT INTO corporate VALUES (2, 'Fujitsu');
INSERT INTO corporate VALUES (3, 'Sony');
INSERT INTO corporate VALUES (4, 'Canon');


--
-- TOC entry 1917 (class 0 OID 34529)
-- Dependencies: 167 1918 1918
-- Data for Name: distance; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO distance VALUES (1, -1, 1, 5);
INSERT INTO distance VALUES (2, -1, 2, 12);
INSERT INTO distance VALUES (3, -1, 3, 7);
INSERT INTO distance VALUES (4, -1, 4, 3);
INSERT INTO distance VALUES (5, -1, 5, 18);
INSERT INTO distance VALUES (6, -1, 6, 14);
INSERT INTO distance VALUES (7, -1, 7, 21);
INSERT INTO distance VALUES (8, 1, -1, 5);
INSERT INTO distance VALUES (9, 1, 2, 11);
INSERT INTO distance VALUES (10, 1, 3, 5);
INSERT INTO distance VALUES (11, 1, 4, 7);
INSERT INTO distance VALUES (12, 1, 5, 15);
INSERT INTO distance VALUES (13, 1, 6, 20);
INSERT INTO distance VALUES (14, 1, 7, 15);
INSERT INTO distance VALUES (15, 2, 1, 11);
INSERT INTO distance VALUES (16, 2, -1, 12);
INSERT INTO distance VALUES (17, 2, 3, 8);
INSERT INTO distance VALUES (18, 2, 4, 16);
INSERT INTO distance VALUES (19, 2, 5, 8);
INSERT INTO distance VALUES (20, 2, 6, 5);
INSERT INTO distance VALUES (21, 2, 7, 35);
INSERT INTO distance VALUES (22, 3, 1, 5);
INSERT INTO distance VALUES (23, 3, 2, 8);
INSERT INTO distance VALUES (24, 3, -1, 7);
INSERT INTO distance VALUES (25, 3, 4, 7);
INSERT INTO distance VALUES (26, 3, 5, 28);
INSERT INTO distance VALUES (27, 3, 6, 11);
INSERT INTO distance VALUES (28, 3, 7, 16);
INSERT INTO distance VALUES (29, 4, 1, 7);
INSERT INTO distance VALUES (30, 4, 2, 16);
INSERT INTO distance VALUES (31, 4, 3, 7);
INSERT INTO distance VALUES (32, 4, -1, 3);
INSERT INTO distance VALUES (33, 4, 5, 18);
INSERT INTO distance VALUES (34, 4, 6, 12);
INSERT INTO distance VALUES (35, 4, 7, 20);
INSERT INTO distance VALUES (36, 5, 1, 15);
INSERT INTO distance VALUES (37, 5, 2, 8);
INSERT INTO distance VALUES (38, 5, 3, 28);
INSERT INTO distance VALUES (39, 5, 4, 18);
INSERT INTO distance VALUES (40, 5, -1, 18);
INSERT INTO distance VALUES (41, 5, 6, 6);
INSERT INTO distance VALUES (42, 5, 7, 28);
INSERT INTO distance VALUES (43, 6, 1, 20);
INSERT INTO distance VALUES (44, 6, 2, 5);
INSERT INTO distance VALUES (45, 6, 3, 11);
INSERT INTO distance VALUES (46, 6, 4, 12);
INSERT INTO distance VALUES (47, 6, 5, 6);
INSERT INTO distance VALUES (48, 6, -1, 14);
INSERT INTO distance VALUES (49, 6, 7, 11);
INSERT INTO distance VALUES (50, 7, 1, 15);
INSERT INTO distance VALUES (51, 7, 2, 35);
INSERT INTO distance VALUES (52, 7, 3, 16);
INSERT INTO distance VALUES (53, 7, 4, 20);
INSERT INTO distance VALUES (54, 7, 5, 28);
INSERT INTO distance VALUES (55, 7, 6, 11);
INSERT INTO distance VALUES (56, 7, -1, 21);


-- Completed on 2013-09-04 17:54:06

--
-- PostgreSQL database dump complete
--

