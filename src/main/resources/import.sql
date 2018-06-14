
insert into usuario(nome,login,senha,email,situacao) values ('Administrador','adm','123','admin@gmail.com','Ativo');
insert into usuario(nome,login,senha,email,situacao) values ('Lyndon Tavares','lyndon','123','integraldomino@gmail.com','Ativo');
insert into usuario(nome,login,senha,email,situacao) values ('user','user','123','user@gmail.com','Ativo');

insert into usuario_funcionalidades( usuario_id, funcionalidade ) values ( 1,'Familia');
insert into usuario_funcionalidades( usuario_id, funcionalidade ) values ( 1,'Usuario');
insert into usuario_funcionalidades( usuario_id, funcionalidade ) values ( 1,'Ocupacao');
insert into usuario_funcionalidades( usuario_id, funcionalidade ) values ( 1,'Cidade');
insert into usuario_funcionalidades( usuario_id, funcionalidade ) values ( 1,'Bairro');
insert into usuario_funcionalidades( usuario_id, funcionalidade ) values ( 1,'Configuracao');

insert into usuario_funcionalidades( usuario_id, funcionalidade ) values ( 2,'Familia');
insert into usuario_funcionalidades( usuario_id, funcionalidade ) values ( 2,'Usuario');
insert into usuario_funcionalidades( usuario_id, funcionalidade ) values ( 2,'Ocupacao');
insert into usuario_funcionalidades( usuario_id, funcionalidade ) values ( 2,'Cidade');
insert into usuario_funcionalidades( usuario_id, funcionalidade ) values ( 2,'Bairro');
insert into usuario_funcionalidades( usuario_id, funcionalidade ) values ( 2,'Configuracao');

insert into usuario_funcionalidades( usuario_id, funcionalidade ) values ( 3,'Familia');

insert into Cidade (nome) values ( 'Foz do Iguaçu');

insert into Bairro (nome,cidade_id) values ('Jardim Res.Bela Vista',1);
insert into Bairro (nome,cidade_id) values ('Morumbi',1);

insert into Ocupacao ( nome) values ('Sem ocupação');
insert into Ocupacao ( nome) values ('Estudante');
insert into Ocupacao ( nome) values ('Dona de Casa');

insert into Familia (nome_mae,criacao,endereco,ponto_referencia,situacao,bairro_id,usuario_id) values ( 'mae-01','2017-10-21','endereco-01','pontoReferencia-01','A',1,1);
insert into Familia (nome_mae,criacao,endereco,ponto_referencia,situacao,bairro_id,usuario_id) values ( 'mae-02','2017-10-21','endereco-03','pontoReferencia-02','A',1,1);
insert into Familia (nome_mae,criacao,endereco,ponto_referencia,situacao,bairro_id,usuario_id) values ( 'mae-03','2017-10-21','endereco-04','pontoReferencia-03','A',1,1);
insert into Familia (nome_mae,criacao,endereco,ponto_referencia,situacao,bairro_id,usuario_id) values ( 'mae-04','2017-10-21','endereco-05','pontoReferencia-04','A',1,1);
insert into Familia (nome_mae,criacao,endereco,ponto_referencia,situacao,bairro_id,usuario_id) values ( 'mae-05','2017-10-21','endereco-06','pontoReferencia-05','A',1,1);
insert into Familia (nome_mae,criacao,endereco,ponto_referencia,situacao,bairro_id,usuario_id) values ( 'mae-06','2017-10-21','endereco-07','pontoReferencia-06','A',1,1);
insert into Familia (nome_mae,criacao,endereco,ponto_referencia,situacao,bairro_id,usuario_id) values ( 'mae-07','2017-10-21','endereco-08','pontoReferencia-07','A',1,1);
insert into Familia (nome_mae,criacao,endereco,ponto_referencia,situacao,bairro_id,usuario_id) values ( 'mae-08','2017-10-21','endereco-09','pontoReferencia-08','A',1,1);
insert into Familia (nome_mae,criacao,endereco,ponto_referencia,situacao,bairro_id,usuario_id) values ( 'mae-09','2017-10-21','endereco-00','pontoReferencia-09','A',1,1);

insert into Membro ( nome,familia_id,parentesco,sexo,cor,ocupacao_id) values ('Filho 01',1,'Filho','M','Branca',1);
insert into Membro ( nome,familia_id,parentesco,sexo,cor,ocupacao_id) values ('Filho 02',1,'Filho','M','Branca',2);
insert into Membro ( nome,familia_id,parentesco,sexo,cor,ocupacao_id) values ('Filho 03',1,'Filho','M','Branca',3);

insert into Membro ( nome,familia_id,parentesco,sexo,cor,ocupacao_id) values ('Filha 01',2,'Filho','F','Branca',1);
insert into Membro ( nome,familia_id,parentesco,sexo,cor,ocupacao_id) values ('Filha 02',2,'Filho','F','Branca',2);
insert into Membro ( nome,familia_id,parentesco,sexo,cor,ocupacao_id) values ('Filha 03',2,'Filho','F','Branca',3);

