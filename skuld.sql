DROP DATABASE IF EXISTS skuld;

CREATE DATABASE IF NOT EXISTS skuld;

USE skuld;

CREATE TABLE IF NOT EXISTS enderecos (
  id INT NOT NULL AUTO_INCREMENT,
  cep VARCHAR(10) NOT NULL,
  logradouro VARCHAR(140) NULL DEFAULT NULL,
  bairro VARCHAR(80) NULL DEFAULT NULL,
  localidade VARCHAR(80) NOT NULL,
  uf VARCHAR(2) NOT NULL,
  CONSTRAINT pk_endereco PRIMARY KEY (id))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS usuarios (
  id INT NOT NULL AUTO_INCREMENT,
  primeiro_nome VARCHAR(60) NOT NULL,
  segundo_nome VARCHAR(60) NOT NULL,
  cpf VARCHAR(20) NOT NULL,
  nascimento DATE NOT NULL,
  id_endereco INT NULL DEFAULT NULL,
  email VARCHAR(80) NOT NULL,
  senha VARCHAR(255) NOT NULL,
  renda DOUBLE NOT NULL,
  criado_em DATETIME NOT NULL,
  atualizado_em DATETIME NULL DEFAULT NULL,
  CONSTRAINT pk_usuario PRIMARY KEY (id),
  CONSTRAINT fk_endereco FOREIGN KEY (id_endereco) REFERENCES enderecos(id))
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS bandeiras (
  id INT NOT NULL AUTO_INCREMENT,
  descricao VARCHAR(60) NOT NULL,
  CONSTRAINT pk_bandeira PRIMARY KEY (id))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS cartoes (
   id INT NOT NULL AUTO_INCREMENT,
   id_usuario INT NOT NULL,
   id_bandeira INT NOT NULL,
   numero VARCHAR(19) NOT NULL,
   mes_validade INT NOT NULL,
   ano_validade INT NOT NULL,
   cvc INT NOT NULL,
   limite DOUBLE NOT NULL,
   CONSTRAINT pk_cartoes PRIMARY KEY (id),
   CONSTRAINT fk_cartoes_bandeiras FOREIGN KEY (id_bandeira) REFERENCES bandeiras (id)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT fk_cartoes_usuarios FOREIGN KEY (id_usuario) REFERENCES usuarios (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;

INSERT INTO bandeiras (descricao) VALUES ("Visa"), ("MasterCard"), ("Diners Club"), ("American Express");
