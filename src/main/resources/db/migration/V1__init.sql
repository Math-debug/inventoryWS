CREATE TABLE public.tb_user_group (
	id_user_group bigserial NOT NULL,
	group_name varchar(255) NULL,
	is_admin bool NULL,
	CONSTRAINT tb_user_group_pkey PRIMARY KEY (id_user_group)
);
CREATE TABLE public.tb_users (
	id_user bigserial NOT NULL,
	"password" varchar(255) NULL,
	user_name varchar(255) NULL,
	user_group_id int8 NULL,
	CONSTRAINT tb_users_pkey PRIMARY KEY (id_user),
	CONSTRAINT fk3mjadcd9s0gf54wrdeisx75ce FOREIGN KEY (user_group_id) REFERENCES public.tb_user_group(id_user_group)
);

INSERT INTO tb_user_group (id_user_group,group_name,is_admin) VALUES (1,'ADMIN',TRUE);
INSERT INTO tb_user_group (id_user_group,group_name,is_admin) VALUES (2,'OPERACAO',FALSE);
INSERT INTO tb_users (id_user,password,user_name,user_group_id) VALUES (1,'$2a$10$k2Bn.cjNdGUy7FcyjrZgneBaexWUGiqxUpsnOItMscPagvnRGUipy','Admin',1);
