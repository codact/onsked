--liquibase formatted sql
CREATE TABLE "appointment" (
  "appt_id" int NOT NULL,
  "biz_id" int DEFAULT NULL,
  "client_id" int DEFAULT NULL,
  "created_by" int DEFAULT NULL,
  "created_dt" varchar(255) DEFAULT NULL,
  "end_time" varchar(255) DEFAULT NULL,
  "is_active" varchar(255) DEFAULT NULL,
  "is_synchronized" varchar(255) DEFAULT NULL,
  "loc_id" int DEFAULT NULL,
  "modified_by" int DEFAULT NULL,
  "modified_dt" varchar(255) DEFAULT NULL,
  "reject_reason" varchar(255) DEFAULT NULL,
  "res_id" int DEFAULT NULL,
  "start_time" varchar(255) DEFAULT NULL,
  "status_code" varchar(255) DEFAULT NULL,
  "status_reason_code" varchar(255) DEFAULT NULL,
  "svc_id" varchar(255) DEFAULT NULL,
  "user_id" int DEFAULT NULL,
  PRIMARY KEY ("appt_id")
);

CREATE TABLE "appointment_rating" (
  "rating_id" int NOT NULL,
  "appt_id" int DEFAULT NULL,
  "comments" varchar(255) DEFAULT NULL,
  "rated_date" datetime DEFAULT NULL,
  "rating" int DEFAULT NULL,
  "user_id" int DEFAULT NULL,
  PRIMARY KEY ("rating_id")
);

CREATE TABLE "appointment_status" (
  "status_code" varchar(255) NOT NULL,
  "status_reason_code" varchar(255) NOT NULL,
  "is_active" varchar(255) DEFAULT NULL,
  "status_description" varchar(255) DEFAULT NULL,
  "status_reason_description" varchar(255) DEFAULT NULL,
  PRIMARY KEY ("status_code","status_reason_code")
);

CREATE TABLE "business" (
  "biz_id" int NOT NULL,
  "allow_unregistered_users" varchar(255) DEFAULT NULL,
  "biz_name" varchar(255) DEFAULT NULL,
  "cancellation_lead_time" int DEFAULT NULL,
  "category_code" int DEFAULT NULL,
  "contact_email" varchar(255) DEFAULT NULL,
  "contact_first_name" varchar(255) DEFAULT NULL,
  "contact_last_name" varchar(255) DEFAULT NULL,
  "contact_phone" varchar(255) DEFAULT NULL,
  "created_by" int DEFAULT NULL,
  "created_dt" datetime DEFAULT NULL,
  "description" varchar(255) DEFAULT NULL,
  "dt_format_id" int DEFAULT NULL,
  "is_active" varchar(255) DEFAULT NULL,
  "is_deleted" varchar(255) DEFAULT NULL,
  "is_searchable" varchar(255) DEFAULT NULL,
  "modified_by" int DEFAULT NULL,
  "modified_dt" datetime DEFAULT NULL,
  "notify_by_email" varchar(255) DEFAULT NULL,
  "notify_by_sms" varchar(255) DEFAULT NULL,
  "reservation_lead_time" int DEFAULT NULL,
  "website" varchar(255) DEFAULT NULL,
  PRIMARY KEY ("biz_id")
);

CREATE TABLE "business_holiday" (
  "holiday_id" int NOT NULL,
  "biz_id" int DEFAULT NULL,
  "created_by" int DEFAULT NULL,
  "created_dt" datetime DEFAULT NULL,
  "holiday_dt" datetime DEFAULT NULL,
  "loc_id" int DEFAULT NULL,
  "modified_by" int DEFAULT NULL,
  "modified_dt" datetime DEFAULT NULL,
  "reason" varchar(255) DEFAULT NULL,
  PRIMARY KEY ("holiday_id")
);

CREATE TABLE "business_hours" (
  "biz_id" int NOT NULL,
  "day_of_week" int NOT NULL,
  "close_time" varchar(255) DEFAULT NULL,
  "created_by" int DEFAULT NULL,
  "created_dt" datetime DEFAULT NULL,
  "is_open" int DEFAULT NULL,
  "modified_by" int DEFAULT NULL,
  "modified_dt" datetime DEFAULT NULL,
  "open_time" varchar(255) DEFAULT NULL,
  PRIMARY KEY ("biz_id","day_of_week")
);

CREATE TABLE "business_user" (
  "biz_id" int NOT NULL,
  "user_id" int NOT NULL,
  "created_by" int DEFAULT NULL,
  "created_dt" datetime DEFAULT NULL,
  "modified_by" int DEFAULT NULL,
  "modified_dt" datetime DEFAULT NULL,
  PRIMARY KEY ("biz_id","user_id")
);

CREATE TABLE "category" (
  "category_code" int NOT NULL,
  "category_name" varchar(255) DEFAULT NULL,
  "details" varchar(255) DEFAULT NULL,
  "is_active" varchar(255) DEFAULT NULL,
  "receiver_title" varchar(255) DEFAULT NULL,
  "receiver_title_plural" varchar(255) DEFAULT NULL,
  "resource_title" varchar(255) DEFAULT NULL,
  "resource_title_plural" varchar(255) DEFAULT NULL,
  PRIMARY KEY ("category_code")
);

CREATE TABLE "client" (
  "client_id" int NOT NULL,
  "address_line1" varchar(255) DEFAULT NULL,
  "address_line2" varchar(255) DEFAULT NULL,
  "biz_id" int DEFAULT NULL,
  "cell_phone" varchar(255) DEFAULT NULL,
  "city" varchar(255) DEFAULT NULL,
  "country_code" varchar(255) DEFAULT NULL,
  "created_by" int DEFAULT NULL,
  "created_dt" datetime DEFAULT NULL,
  "date_of_birth" datetime DEFAULT NULL,
  "email" varchar(255) DEFAULT NULL,
  "first_name" varchar(255) DEFAULT NULL,
  "gender" varchar(255) DEFAULT NULL,
  "home_phone" varchar(255) DEFAULT NULL,
  "is_active" varchar(255) DEFAULT NULL,
  "last_name" varchar(255) DEFAULT NULL,
  "modified_by" int DEFAULT NULL,
  "modified_dt" datetime DEFAULT NULL,
  "state_code" varchar(255) DEFAULT NULL,
  "work_phone" varchar(255) DEFAULT NULL,
  "work_phone_ext" varchar(255) DEFAULT NULL,
  "zip_code" varchar(255) DEFAULT NULL,
  PRIMARY KEY ("client_id")
);

CREATE TABLE "coffee" (
  "colour" varchar(255) NOT NULL,
  "brands" varchar(255) DEFAULT NULL,
  PRIMARY KEY ("colour")
);

CREATE TABLE "country" (
  "country_code" varchar(255) NOT NULL,
  "country_name" varchar(255) DEFAULT NULL,
  PRIMARY KEY ("country_code")
);

CREATE TABLE "currency" (
  "country_code" varchar(255) NOT NULL,
  "currency_code" varchar(255) NOT NULL,
  "currency_name" varchar(255) DEFAULT NULL,
  "symbol" varchar(255) DEFAULT NULL,
  PRIMARY KEY ("country_code","currency_code")
);

CREATE TABLE "date_formats" (
  "dt_format_id" int NOT NULL,
  "dt_format" varchar(255) DEFAULT NULL,
  PRIMARY KEY ("dt_format_id")
);

CREATE TABLE "featured_businesses" (
  "biz_id" int NOT NULL,
  "created_by" int DEFAULT NULL,
  "created_dt" datetime DEFAULT NULL,
  "is_active" varchar(255) DEFAULT NULL,
  PRIMARY KEY ("biz_id")
);

CREATE TABLE "holiday" (
  "country_code" varchar(2) NOT NULL,
  "holiday_dt" date NOT NULL,
  "holiday_reason" varchar(256) NOT NULL,
  "is_active" char(1) NOT NULL DEFAULT 'Y',
  "created_dt" datetime DEFAULT NULL,
  "created_by" int unsigned DEFAULT NULL,
  "modified_dt" datetime DEFAULT NULL,
  "modified_by" int unsigned DEFAULT NULL,
  PRIMARY KEY ("country_code")
);

CREATE TABLE "leave_reason" (
  "leave_code" char(1) NOT NULL,
  "description" varchar(30) DEFAULT NULL,
  PRIMARY KEY ("leave_code")
);

CREATE TABLE "location" (
  "loc_id" int NOT NULL AUTO_INCREMENT,
  "biz_id" int NOT NULL,
  "loc_name" varchar(30) NOT NULL,
  "address_line1" varchar(45) DEFAULT NULL,
  "address_line2" varchar(45) DEFAULT NULL,
  "city" varchar(30) DEFAULT NULL,
  "state_code" varchar(2) DEFAULT NULL,
  "zip_code" varchar(6) DEFAULT NULL,
  "country_code" varchar(2) DEFAULT NULL,
  "currency_code" varchar(3) DEFAULT NULL,
  "timezone_code" varchar(9) DEFAULT NULL,
  "phone_number1" varchar(15) DEFAULT NULL,
  "phone_number2" varchar(15) DEFAULT NULL,
  "fax_number" varchar(15) DEFAULT NULL,
  "is_headquarters" char(1) DEFAULT NULL,
  "is_active" char(1) NOT NULL DEFAULT 'Y',
  "created_dt" datetime DEFAULT NULL,
  "created_by" int DEFAULT NULL,
  "modified_dt" datetime DEFAULT NULL,
  "modified_by" int DEFAULT NULL,
  "description" varchar(200) DEFAULT NULL,
  "lat" float(10,6) NOT NULL,
  "lng" float(10,6) NOT NULL,
  "custom_message" varchar(200) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  "auto_approve_request" char(1) NOT NULL DEFAULT 'N',
  PRIMARY KEY ("loc_id"),
  KEY "country_code" ("country_code","state_code"),
  KEY "country_code_2" ("country_code","currency_code"),
  KEY "timezone_code" ("timezone_code"),
  KEY "biz_id" ("biz_id")
);

CREATE TABLE "location_hours" (
  "loc_id" int NOT NULL AUTO_INCREMENT,
  "day_of_week" int NOT NULL,
  "is_open" int NOT NULL DEFAULT '0',
  "open_time" time NOT NULL DEFAULT '00:00:00',
  "close_time" time NOT NULL DEFAULT '00:00:00',
  "created_dt" datetime DEFAULT NULL,
  "created_by" int DEFAULT NULL,
  "modified_dt" datetime DEFAULT NULL,
  "modified_by" int DEFAULT NULL,
  PRIMARY KEY ("loc_id","day_of_week")
);

CREATE TABLE "location_to_resource" (
  "loc_id" int NOT NULL,
  "res_id" int NOT NULL,
  "created_dt" datetime DEFAULT NULL,
  "created_by" int DEFAULT NULL,
  "modified_dt" datetime DEFAULT NULL,
  "modified_by" int DEFAULT NULL,
  PRIMARY KEY ("loc_id","res_id"),
  KEY "res_id" ("res_id")
);

CREATE TABLE "location_to_service" (
  "loc_svc_id" int NOT NULL AUTO_INCREMENT,
  "loc_id" int NOT NULL,
  "svc_id" int NOT NULL,
  "cost" decimal(10,2) DEFAULT NULL,
  "duration" int DEFAULT NULL,
  "created_dt" datetime DEFAULT NULL,
  "created_by" int DEFAULT NULL,
  "modified_dt" datetime DEFAULT NULL,
  "modified_by" int DEFAULT NULL,
  PRIMARY KEY ("loc_svc_id","loc_id","svc_id"),
  KEY "loc_id" ("loc_id"),
  KEY "svc_id" ("svc_id")
);

CREATE TABLE "package" (
  "loc_svc_id" int unsigned NOT NULL AUTO_INCREMENT,
  "package" int unsigned NOT NULL,
  "cost" decimal(10,2) NOT NULL,
  "duration" int unsigned NOT NULL,
  "package_name" varchar(45) NOT NULL,
  "created_dt" datetime DEFAULT NULL,
  "created_by" int unsigned DEFAULT NULL,
  "modified_dt" datetime DEFAULT NULL,
  "modified_by" int unsigned DEFAULT NULL,
  PRIMARY KEY ("loc_svc_id","package")
);

CREATE TABLE "payment_modes" (
  "mode_id" int unsigned NOT NULL,
  "mode" varchar(45) NOT NULL,
  "is_active" char(1) NOT NULL DEFAULT 'Y',
  PRIMARY KEY ("mode_id")
);

CREATE TABLE "resource" (
  "res_id" int NOT NULL AUTO_INCREMENT,
  "biz_id" int NOT NULL,
  "first_name" varchar(30) NOT NULL,
  "last_name" varchar(30) NOT NULL,
  "nick_name" varchar(10) NOT NULL,
  "description" varchar(500) DEFAULT NULL,
  "address_line1" varchar(45) DEFAULT NULL,
  "address_line2" varchar(45) DEFAULT NULL,
  "city" varchar(30) DEFAULT NULL,
  "state_code" varchar(2) DEFAULT NULL,
  "zip_code" varchar(6) DEFAULT NULL,
  "country_code" varchar(2) DEFAULT NULL,
  "email" varchar(45) DEFAULT NULL,
  "cell_phone" varchar(15) DEFAULT NULL,
  "home_phone" varchar(15) DEFAULT NULL,
  "work_phone" varchar(15) DEFAULT NULL,
  "work_phone_ext" varchar(8) DEFAULT NULL,
  "is_active" char(1) NOT NULL DEFAULT 'Y',
  "created_dt" datetime DEFAULT NULL,
  "created_by" int DEFAULT NULL,
  "modified_dt" datetime DEFAULT NULL,
  "modified_by" int DEFAULT NULL,
  "is_onsked_user" char(1) NOT NULL DEFAULT 'N',
  PRIMARY KEY ("res_id"),
  KEY "country_code" ("country_code","state_code"),
  KEY "biz_id" ("biz_id")
);

CREATE TABLE "resource_hours" (
  "res_id" int NOT NULL,
  "day_of_week" tinyint NOT NULL,
  "is_working" char(1) NOT NULL,
  "loc_id" int NOT NULL,
  "start_time" time DEFAULT NULL,
  "end_time" time DEFAULT NULL,
  "created_dt" datetime DEFAULT NULL,
  "created_by" int DEFAULT NULL,
  "modified_dt" datetime DEFAULT NULL,
  "modified_by" int DEFAULT NULL,
  PRIMARY KEY ("res_id","day_of_week","loc_id"),
  KEY "loc_id" ("loc_id")
);

CREATE TABLE "resource_leave_schedule" (
  "res_id" int NOT NULL,
  "start_time" datetime NOT NULL,
  "end_time" datetime NOT NULL,
  "leave_code" char(1) DEFAULT NULL,
  "reason" varchar(256) DEFAULT NULL,
  "created_dt" datetime DEFAULT NULL,
  "created_by" int DEFAULT NULL,
  "modified_dt" datetime DEFAULT NULL,
  "modified_by" int DEFAULT NULL,
  PRIMARY KEY ("res_id","start_time","end_time"),
  KEY "leave_code" ("leave_code")
);

CREATE TABLE "resource_to_service" (
  "res_id" int NOT NULL,
  "svc_id" int NOT NULL,
  "created_dt" datetime DEFAULT NULL,
  "created_by" int DEFAULT NULL,
  "modified_dt" datetime DEFAULT NULL,
  "modified_by" int DEFAULT NULL,
  PRIMARY KEY ("res_id","svc_id"),
  KEY "svc_id" ("svc_id")
);

CREATE TABLE "role" (
  "role_code" varchar(20) NOT NULL,
  "role_name" varchar(45) DEFAULT NULL,
  "description" varchar(256) DEFAULT NULL,
  PRIMARY KEY ("role_code")
);

CREATE TABLE "service" (
  "svc_id" int NOT NULL AUTO_INCREMENT,
  "biz_id" int NOT NULL,
  "service_code" int NOT NULL,
  "details" text NOT NULL,
  "duration" smallint NOT NULL,
  "default_cost" decimal(10,2) DEFAULT NULL,
  "is_active" char(1) NOT NULL DEFAULT 'Y',
  "created_dt" datetime DEFAULT NULL,
  "created_by" int DEFAULT NULL,
  "modified_dt" datetime DEFAULT NULL,
  "modified_by" int DEFAULT NULL,
  PRIMARY KEY ("svc_id"),
  UNIQUE KEY "biz_id" ("biz_id","service_code","duration"),
  KEY "service_code" ("service_code")
);

CREATE TABLE "service_master" (
  "service_code" int NOT NULL AUTO_INCREMENT,
  "service_name" varchar(30) NOT NULL,
  "category_code" smallint NOT NULL,
  "description" varchar(256) DEFAULT NULL,
  "is_active" char(1) NOT NULL DEFAULT 'Y',
  PRIMARY KEY ("service_code"),
  KEY "category_code" ("category_code")
);

CREATE TABLE "state" (
  "country_code" varchar(2) NOT NULL,
  "state_code" varchar(2) NOT NULL,
  "state_name" varchar(30) DEFAULT NULL,
  PRIMARY KEY ("country_code","state_code")
);

CREATE TABLE "timezone" (
  "timezone_code" varchar(9) NOT NULL,
  "description" varchar(60) NOT NULL,
  "is_active" char(1) NOT NULL DEFAULT 'Y',
  "country_code" varchar(2) NOT NULL,
  PRIMARY KEY ("timezone_code")
);

CREATE TABLE "unregistered_user_master" (
  "id" int NOT NULL,
  "address_line1" varchar(255) DEFAULT NULL,
  "address_line2" varchar(255) DEFAULT NULL,
  "cell_phone" varchar(255) DEFAULT NULL,
  "city" varchar(255) DEFAULT NULL,
  "country_code" varchar(255) DEFAULT NULL,
  "date_of_birth" varchar(255) DEFAULT NULL,
  "date_of_birth_asyyyymmdd" varchar(255) DEFAULT NULL,
  "email" varchar(255) DEFAULT NULL,
  "first_name" varchar(255) DEFAULT NULL,
  "gender" varchar(255) DEFAULT NULL,
  "home_phone" varchar(255) DEFAULT NULL,
  "last_name" varchar(255) DEFAULT NULL,
  "state" varchar(255) DEFAULT NULL,
  "state_code" varchar(255) DEFAULT NULL,
  "time_zone_code" varchar(255) DEFAULT NULL,
  "timezone" varchar(255) DEFAULT NULL,
  "unreg_id" int NOT NULL,
  "zip_code" varchar(255) DEFAULT NULL,
  PRIMARY KEY ("id")
);

CREATE TABLE "user_master" (
  "user_id" int NOT NULL,
  "accept_terms" varchar(255) DEFAULT NULL,
  "accept_terms_flag" bit(1) DEFAULT NULL,
  "activated" varchar(255) DEFAULT NULL,
  "activation_dt" varchar(255) DEFAULT NULL,
  "address_line1" varchar(255) DEFAULT NULL,
  "address_line2" varchar(255) DEFAULT NULL,
  "amount" int DEFAULT NULL,
  "answer1" varchar(255) DEFAULT NULL,
  "answer2" varchar(255) DEFAULT NULL,
  "appointment_last_sync" datetime DEFAULT NULL,
  "biz_id" int DEFAULT NULL,
  "cell_phone" varchar(255) DEFAULT NULL,
  "city" varchar(255) DEFAULT NULL,
  "country_code" varchar(255) DEFAULT NULL,
  "country_name" varchar(255) DEFAULT NULL,
  "created_dt" datetime DEFAULT NULL,
  "date_of_birth" varchar(255) DEFAULT NULL,
  "date_of_birth_asyyyymmdd" varchar(255) DEFAULT NULL,
  "email" varchar(255) DEFAULT NULL,
  "first_name" varchar(255) DEFAULT NULL,
  "gender" varchar(255) DEFAULT NULL,
  "home_phone" varchar(255) DEFAULT NULL,
  "is_active" varchar(255) DEFAULT NULL,
  "is_add_client_screen" varchar(255) DEFAULT NULL,
  "is_add_or_edit_screen" varchar(255) DEFAULT NULL,
  "is_password_screen" varchar(255) DEFAULT NULL,
  "is_reset_password_screen" varchar(255) DEFAULT NULL,
  "is_verified" varchar(255) DEFAULT NULL,
  "last_login_date" varchar(255) DEFAULT NULL,
  "last_login_dt" datetime DEFAULT NULL,
  "last_name" varchar(255) DEFAULT NULL,
  "level_id" int DEFAULT NULL,
  "level_title" varchar(255) DEFAULT NULL,
  "limit_appointments" int DEFAULT NULL,
  "limit_businesses" int DEFAULT NULL,
  "limit_locations" int DEFAULT NULL,
  "limit_resources" int DEFAULT NULL,
  "modified_dt" datetime DEFAULT NULL,
  "new_biz_id" int DEFAULT NULL,
  "old_password" varchar(255) DEFAULT NULL,
  "password" varchar(255) DEFAULT NULL,
  "password_confirm" varchar(255) DEFAULT NULL,
  "payment_dt" varchar(255) DEFAULT NULL,
  "period_days" int DEFAULT NULL,
  "period_months" int DEFAULT NULL,
  "period_years" int DEFAULT NULL,
  "registration_dt" varchar(255) DEFAULT NULL,
  "role_code" varchar(255) DEFAULT NULL,
  "security_question1" int DEFAULT NULL,
  "security_question2" int DEFAULT NULL,
  "state" varchar(255) DEFAULT NULL,
  "state_code" varchar(255) DEFAULT NULL,
  "state_name" varchar(255) DEFAULT NULL,
  "time_zone_code" varchar(255) DEFAULT NULL,
  "timezone" varchar(255) DEFAULT NULL,
  "ver_code" varchar(255) DEFAULT NULL,
  "verification_code" varchar(255) DEFAULT NULL,
  "verification_dt" varchar(255) DEFAULT NULL,
  "verification_type" varchar(255) DEFAULT NULL,
  "work_phone" varchar(255) DEFAULT NULL,
  "work_phone_ext" varchar(255) DEFAULT NULL,
  "zip_code" varchar(255) DEFAULT NULL,
  "login_attempts" int DEFAULT NULL,
  PRIMARY KEY ("user_id")
);

CREATE TABLE "user_payments" (
  "payment_id" int NOT NULL,
  "additional_details" varchar(255) DEFAULT NULL,
  "amount" varchar(255) DEFAULT NULL,
  "confirmation_number" varchar(255) DEFAULT NULL,
  "created_dt" datetime DEFAULT NULL,
  "gateway_transaction_id" varchar(255) DEFAULT NULL,
  "level_id" int DEFAULT NULL,
  "limit_resources" int DEFAULT NULL,
  "mode" varchar(255) DEFAULT NULL,
  "package_expiry_date" varchar(255) DEFAULT NULL,
  "payment_dt" datetime DEFAULT NULL,
  "payment_mode" int DEFAULT NULL,
  "user_id" int DEFAULT NULL,
  PRIMARY KEY ("payment_id")
);

CREATE TABLE "user_premium_details" (
  "user_id" int NOT NULL,
  "card_holder_name" varchar(30) NOT NULL,
  "credit_card_type" int unsigned NOT NULL,
  "credit_card_number" int unsigned NOT NULL,
  "security_code" varchar(25) NOT NULL,
  "card_expiry_date" date NOT NULL,
  "card_issuing_bank" varchar(100) NOT NULL,
  "card_issuing_country" varchar(45) NOT NULL,
  PRIMARY KEY ("user_id")
);

CREATE TABLE "user_role" (
  "user_id" int NOT NULL,
  "role_code" varchar(255) DEFAULT NULL,
  PRIMARY KEY ("user_id")
);

CREATE TABLE "user_security_questions" (
  "question_id" int NOT NULL AUTO_INCREMENT,
  "question" varchar(100) NOT NULL,
  PRIMARY KEY ("question_id")
);

CREATE TABLE "user_upgrade_levels" (
  "level_id" int NOT NULL,
  "cost" varchar(255) DEFAULT NULL,
  "is_active" char(1) NOT NULL,
  "level_desc" varchar(255) DEFAULT NULL,
  "level_title" varchar(255) DEFAULT NULL,
  "limit_businesses" int DEFAULT NULL,
  "limit_locations" int DEFAULT NULL,
  "limit_resources" int DEFAULT NULL,
  "period_days" int DEFAULT NULL,
  "period_months" int DEFAULT NULL,
  "period_years" int DEFAULT NULL,
  PRIMARY KEY ("level_id")
);

CREATE TABLE "usertable" (
  "user_id" int NOT NULL,
  "first_name" varchar(30) NOT NULL,
  "last_name" varchar(30) NOT NULL,
  "email" varchar(30) DEFAULT NULL,
  "password" varchar(40) DEFAULT NULL,
  "activated" tinyint(1) DEFAULT NULL,
  "verification_code" varchar(32) DEFAULT NULL,
  "registration_dt" date DEFAULT NULL,
  "activation_dt" date DEFAULT NULL,
  "last_login_date" date DEFAULT NULL,
  "verification_type" varchar(30) DEFAULT NULL,
  "mobile_number" varchar(12) DEFAULT NULL,
  "sms_verification_code" varchar(8) DEFAULT NULL,
  PRIMARY KEY ("user_id")
);
