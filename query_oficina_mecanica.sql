--excluir todas as tabelas do banco
drop table IF exists municipio cascade;
drop table IF exists endereco cascade;
drop table IF exists pessoa cascade;

drop table IF exists marca cascade;
drop table IF exists modelo cascade;
drop table IF exists veiculo cascade;

drop table IF exists ordem_servico_produto  cascade;
drop table IF exists produto cascade;

drop table IF exists ordem_servico_servico cascade;
drop table IF exists ordem_servico cascade;

drop table IF exists servico cascade;

--selecionar todas as tabelas do banco
select * from municipio m;
select * from endereco e;
select * from pessoa p;

select * from marca ma;
select * from modelo mo;
select * from veiculo ve;

select * from ordem_servico_produto osp;
select * from produto pr;

select * from ordem_servico_servico oss;
select * from servico se;

select * from ordem_servico os;

--popular todas as tabelas do banco
select * from pessoa p;
truncate pessoa cascade;
INSERT INTO pessoa (cpf, funcionario, nome, telefones, whatsapp)
VALUES ('70223146585', false, 'João Pereira', '62995563458', true);
INSERT INTO pessoa (cpf, funcionario, nome, telefones, whatsapp)
VALUES ('10223146585', true, 'Diego Santos', '62986563458', true);
INSERT INTO pessoa (cpf, funcionario, nome, telefones, whatsapp)
VALUES ('30223146585', false, 'Maria Abadia', '62987563458', true);
INSERT INTO pessoa (cpf, funcionario, nome, telefones, whatsapp)
VALUES ('96223146585', true, 'Henrique Juliano', '62996563458', true);
INSERT INTO pessoa (cpf, funcionario, nome, telefones, whatsapp)
VALUES ('85223146585', false, 'Daniela Silva', '62997563458', true);
INSERT INTO pessoa (cpf, funcionario, nome, telefones, whatsapp)
VALUES ('65223146585', false, 'Patricia Oliveira', '62997563458', true);
INSERT INTO pessoa (cpf, funcionario, nome, telefones, whatsapp)
VALUES ('60223146585', false, 'Jose da Silva', '62997563458', true);
INSERT INTO pessoa (cpf, funcionario, nome, telefones, whatsapp)
VALUES ('40223146585', false, 'Fernando Diego', '62997563458', true);
INSERT INTO pessoa (cpf, funcionario, nome, telefones, whatsapp)
VALUES ('60223146585', false, 'Julia de Oliveira', '62997563458', true);
INSERT INTO pessoa (cpf, funcionario, nome, telefones, whatsapp)
VALUES ('70223146545', false, 'João Pereira', '62995563458', true);
INSERT INTO pessoa (cpf, funcionario, nome, telefones, whatsapp)
VALUES ('10223146545', true, 'Diego Santos', '62986563458', true);
INSERT INTO pessoa (cpf, funcionario, nome, telefones, whatsapp)
VALUES ('30223146545', false, 'Maria Abadia', '62987563458', false);
INSERT INTO pessoa (cpf, funcionario, nome, telefones, whatsapp)
VALUES ('96223146545', true, 'Henrique Juliano', '62996563458', false);
INSERT INTO pessoa (cpf, funcionario, nome, telefones, whatsapp)
VALUES ('85223146545', false, 'Daniela Silva', '62997563458', true);
INSERT INTO pessoa (cpf, funcionario, nome, telefones, whatsapp)
VALUES ('65223146545', false, 'Patricia Oliveira', '62997563458', true);
INSERT INTO pessoa (cpf, funcionario, nome, telefones, whatsapp)
VALUES ('60223146545', false, 'Jose da Silva', '62997563458', true);
INSERT INTO pessoa (cpf, funcionario, nome, telefones, whatsapp)
VALUES ('40223146545', false, 'Fernando Diego', '62997563458', false);
INSERT INTO pessoa (cpf, funcionario, nome, telefones, whatsapp)
VALUES ('60223146545', false, 'Julia de Oliveira', '62997563458', false);

select * from endereco p;
truncate endereco cascade;
INSERT INTO endereco (bairro, cep, complemento, logradouro, numero, municipio_id)
VALUES ('São Francisco', '74445661', 'QD. 4B LT. 25', 'Rua Ferreira', '505', 2174);
INSERT INTO endereco (bairro, cep, complemento, logradouro, numero, municipio_id)
VALUES ('Campinas', '74545661', 'QD. 15 LT. 40', 'Rua Santos', '60', 2174);
INSERT INTO endereco (bairro, cep, complemento, logradouro, numero, municipio_id)
VALUES ('Centro', '74445661', 'QD. 4B LT. 25', 'Rua Ferreira', '5', 2174);
INSERT INTO endereco (bairro, cep, complemento, logradouro, numero, municipio_id)
VALUES ('Setor Universitário', '76445661', 'QD. 4B LT. 25', 'Rua Ferreira', '40', 2174);
INSERT INTO endereco (bairro, cep, complemento, logradouro, numero, municipio_id)
VALUES ('São Francisco', '74445661', 'QD. 4B LT. 25', 'Rua Ferreira', '505', 2174);
INSERT INTO endereco (bairro, cep, complemento, logradouro, numero, municipio_id)
VALUES ('Campinas', '74545661', 'QD. 15 LT. 40', 'Rua Santos', '60', 2174);
INSERT INTO endereco (bairro, cep, complemento, logradouro, numero, municipio_id)
VALUES ('Centro', '74445661', 'QD. 4B LT. 25', 'Rua Ferreira', '5', 2174);
INSERT INTO endereco (bairro, cep, complemento, logradouro, numero, municipio_id)
VALUES ('Setor Universitário', '76445661', 'QD. 4B LT. 25', 'Rua Ferreira', '40', 2174);
INSERT INTO endereco (bairro, cep, complemento, logradouro, numero, municipio_id)
VALUES ('São Francisco', '74445661', 'QD. 4B LT. 25', 'Rua Ferreira', '505', 2174);
INSERT INTO endereco (bairro, cep, complemento, logradouro, numero, municipio_id)
VALUES ('Campinas', '74545661', 'QD. 15 LT. 40', 'Rua Santos', '60', 2174);
INSERT INTO endereco (bairro, cep, complemento, logradouro, numero, municipio_id)
VALUES ('Centro', '74445661', 'QD. 4B LT. 25', 'Rua Ferreira', '5', 2174);
INSERT INTO endereco (bairro, cep, complemento, logradouro, numero, municipio_id)
VALUES ('Setor Universitário', '76445661', 'QD. 4B LT. 25', 'Rua Ferreira', '40', 2174);
INSERT INTO endereco (bairro, cep, complemento, logradouro, numero, municipio_id)
VALUES ('São Francisco', '74445661', 'QD. 4B LT. 25', 'Rua Ferreira', '505', 2174);
INSERT INTO endereco (bairro, cep, complemento, logradouro, numero, municipio_id)
VALUES ('Campinas', '74545661', 'QD. 15 LT. 40', 'Rua Santos', '60', 2174);
INSERT INTO endereco (bairro, cep, complemento, logradouro, numero, municipio_id)
VALUES ('Centro', '74445661', 'QD. 4B LT. 25', 'Rua Ferreira', '5', 2174);
INSERT INTO endereco (bairro, cep, complemento, logradouro, numero, municipio_id)
VALUES ('Setor Universitário', '76445661', 'QD. 4B LT. 25', 'Rua Ferreira', '40', 2174);
INSERT INTO endereco (bairro, cep, complemento, logradouro, numero, municipio_id)
VALUES ('São Francisco', '74445661', 'QD. 4B LT. 25', 'Rua Ferreira', '505', 2174);
INSERT INTO endereco (bairro, cep, complemento, logradouro, numero, municipio_id)
VALUES ('Centro', '74445661', 'QD. 4B LT. 25', 'Rua Ferreira', '5', 2174);

