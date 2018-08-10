/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Gus
 * Created: 09/08/2018
 */


drop database if exists alunos_web_banco;
create database if not exists alunos_web_banco;

use alunos_web_banco;

CREATE TABLE alunos_web(
id             int AUTO_INCREMENT PRIMARY key,
nome           varchar(100),
matricula       varchar(100),
nota1          float,
nota2          float,
nota3          float,
frequencia     tinyint
);


