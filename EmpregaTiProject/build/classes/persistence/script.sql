create database EmpregaTiDatabase;

use EmpregaTiDatabase;


create table regiao (idRegiao integer auto_increment primary key, nome varchar(50) not null);
create table estado (idEstado integer auto_increment primary key, codigoUf integer not null, nome varchar (50) not null, uf CHAR (2) not null, regiao integer not null);
create table status (idStatus integer auto_increment primary key, tipo varchar(50) not null);
create table acesso (idAcesso integer primary key, acesso varchar(50));
create table login (idlogin integer auto_increment primary key,email varchar(50) not null unique,senha varchar(150) not null,nome varchar(50) not null,idAcesso integer not null,tentativas integer default 0,foreign key(idAcesso) references acesso(idAcesso));
create table vaga (idVaga integer auto_increment primary key, data date,requisitos varchar (255),conteudo longtext,empresa varchar (155),pretensao varchar (155),cidade varchar (155),idloginVaga integer not null, idStatus integer not null, foreign key (idloginVaga) references login (idlogin), foreign key (idStatus) references status (idStatus));
create table qrcode (idqrcode integer auto_increment primary key, qrcode blob,idVaga integer not null, foreign key (idVaga) references vaga(idVaga));
create table vagaestado (idEstado int,idVaga int,foreign key (idEstado) references estado(idEstado),foreign key (idVaga) references vaga(idVaga));



insert into regiao values (1, 'Norte');
insert into regiao values (2, 'Nordeste');
insert into regiao values (3, 'Sudeste');
insert into regiao values (4, 'Sul');
insert into regiao values (5, 'Centro-Oeste');
insert into regiao values (6, 'Nao Definido');

insert into estado values (null ,11, 'Rondônia', 'RO', 1);
insert into estado values (null ,12, 'Acre', 'AC', 1);
insert into estado values (null ,13, 'Amazonas', 'AM', 1);
insert into estado values (null ,14, 'Roraima', 'RR', 1);
insert into estado values (null ,15, 'Pará', 'PA', 1);
insert into estado values (null ,16, 'Amapá', 'AP', 1);
insert into estado values (null ,17, 'Tocantins', 'TO', 1);
insert into estado values (null ,21, 'Maranhão', 'MA', 2);
insert into estado values (null ,22, 'Piauí', 'PI', 2);
insert into estado values (null ,23, 'Ceará', 'CE', 2);
insert into estado values (null ,24, 'Rio Grande do Norte', 'RN', 2);
insert into estado values (null ,25, 'Paraíba', 'PB', 2);
insert into estado values (null ,26, 'Pernambuco', 'PE', 2);
insert into estado values (null ,27, 'Alagoas', 'AL', 2);
insert into estado values (null ,28, 'Sergipe', 'SE', 2);
insert into estado values (null ,29, 'Bahia', 'BA', 2);
insert into estado values (null ,51, 'Mato Grosso do Sul', 'MS', 5);
insert into estado values (null ,52, 'Mato Grosso', 'MT', 5);
insert into estado values (null ,53, 'Goiás', 'GO', 5);
insert into estado values (null ,54, 'Distrito Federal', 'DF', 5);
insert into estado values (null ,31, 'Minas Gerais', 'MG', 3);
insert into estado values (null ,32, 'Espírito Santo', 'ES', 3);
insert into estado values (null ,33, 'Rio de Janeiro', 'RJ', 3);
insert into estado values (null ,34, 'São Paulo', 'SP', 3);
insert into estado values (null ,41, 'Paraná', 'PR', 4);
insert into estado values (null ,42, 'Santa Catarina', 'SC', 4);
insert into estado values (null ,43, 'Rio Grande do Sul', 'RS', 4);
insert into estado values (null ,61, 'Não Definido', 'ND', 6);

insert into acesso values (1, "usuario");
insert into acesso values (2, "admin");
insert into acesso values (3, "recrutador");
insert into acesso values (4, "empresa");

insert into status values(1,"ativo");
insert into status values(2,"inativo");


delimiter $

create procedure incluir( pnome varchar(50), pemail varchar(50), psenha varchar(150), ptipo integer)

begin

insert into login values(null, pemail, psenha, pnome, ptipo, 0);

end

$

delimiter ;

call incluir('Jose da Silva', 'jose@ig.com', '123', 1);

---------------------------------------------------------------------------------------------------

--agora insere os valores na tabela vaga. 
insert into vaga values(null, CURDATE(), "Programador Java, PL/SQL, junior","Trabalhar na empresa XYZ com implementações inovadoras", "não informada", "não informada","Rio de Janeiro", 1,1);
insert into vaga values (null,CURDATE(),"Programador C#, PL/SQL, pleno","Trabalhar na empresa XYZ com implementações inovadoras e corrigindo os códigos antigos","Metatron","R$ 2.800,00","Rio de Janeiro",1,1);

---------------------------------------------------------------------------------------------------

delimiter $

create function logar(pemail varchar(50), psenha varchar(150))

returns varchar(100)

begin

declare vid int;

declare vtentar1 int;

declare vtentar2 int;

select count(*), tentativas into vid, vtentar1 from login where email = pemail;

if vid = 0 then

	return 'Usuario ou senha inválido';

	else

		if vtentar1 > 2 then

		return 'Usuario bloqueado';

		else

		select idlogin, count(*) into vid, vtentar2 from login where email = pemail and senha = psenha;

		if vid is null then

		update login set tentativas = vtentar1 + 1 where email = pemail;

		return 'Usuario ou senha inválido';

			else

			update login set tentativas = 0 where email = pemail;

			return 'Logado';

			end if;

		end if;

end if;

end

$

delimiter ;

select logar('jose','123');
select logar('jose@email.com.br','123');
select logar('jose@mail.com','123');
select logar('jose@ig.com','123');


delimiter $

create function validar(pemail varchar(50), psenha varchar(150))

returns varchar(100)

begin

declare vid int;

declare vtentar1 int;

declare vtentar2 int;

select count(*), tentativas into vid, vtentar1 from login where email = pemail;

if vid = 0 then

	return 'Usuario ou senha inválido';

	else

		if vtentar1 > 20 then

		return 'Usuario bloqueado';

		else

		select idlogin, count(*) into vid, vtentar2 from login where email = pemail and senha = psenha;

		if vid is null then

		update login set tentativas = vtentar1 + 1 where email = pemail;

		return 'Usuario ou senha inválido';

			else

			update login set tentativas = 0 where email = pemail;

			return 'Logado';

			end if;

		end if;

end if;

end

$

delimiter ;

create or replace view v$buscaloginedit as select l.email, l.senha, l.nome, a.acesso from login l, acesso a where l.idAcesso = a.idAcesso;


