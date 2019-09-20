create table NAC_USUARIO(
    ID_USUARIO INTEGER PRIMARY KEY,
    NM_USUARIO VARCHAR(50), 
    EMAIL_USUARIO VARCHAR(50), 
    RM_USUARIO VARCHAR(7), 
    PW_USUARIO VARCHAR(20)
); 
create table NAC_CURSO (
	ID_CURSO integer primary key,
	NM_CURSO varchar(50),
	DURACAO_CURSO varchar(50),
	DESC_CURSO VARCHAR(100),
	ID_USUARIO INTEGER REFERENCES NAC_USUARIO(ID_USUARIO)
);
create sequence c_usuario_nac_seq increment by 1 start with 1;