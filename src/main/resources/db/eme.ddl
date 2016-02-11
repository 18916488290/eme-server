
CREATE TABLE administrative_dic
(
	id                    INTEGER NOT NULL,
	administrative        VARCHAR(64) NOT NULL
)
;



ALTER TABLE administrative_dic
	ADD  PRIMARY KEY (id)
;



CREATE TABLE administrative_division
(
	id                    INTEGER NOT NULL,
	division              VARCHAR(64) NOT NULL
)
;



ALTER TABLE administrative_division
	ADD  PRIMARY KEY (id)
;



CREATE TABLE air_env
(
	id                    INTEGER NOT NULL,
	air_env_name          VARCHAR(64) NOT NULL,
	lat                   FLOAT NULL,
	lng                   FLOAT NULL,
	eme_person            VARCHAR(20) NULL,
	eme_mobile            VARCHAR(20) NULL,
	id_air_env_type       INTEGER NULL,
	id_env_func           INTEGER NULL
)
;



ALTER TABLE air_env
	ADD  PRIMARY KEY (id)
;



CREATE TABLE air_env_type
(
	id                    INTEGER NOT NULL,
	air_env_type          VARCHAR(64) NOT NULL
)
;



ALTER TABLE air_env_type
	ADD  PRIMARY KEY (id)
;



CREATE TABLE chemical_material
(
	id                    INTEGER NOT NULL,
	id_company            INTEGER NULL,
	material_name         VARCHAR(64) NULL,
	chemical_name         VARCHAR(64) NULL,
	cas                   VARCHAR(64) NULL,
	quantity              FLOAT NULL,
	annual_output         FLOAT NULL,
	purpose               VARCHAR(64) NULL,
	is_hazardous          boolean NULL,
	id_physical_state     INTEGER NULL,
	id_material_category  INTEGER NULL,
	id_storage_mode       INTEGER NULL,
	id_equipment_state    INTEGER NULL,
	id_production_mode    INTEGER NULL,
	id_material_type      INTEGER NULL
)
;



ALTER TABLE chemical_material
	ADD  PRIMARY KEY (id)
;



CREATE TABLE company
(
	id                    INTEGER NOT NULL,
	creator               VARCHAR(64) NOT NULL,
	creation_date         DATE NULL,
	company_name          VARCHAR(128) NOT NULL,
	lat                   FLOAT NULL,
	lng                   FLOAT NULL,
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
	id_risk_basic_info    INTEGER NOT NULL,
	id_house_plan         INTEGER NULL
)
;



ALTER TABLE company
	ADD  PRIMARY KEY (id)
;



CREATE TABLE company_air_env
(
	id_air_env            INTEGER NOT NULL,
	id_company            INTEGER NOT NULL,
	distance              INTEGER NULL,
	id_location           INTEGER NULL
)
;



ALTER TABLE company_air_env
	ADD  PRIMARY KEY (id_air_env,id_company)
;



CREATE TABLE company_water_env
(
	id_company            INTEGER NOT NULL,
	distance              INTEGER NOT NULL,
	location              VARCHAR(20) NULL
)
;



ALTER TABLE company_water_env
	ADD  PRIMARY KEY (id_company)
;



CREATE TABLE concern_degree_dic
(
	id                    INTEGER NOT NULL,
	concern_degree        VARCHAR(64) NOT NULL
)
;



ALTER TABLE concern_degree_dic
	ADD  PRIMARY KEY (id)
;



CREATE TABLE data_collection_device
(
	mn                    VARCHAR(64) NULL,
	device_name           VARCHAR(20) NULL,
	id_detect_station     INTEGER NULL
)
;



ALTER TABLE data_collection_device
	ADD  PRIMARY KEY (mn)
;



CREATE TABLE detect
(
	id_detect_station     INTEGER NOT NULL,
	id_detect_factor      INTEGER NOT NULL,
	mn                    VARCHAR(64) NULL,
	detect_time           TIMESTAMP NULL,
	val                   FLOAT NULL
)
;



ALTER TABLE detect
	ADD  PRIMARY KEY (id_detect_station,id_detect_factor)
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



CREATE TABLE detect_factor
(
	id                    INTEGER NOT NULL,
	factor_name           VARCHAR(64) NULL,
	nadir                 FLOAT NOT NULL,
	utopia                FLOAT NULL,
	reservation           FLOAT NULL,
	aspiration            FLOAT NULL,
	id_detect_category    INTEGER NULL,
	unit                  VARCHAR(20) NULL,
	frequency             INTEGER NULL
)
;



ALTER TABLE detect_factor
	ADD  PRIMARY KEY (id)
;



CREATE TABLE detect_history
(
	id                    INTEGER NOT NULL,
	id_detect_station     INTEGER NOT NULL,
	id_detect_factor      INTEGER NULL,
	mn                    VARCHAR(64) NULL,
	detect_time           TIMESTAMP NULL,
	val                   FLOAT NULL
)
;



ALTER TABLE detect_history
	ADD  PRIMARY KEY (id)
;



CREATE TABLE detect_station
(
	id                    INTEGER NULL,
	detect_station_name   VARCHAR(64) NULL,
	lat                   FLOAT NULL,
	lng                   FLOAT NULL,
	id_epb                INTEGER NULL,
	id_divsion            INTEGER NULL
)
;



ALTER TABLE detect_station
	ADD  PRIMARY KEY (id)
;



CREATE TABLE emergency_material
(
	id                    INTEGER NOT NULL,
	id_company            INTEGER NULL,
	creator               VARCHAR(64) NULL,
	creation_date         DATE NULL,
	material_name         VARCHAR(128) NOT NULL,
	quantity              DATE NULL,
	material_code         VARCHAR(128) NULL,
	mobile                VARCHAR(64) NULL,
	address               VARCHAR(64) NULL,
	lat                   FLOAT NULL,
	lng                   FLOAT NULL,
	occasion              VARCHAR(64) NULL,
	func                  VARCHAR(64) NULL,
	purpose               VARCHAR(64) NULL,
	note                  VARCHAR(64) NULL,
	auditor               VARCHAR(64) NULL,
	audit_date            DATE NULL,
	comment               VARCHAR(64) NULL,
	status                INTEGER NULL
)
;



ALTER TABLE emergency_material
	ADD  PRIMARY KEY (id)
;



CREATE TABLE emergency_reponse_plan_type
(
	id                    INTEGER NOT NULL,
	emergency_response_plan_type  VARCHAR(20) NULL
)
;



ALTER TABLE emergency_reponse_plan_type
	ADD  PRIMARY KEY (id)
;



CREATE TABLE emergency_response_plan
(
	id                    INTEGER NOT NULL,
	title                 VARCHAR(64) NULL,
	creation_date         DATE NULL,
	regist_code           VARCHAR(64) NULL,
	file_name             VARCHAR(64) NULL,
	id_company            INTEGER NULL,
	id_epb                INTEGER NULL,
	id_emergency_response_plan_type  INTEGER NULL
)
;



ALTER TABLE emergency_response_plan
	ADD  PRIMARY KEY (id)
;



CREATE TABLE env_func
(
	id                    INTEGER NOT NULL,
	env_func              VARCHAR(20) NULL
)
;



ALTER TABLE env_func
	ADD  PRIMARY KEY (id)
;



CREATE TABLE env_prot_person
(
	id                    INTEGER NOT NULL,
	real_name             VARCHAR(20) NULL,
	gender                VARCHAR(20) NULL,
	title                 VARCHAR(20) NULL,
	birth                 VARCHAR(20) NULL,
	mobile                VARCHAR(20) NULL,
	tel                   VARCHAR(20) NULL,
	major                 VARCHAR(20) NULL,
	position              VARCHAR(20) NULL,
	id_company            INTEGER NULL
)
;



ALTER TABLE env_prot_person
	ADD  PRIMARY KEY (id)
;



CREATE TABLE epb
(
	id                    INTEGER NULL,
	superior              INTEGER NULL,
	epb_name              VARCHAR(64) NOT NULL,
	creator               VARCHAR(64) NULL,
	creation_date         DATE NULL,
	lat                   FLOAT NULL,
	lng                   FLOAT NULL,
	address               VARCHAR(128) NULL,
	id_division           INTEGER NULL
)
;



ALTER TABLE epb
	ADD  PRIMARY KEY (id)
;



CREATE TABLE equipment_risk
(
	id                    INTEGER NOT NULL,
	equipment_name        VARCHAR(64) NULL,
	lat                   FLOAT NULL,
	lng                   FLOAT NULL,
	install_address       VARCHAR(64) NULL,
	brand                 VARCHAR(64) NULL,
	install_date          DATE NULL,
	lifetime              VARCHAR(20) NULL,
	equipment_model       VARCHAR(64) NULL,
	risk_des              VARCHAR(256) NULL,
	id_company            INTEGER NULL
)
;



ALTER TABLE equipment_risk
	ADD  PRIMARY KEY (id)
;



CREATE TABLE equipment_state
(
	id                    INTEGER NOT NULL,
	equipment_state       VARCHAR(20) NULL
)
;



ALTER TABLE equipment_state
	ADD  PRIMARY KEY (id)
;



CREATE TABLE group_authorities
(
	authority             VARCHAR(64) NOT NULL,
	group_id              INTEGER NOT NULL
)
;



ALTER TABLE group_authorities
	ADD  PRIMARY KEY (authority,group_id)
;



CREATE TABLE group_members
(
	id                    INTEGER NULL,
	username              VARCHAR(64) NOT NULL,
	group_id              INTEGER NOT NULL
)
;



ALTER TABLE group_members
	ADD  PRIMARY KEY (id)
;



CREATE TABLE groups
(
	id                    INTEGER NULL,
	group_name            VARCHAR(64) NOT NULL,
	description           VARCHAR(512) NULL
)
;



ALTER TABLE groups
	ADD  PRIMARY KEY (id)
;



CREATE TABLE house_plan
(
	id                    INTEGER NOT NULL,
	file_name             VARCHAR(256) NOT NULL
)
;



ALTER TABLE house_plan
	ADD  PRIMARY KEY (id)
;



CREATE TABLE industrial_park
(
	id                    INTEGER NOT NULL,
	industrial_park_name  VARCHAR(64) NOT NULL
)
;



ALTER TABLE industrial_park
	ADD  PRIMARY KEY (id)
;



CREATE TABLE industry_sector_dic
(
	id                    INTEGER NOT NULL,
	industry_sector       VARCHAR(64) NOT NULL
)
;



ALTER TABLE industry_sector_dic
	ADD  PRIMARY KEY (id)
;



CREATE TABLE location_dic
(
	id                    INTEGER NOT NULL,
	location              VARCHAR(20) NOT NULL
)
;



ALTER TABLE location_dic
	ADD  PRIMARY KEY (id)
;



CREATE TABLE material_category
(
	id                    INTEGER NOT NULL,
	material_category     VARCHAR(64) NOT NULL
)
;



ALTER TABLE material_category
	ADD  PRIMARY KEY (id)
;



CREATE TABLE material_type
(
	id                    INTEGER NOT NULL,
	material_type         VARCHAR(20) NOT NULL
)
;



ALTER TABLE material_type
	ADD  PRIMARY KEY (id)
;



CREATE TABLE operation_maintance_company
(
	id                    INTEGER NOT NULL,
	company_name          VARCHAR(128) NULL
)
;



ALTER TABLE operation_maintance_company
	ADD  PRIMARY KEY (id)
;



CREATE TABLE persistent_logins
(
	series                VARCHAR(64) NOT NULL,
	username              VARCHAR(64) NOT NULL,
	token                 VARCHAR(64) NOT NULL,
	last_used             TIMESTAMP NOT NULL
)
;



ALTER TABLE persistent_logins
	ADD  PRIMARY KEY (series)
;



CREATE TABLE physical_state
(
	id                    INTEGER NOT NULL,
	physical_state        VARCHAR(20) NULL
)
;



ALTER TABLE physical_state
	ADD  PRIMARY KEY (id)
;



CREATE TABLE product_status
(
	id                    INTEGER NOT NULL,
	product_status        VARCHAR(20) NULL
)
;



ALTER TABLE product_status
	ADD  PRIMARY KEY (id)
;



CREATE TABLE production_mode
(
	id                    INTEGER NOT NULL,
	production_mode       VARCHAR(20) NOT NULL
)
;



ALTER TABLE production_mode
	ADD  PRIMARY KEY (id)
;



CREATE TABLE risk_aversion
(
	id                    INTEGER NOT NULL,
	id_company            INTEGER NULL,
	remark                VARCHAR(256) NULL,
	auditor               VARCHAR(20) NULL,
	audit_org             VARCHAR(64) NULL,
	file_name             VARCHAR(64) NULL,
	id_risk_aversion_type  INTEGER NULL
)
;



ALTER TABLE risk_aversion
	ADD  PRIMARY KEY (id)
;



CREATE TABLE risk_aversion_options
(
	id_risk_aversion      INTEGER NOT NULL,
	id_risk_aversion_option  INTEGER NOT NULL,
	checked               boolean NOT NULL
)
;



ALTER TABLE risk_aversion_options
	ADD  PRIMARY KEY (id_risk_aversion,id_risk_aversion_option)
;



CREATE TABLE risk_aversion_options_dic
(
	id                    INTEGER NOT NULL,
	risk_aversion_options  VARCHAR(64) NOT NULL
)
;



ALTER TABLE risk_aversion_options_dic
	ADD  PRIMARY KEY (id)
;



CREATE TABLE risk_aversion_type
(
	id                    INTEGER NOT NULL,
	risk_aversion_type    VARCHAR(20) NULL
)
;



ALTER TABLE risk_aversion_type
	ADD  PRIMARY KEY (id)
;



CREATE TABLE risk_basic_info
(
	id                    INTEGER NULL,
	creation_date         DATE NULL,
	registration_code     VARCHAR(64) NULL,
	license_code          VARCHAR(64) NULL,
	corporation           VARCHAR(20) NULL,
	corporation_fax       VARCHAR(20) NULL,
	area                  FLOAT NULL,
	id_industrial_park    INTEGER NULL,
	id_product_status     INTEGER NULL,
	eme_person            VARCHAR(20) NULL,
	eme_mobile            VARCHAR(20) NULL
)
;



ALTER TABLE risk_basic_info
	ADD  PRIMARY KEY (id)
;



CREATE TABLE storage_method
(
	id                    INTEGER NOT NULL,
	storage_method        VARCHAR(20) NULL
)
;



ALTER TABLE storage_method
	ADD  PRIMARY KEY (id)
;



CREATE TABLE storage_mode
(
	id                    INTEGER NULL,
	storage_mode          VARCHAR(20) NULL
)
;



ALTER TABLE storage_mode
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



CREATE TABLE warehouse_risk
(
	id                    INTEGER NOT NULL,
	warehouse_name        VARCHAR(64) NULL,
	area                  FLOAT NULL,
	lat                   FLOAT NULL,
	lng                   FLOAT NULL,
	volume                FLOAT NULL,
	material_name         VARCHAR(64) NULL,
	material_volume       FLOAT NULL,
	last_modified         DATE NULL,
	file_name             VARCHAR(64) NULL,
	id_company            INTEGER NULL,
	id_storage_method     INTEGER NULL
)
;



ALTER TABLE warehouse_risk
	ADD  PRIMARY KEY (id)
;



CREATE TABLE water_env
(
	water_env_name        VARCHAR(64) NULL,
	lat                   FLOAT NULL,
	lng                   FLOAT NULL,
	eme_person            VARCHAR(20) NULL,
	eme_mobile            VARCHAR(20) NULL,
	id_water_env_type     INTEGER NULL,
	id_env_func           INTEGER NULL
)
;



CREATE TABLE water_env_type
(
	id                    INTEGER NULL,
	water_env_type        VARCHAR(64) NOT NULL
)
;



ALTER TABLE water_env_type
	ADD  PRIMARY KEY (id)
;



CREATE TABLE workmanship
(
	id                    INTEGER NOT NULL,
	title                 VARCHAR(64) NOT NULL,
	description           VARCHAR(1024) NULL,
	file_name             VARCHAR(64) NULL,
	id_company            INTEGER NULL
)
;



ALTER TABLE workmanship
	ADD  PRIMARY KEY (id)
;



ALTER TABLE air_env
	ADD FOREIGN KEY R_46 (id_air_env_type) REFERENCES air_env_type(id)
;


ALTER TABLE air_env
	ADD FOREIGN KEY R_47 (id_env_func) REFERENCES env_func(id)
;



ALTER TABLE chemical_material
	ADD FOREIGN KEY R_29 (id_company) REFERENCES company(id)
;


ALTER TABLE chemical_material
	ADD FOREIGN KEY R_30 (id_physical_state) REFERENCES physical_state(id)
;


ALTER TABLE chemical_material
	ADD FOREIGN KEY R_31 (id_material_category) REFERENCES material_category(id)
;


ALTER TABLE chemical_material
	ADD FOREIGN KEY R_32 (id_storage_mode) REFERENCES storage_mode(id)
;


ALTER TABLE chemical_material
	ADD FOREIGN KEY R_33 (id_equipment_state) REFERENCES equipment_state(id)
;


ALTER TABLE chemical_material
	ADD FOREIGN KEY R_34 (id_production_mode) REFERENCES production_mode(id)
;


ALTER TABLE chemical_material
	ADD FOREIGN KEY R_35 (id_material_type) REFERENCES material_type(id)
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
	ADD FOREIGN KEY R_23 (id_risk_basic_info) REFERENCES risk_basic_info(id)
;


ALTER TABLE company
	ADD FOREIGN KEY R_28 (id_house_plan) REFERENCES house_plan(id)
;



ALTER TABLE company_air_env
	ADD FOREIGN KEY R_48 (id_air_env) REFERENCES air_env(id)
;


ALTER TABLE company_air_env
	ADD FOREIGN KEY R_49 (id_company) REFERENCES company(id)
;


ALTER TABLE company_air_env
	ADD FOREIGN KEY R_51 (id_location) REFERENCES location_dic(id)
;



ALTER TABLE company_water_env
	ADD FOREIGN KEY R_45 (id_company) REFERENCES company(id)
;



ALTER TABLE data_collection_device
	ADD FOREIGN KEY R_65 (id_detect_station) REFERENCES detect_station(id)
;



ALTER TABLE detect
	ADD FOREIGN KEY R_67 (id_detect_station) REFERENCES detect_station(id)
;


ALTER TABLE detect
	ADD FOREIGN KEY R_68 (id_detect_factor) REFERENCES detect_factor(id)
;


ALTER TABLE detect
	ADD FOREIGN KEY R_69 (mn) REFERENCES data_collection_device(mn)
;



ALTER TABLE detect_factor
	ADD FOREIGN KEY R_61 (id_detect_category) REFERENCES detect_category(id)
;



ALTER TABLE detect_history
	ADD FOREIGN KEY R_62 (id_detect_station) REFERENCES detect_station(id)
;


ALTER TABLE detect_history
	ADD FOREIGN KEY R_64 (id_detect_factor) REFERENCES detect_factor(id)
;


ALTER TABLE detect_history
	ADD FOREIGN KEY R_66 (mn) REFERENCES data_collection_device(mn)
;



ALTER TABLE detect_station
	ADD FOREIGN KEY R_59 (id_epb) REFERENCES epb(id)
;


ALTER TABLE detect_station
	ADD FOREIGN KEY R_60 (id_divsion) REFERENCES administrative_division(id)
;



ALTER TABLE emergency_material
	ADD FOREIGN KEY R_16 (creator) REFERENCES users(username)
;


ALTER TABLE emergency_material
	ADD FOREIGN KEY R_17 (auditor) REFERENCES users(username)
;


ALTER TABLE emergency_material
	ADD FOREIGN KEY R_41 (id_company) REFERENCES company(id)
;



ALTER TABLE emergency_response_plan
	ADD FOREIGN KEY R_52 (id_company) REFERENCES company(id)
;


ALTER TABLE emergency_response_plan
	ADD FOREIGN KEY R_53 (id_epb) REFERENCES epb(id)
;


ALTER TABLE emergency_response_plan
	ADD FOREIGN KEY R_54 (id_emergency_response_plan_type) REFERENCES emergency_reponse_plan_type(id)
;



ALTER TABLE env_prot_person
	ADD FOREIGN KEY R_58 (id_company) REFERENCES company(id)
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



ALTER TABLE equipment_risk
	ADD FOREIGN KEY R_57 (id_company) REFERENCES company(id)
;



ALTER TABLE group_authorities
	ADD FOREIGN KEY R_2 (group_id) REFERENCES groups(id)
;



ALTER TABLE group_members
	ADD FOREIGN KEY R_4 (username) REFERENCES users(username)
;


ALTER TABLE group_members
	ADD FOREIGN KEY R_5 (group_id) REFERENCES groups(id)
;



ALTER TABLE persistent_logins
	ADD FOREIGN KEY R_8 (username) REFERENCES users(username)
;



ALTER TABLE risk_aversion
	ADD FOREIGN KEY R_37 (id_company) REFERENCES company(id)
;


ALTER TABLE risk_aversion
	ADD FOREIGN KEY R_38 (id_risk_aversion_type) REFERENCES risk_aversion_type(id)
;



ALTER TABLE risk_aversion_options
	ADD FOREIGN KEY R_39 (id_risk_aversion) REFERENCES risk_aversion(id)
;


ALTER TABLE risk_aversion_options
	ADD FOREIGN KEY R_40 (id_risk_aversion_option) REFERENCES risk_aversion_options_dic(id)
;



ALTER TABLE risk_basic_info
	ADD FOREIGN KEY R_24 (id_industrial_park) REFERENCES industrial_park(id)
;


ALTER TABLE risk_basic_info
	ADD FOREIGN KEY R_25 (id_product_status) REFERENCES product_status(id)
;



ALTER TABLE users
	ADD FOREIGN KEY R_22 (id_epb) REFERENCES epb(id)
;



ALTER TABLE warehouse_risk
	ADD FOREIGN KEY R_55 (id_company) REFERENCES company(id)
;


ALTER TABLE warehouse_risk
	ADD FOREIGN KEY R_56 (id_storage_method) REFERENCES storage_method(id)
;



ALTER TABLE water_env
	ADD FOREIGN KEY R_42 (id_water_env_type) REFERENCES water_env_type(id)
;


ALTER TABLE water_env
	ADD FOREIGN KEY R_43 (id_env_func) REFERENCES env_func(id)
;



ALTER TABLE workmanship
	ADD FOREIGN KEY R_36 (id_company) REFERENCES company(id)
;


