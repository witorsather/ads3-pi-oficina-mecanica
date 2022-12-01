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

select * from endereco e;
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
select * from endereco e;

select * from veiculo;
truncate veiculo cascade;
INSERT INTO veiculo (ano, ano_modelo, km, placa, veiculo_id)
VALUES (2022, 2020, 50, 'SDU-6085', 5);
INSERT INTO veiculo (ano, ano_modelo, km, placa, veiculo_id)
VALUES (2021, 2021, 40, 'ABD-6085', 6);
INSERT INTO veiculo (ano, ano_modelo, km, placa, veiculo_id)
VALUES (2019, 2020, 30, 'AFG-6085', 7);
INSERT INTO veiculo (ano, ano_modelo, km, placa, veiculo_id)
VALUES (2015, 2016, 24, 'BFG-6085', 9);
INSERT INTO veiculo (ano, ano_modelo, km, placa, veiculo_id)
VALUES (2010, 2016, 24, 'TFG-6085', 8);
select * from veiculo;

select * from produto;
truncate produto cascade;
INSERT INTO produto (nome, preco_venda)
VALUES ('óleoo de motor', 56, 5);
INSERT INTO produto (nome, preco_venda)
VALUES ('pastilha de freio', 20, 6);
INSERT INTO produto (nome, preco_venda)
VALUES ('pneu', 200, 4);
INSERT INTO produto (nome, preco_venda)
VALUES ('parafuso de motor', 5, 5);
INSERT INTO produto (nome, preco_venda)
VALUES ('retrovisor', 15, 5);
select * from produto;

select * from servico;
truncate servico cascade;
INSERT INTO servico(nome, preco)
VALUES ('troca de pneu', 56, 5);
INSERT INTO produto (nome, preco_venda)
VALUES ('troca de óleo', 20, 6);
INSERT INTO produto (nome, preco_venda)
VALUES ('alinhamento de suspensão', 200, 4);
INSERT INTO produto (nome, preco_venda)
VALUES ('alinhamento dos bancos', 5, 5);
INSERT INTO produto (nome, preco_venda)
VALUES ('pintura do carro', 15, 5);
select * from servico;

select * from ordem_servico_produto osp ;
truncate ordem_servico_produto cascade;
INSERT INTO ordem_servico_produto(preco, quantidade, ordem_servico_produto_id)
VALUES (100, 1, 5);
INSERT INTO ordem_servico_produto(preco, quantidade, ordem_servico_produto_id)
VALUES (256, 2, 6);
INSERT INTO ordem_servico_produto(preco, quantidade, ordem_servico_produto_id)
VALUES (456, 6, 7);
INSERT INTO ordem_servico_produto(preco, quantidade, ordem_servico_produto_id)
VALUES (152, 5, 8);
INSERT INTO ordem_servico_produto(preco, quantidade, ordem_servico_produto_id)
VALUES (45, 10, 9);

select * from ordem_servico_servico oss;
truncate ordem_servico_servico cascade;
INSERT INTO ordem_servico_servico(preco, quantidade, ordem_servico_servico_id)
VALUES (100, 1, 5);
INSERT INTO ordem_servico_servico(preco, quantidade, ordem_servico_servico_id)
VALUES (256, 2, 6);
INSERT INTO ordem_servico_servico(preco, quantidade, ordem_servico_servico_id)
VALUES (456, 6, 7);
INSERT INTO ordem_servico_servico(preco, quantidade, ordem_servico_servico_id)
VALUES (152, 5, 8);
INSERT INTO ordem_servico_servico(preco, quantidade, ordem_servico_servico_id)
VALUES (45, 10, 9);

select * from ordem_servico os;
truncate ordem_servico cascade;
INSERT INTO ordem_servico(data, data_entrada, data_entrega, data_fim_servico, data_inicio_servico, data_os, desconto, funcionario_id, pessoa_id, veiculo_id)
VALUES (100, 1, 5);

