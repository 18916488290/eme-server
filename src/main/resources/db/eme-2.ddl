
CREATE TABLE administrative_division
(
	id                    INTEGER NOT NULL,
	division              VARCHAR(64) NOT NULL
)
;



ALTER TABLE administrative_division
	ADD  PRIMARY KEY (id)
;



CREATE TABLE aqi_info
(
	id                    INTEGER NOT NULL,
	ilow                  FLOAT NULL,
	ihigh                 FLOAT NULL,
	lvl                   VARCHAR(20) NULL,
	description           VARCHAR(20) NULL,
	color_description     VARCHAR(20) NULL,
	color                 VARCHAR(20) NULL,
	health_description    VARCHAR(64) NULL,
	advice                VARCHAR(64) NULL
)
;



ALTER TABLE aqi_info
	ADD  PRIMARY KEY (id)
;



CREATE TABLE company
(
	id                    INTEGER NOT NULL,
	creator               VARCHAR(64) NOT NULL,
	creation_date         DATE NULL,
	company_name          VARCHAR(128) NOT NULL,
	lat                   VARCHAR(20) NULL,
	lng                   VARCHAR(20) NULL,
	address               VARCHAR(256) NULL,
	id_operation_maintance_company  INTEGER NULL,
	id_administrative     INTEGER NULL,
	id_industry_sector    INTEGER NULL,
	id_concern_degree     INTEGER NULL,
	id_administrative_division  INTEGER NULL,
	auditor               VARCHAR(64) NULL,
	audit_date            DATE NULL,
	comment               VARCHAR(128) NULL,
	status                INTEGER NOT NULL,
	id_house_plan         INTEGER NULL,
	registration_code     VARCHAR(64) NULL,
	license_code          VARCHAR(64) NULL,
	corporation           VARCHAR(20) NULL,
	corporation_fax       VARCHAR(20) NULL,
	url_360               VARCHAR(256) NULL
)
;



ALTER TABLE company
	ADD  PRIMARY KEY (id)
;



CREATE TABLE data_collection_device
(
	mn                    VARCHAR(64) NULL,
	device_name           VARCHAR(20) NULL,
	id_detect_station     INTEGER NULL,
	lat                   VARCHAR(20) NULL,
	lng                   VARCHAR(20) NULL,
	id_company            INTEGER NULL
)
;



ALTER TABLE data_collection_device
	ADD  PRIMARY KEY (mn)
;



CREATE TABLE detect_air
(
	id                    INTEGER NOT NULL,
	id_detect_station     INTEGER NULL,
	id_detect_factor      INTEGER NULL,
	avg_val               FLOAT NULL,
	report_time           TIMESTAMP NULL,
	is_daily              boolean NULL,
	val                   FLOAT NULL
)
;



ALTER TABLE detect_air
	ADD  PRIMARY KEY (id)
;



CREATE TABLE detect_air_report
(
	id                    INTEGER NOT NULL,
	id_detect_station     INTEGER NULL,
	id_detect_content     INTEGER NULL,
	report_time           TIMESTAMP NULL,
	is_daily              boolean NULL,
	aqi                   FLOAT NULL,
	so2_aqi               FLOAT NULL,
	o3_aqi                FLOAT NULL,
	no2_aqi               FLOAT NULL,
	pm10_aqi              FLOAT NULL,
	pm25_aqi              FLOAT NULL,
	co_aqi                FLOAT NULL,
	id_aqi_info           INTEGER NULL
)
;



ALTER TABLE detect_air_report
	ADD  PRIMARY KEY (id)
;



CREATE TABLE detect_category
(
	id                    INTEGER NULL,
	detect_category       VARCHAR(20) NULL
)
;



ALTER TABLE detect_category
	ADD  PRIMARY KEY (id)
;



CREATE TABLE detect_content_dic
(
	id                    INTEGER NOT NULL,
	detect_content        VARCHAR(64) NULL
)
;



ALTER TABLE detect_content_dic
	ADD  PRIMARY KEY (id)
;



CREATE TABLE detect_factor
(
	id                    INTEGER NOT NULL,
	factor_name           VARCHAR(64) NULL,
	chemical_name         VARCHAR(64) NULL,
	min_val               FLOAT NOT NULL,
	max_val               FLOAT NULL,
	min_x_val             FLOAT NULL,
	max_x_val             FLOAT NULL,
	id_detect_content     INTEGER NULL,
	id_detect_category    INTEGER NULL,
	unit                  VARCHAR(20) NULL,
	frequency             INTEGER NULL,
	factor_code           VARCHAR(64) NULL
)
;



ALTER TABLE detect_factor
	ADD  PRIMARY KEY (id)
;



CREATE TABLE detect_factor_current_values
(
	id                    INTEGER NOT NULL,
	mn                    VARCHAR(64) NULL,
	id_factor             INTEGER NULL,
	val                   FLOAT NULL,
	detect_time           TIMESTAMP NULL,
	upload_time           TIMESTAMP NULL,
	opt1                  VARCHAR(64) NULL,
	opt2                  VARCHAR(64) NULL,
	opt3                  VARCHAR(64) NULL,
	opt4                  VARCHAR(64) NULL,
	opt5                  VARCHAR(64) NULL
)
;



ALTER TABLE detect_factor_current_values
	ADD  PRIMARY KEY (id)
;



CREATE TABLE detect_factor_values
(
	id                    INTEGER NOT NULL,
	mn                    VARCHAR(64) NULL,
	id_factor             INTEGER NULL,
	upload_time           TIMESTAMP NULL,
	detect_time           TIMESTAMP NULL,
	min_val               FLOAT NULL,
	_default_             CHAR(18) NULL,
	max_val               FLOAT NULL,
	avg_val               FLOAT NULL,
	zs_avg_val            FLOAT NULL,
	zs_min_val            FLOAT NULL,
	zs_max_val            FLOAT NULL,
	cou_val               FLOAT NULL,
	zs_cou_val            FLOAT NULL,
	low_val               FLOAT NULL,
	up_val                FLOAT NULL,
	type                  INTEGER NULL
)
;



ALTER TABLE detect_factor_values
	ADD  PRIMARY KEY (id)
;



CREATE TABLE detect_station
(
	id                    INTEGER NULL,
	detect_station_name   VARCHAR(64) NULL,
	lat                   VARCHAR(20) NULL,
	lng                   VARCHAR(20) NULL,
	id_epb                INTEGER NULL,
	id_divsion            INTEGER NULL
)
;



ALTER TABLE detect_station
	ADD  PRIMARY KEY (id)
;



CREATE TABLE detect_station_content
(
	id_dectect_station    INTEGER NOT NULL,
	id_detect_content     INTEGER NOT NULL,
	seq                   INTEGER NULL
)
;



ALTER TABLE detect_station_content
	ADD  PRIMARY KEY (id_dectect_station,id_detect_content)
;



CREATE TABLE epb
(
	id                    INTEGER NULL,
	superior              INTEGER NULL,
	epb_name              VARCHAR(64) NOT NULL,
	creator               VARCHAR(64) NULL,
	creation_date         DATE NULL,
	lat                   VARCHAR(20) NULL,
	lng                   VARCHAR(20) NULL,
	address               VARCHAR(128) NULL,
	id_division           INTEGER NULL
)
;



ALTER TABLE epb
	ADD  PRIMARY KEY (id)
;



CREATE TABLE iaqi_info
(
	id                    INTEGER NOT NULL,
	id_factor             INTEGER NULL,
	id_aqi_info           INTEGER NULL,
	clow                  FLOAT NULL,
	chigh                 FLOAT NULL
)
;



ALTER TABLE iaqi_info
	ADD  PRIMARY KEY (id)
;



CREATE TABLE users
(
	username              VARCHAR(64) NOT NULL,
	password              VARCHAR(128) NULL,
	mobile                VARCHAR(64) NULL,
	real_name             VARCHAR(20) NULL,
	user_type             INTEGER NOT NULL,
	token                 VARCHAR(128) NULL,
	enabled               boolean NULL,
	id_epb                INTEGER NULL
)
;



ALTER TABLE users
	ADD  PRIMARY KEY (username)
;



ALTER TABLE company
	ADD FOREIGN KEY R_9 (creator) REFERENCES users(username)
;


ALTER TABLE company
	ADD FOREIGN KEY R_10 (id_operation_maintance_company) REFERENCES operation_maintance_company(id)
;


ALTER TABLE company
	ADD FOREIGN KEY R_11 (id_administrative) REFERENCES administrative_dic(id)
;


ALTER TABLE company
	ADD FOREIGN KEY R_12 (id_industry_sector) REFERENCES industry_sector_dic(id)
;


ALTER TABLE company
	ADD FOREIGN KEY R_13 (id_concern_degree) REFERENCES concern_degree_dic(id)
;


ALTER TABLE company
	ADD FOREIGN KEY R_14 (id_administrative_division) REFERENCES administrative_division(id)
;


ALTER TABLE company
	ADD FOREIGN KEY R_15 (auditor) REFERENCES users(username)
;


ALTER TABLE company
	ADD FOREIGN KEY R_28 (id_house_plan) REFERENCES house_plan(id)
;



ALTER TABLE data_collection_device
	ADD FOREIGN KEY R_65 (id_detect_station) REFERENCES detect_station(id)
;


ALTER TABLE data_collection_device
	ADD FOREIGN KEY R_77 (id_company) REFERENCES company(id)
;



ALTER TABLE detect_air
	ADD FOREIGN KEY R_75 (id_detect_station) REFERENCES detect_station(id)
;


ALTER TABLE detect_air
	ADD FOREIGN KEY R_76 (id_detect_factor) REFERENCES detect_factor(id)
;



ALTER TABLE detect_air_report
	ADD FOREIGN KEY R_79 (id_detect_station) REFERENCES detect_station(id)
;


ALTER TABLE detect_air_report
	ADD FOREIGN KEY R_80 (id_detect_content) REFERENCES detect_content_dic(id)
;


ALTER TABLE detect_air_report
	ADD FOREIGN KEY R_81 (id_aqi_info) REFERENCES aqi_info(id)
;



ALTER TABLE detect_factor
	ADD FOREIGN KEY R_61 (id_detect_category) REFERENCES detect_category(id)
;


ALTER TABLE detect_factor
	ADD FOREIGN KEY R_77 (id_detect_content) REFERENCES detect_content_dic(id)
;



ALTER TABLE detect_factor_current_values
	ADD FOREIGN KEY R_92 (mn) REFERENCES data_collection_device(mn)
;


ALTER TABLE detect_factor_current_values
	ADD FOREIGN KEY R_93 (id_factor) REFERENCES detect_factor(id)
;



ALTER TABLE detect_factor_values
	ADD FOREIGN KEY R_90 (mn) REFERENCES data_collection_device(mn)
;


ALTER TABLE detect_factor_values
	ADD FOREIGN KEY R_91 (id_factor) REFERENCES detect_factor(id)
;



ALTER TABLE detect_station
	ADD FOREIGN KEY R_59 (id_epb) REFERENCES epb(id)
;


ALTER TABLE detect_station
	ADD FOREIGN KEY R_60 (id_divsion) REFERENCES administrative_division(id)
;



ALTER TABLE detect_station_content
	ADD FOREIGN KEY R_73 (id_dectect_station) REFERENCES detect_station(id)
;


ALTER TABLE detect_station_content
	ADD FOREIGN KEY R_74 (id_detect_content) REFERENCES detect_content_dic(id)
;



ALTER TABLE epb
	ADD FOREIGN KEY R_18 (creator) REFERENCES users(username)
;


ALTER TABLE epb
	ADD FOREIGN KEY R_19 (superior) REFERENCES epb(id)
;


ALTER TABLE epb
	ADD FOREIGN KEY R_20 (id_division) REFERENCES administrative_division(id)
;



ALTER TABLE iaqi_info
	ADD FOREIGN KEY R_71 (id_factor) REFERENCES detect_factor(id)
;


ALTER TABLE iaqi_info
	ADD FOREIGN KEY R_72 (id_aqi_info) REFERENCES aqi_info(id)
;



ALTER TABLE users
	ADD FOREIGN KEY R_22 (id_epb) REFERENCES epb(id)
;


