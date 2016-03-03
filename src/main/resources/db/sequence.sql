set foreign_key_checks =0;



alter table `administrative_dic` 
modify `id` int(11) not null auto_increment;

alter table `administrative_division` 
modify `id` int(11) not null auto_increment;

alter table `air_env` 
modify `id` int(11) not null auto_increment;

alter table `air_env_type` 
modify `id` int(11) not null auto_increment;

alter table `aqi_info` 
modify `id` int(11) not null auto_increment;


alter table `chemical_material` 
modify `id` int(11) not null auto_increment;

alter table `company` 
modify `id` int(11) not null auto_increment;

alter table `concern_degree_dic` 
modify `id` int(11) not null auto_increment;

alter table `detect_air` 
modify `id` int(11) not null auto_increment;

alter table `detect_air_report` 
modify `id` int(11) not null auto_increment;

alter table `detect_category` 
modify `id` int(11) not null auto_increment;

alter table `detect_content_dic` 
modify `id` int(11) not null auto_increment;

alter table `detect_factor` 
modify `id` int(11) not null auto_increment;

alter table `detect_history` 
modify `id` int(11) not null auto_increment;

alter table `detect_station` 
modify `id` int(11) not null auto_increment;

alter table `emergency_material` 
modify `id` int(11) not null auto_increment;

alter table `emergency_response_plan` 
modify `id` int(11) not null auto_increment;

alter table `env_func` 
modify `id` int(11) not null auto_increment;

alter table `env_prot_person` 
modify `id` int(11) not null auto_increment;

alter table `epb` 
modify `id` int(11) not null auto_increment;

alter table `equipment_risk` 
modify `id` int(11) not null auto_increment;

alter table `equipment_state` 
modify `id` int(11) not null auto_increment;

alter table `equipment_type` 
modify `id` int(11) not null auto_increment;

alter table `group_members` 
modify `id` int(11) not null auto_increment;

alter table `groups` 
modify `id` int(11) not null auto_increment;

alter table `house_plan` 
modify `id` int(11) not null auto_increment;

alter table `iaqi_info` 
modify `id` int(11) not null auto_increment;

alter table `industrial_park` 
modify `id` int(11) not null auto_increment;

alter table `industry_sector_dic` 
modify `id` int(11) not null auto_increment;

alter table `location_dic` 
modify `id` int(11) not null auto_increment;

alter table `material_category` 
modify `id` int(11) not null auto_increment;

alter table `material_type` 
modify `id` int(11) not null auto_increment;

alter table `operation_maintance_company` 
modify `id` int(11) not null auto_increment;

alter table `physical_state` 
modify `id` int(11) not null auto_increment;

alter table `product_status` 
modify `id` int(11) not null auto_increment;

alter table `production_mode` 
modify `id` int(11) not null auto_increment;

alter table `risk_aversion` 
modify `id` int(11) not null auto_increment;

alter table `risk_aversion_options_dic` 
modify `id` int(11) not null auto_increment;

alter table `risk_aversion_type` 
modify `id` int(11) not null auto_increment;

alter table `risk_basic_info` 
modify `id` int(11) not null auto_increment;

alter table `storage_method` 
modify `id` int(11) not null auto_increment;

alter table `storage_mode` 
modify `id` int(11) not null auto_increment;

alter table `warehouse_risk` 
modify `id` int(11) not null auto_increment;

alter table `water_env` 
modify `id` int(11) not null auto_increment;

alter table `water_env_type` 
modify `id` int(11) not null auto_increment;

alter table `workmanship` 
modify `id` int(11) not null auto_increment;


set foreign_key_checks =1;
