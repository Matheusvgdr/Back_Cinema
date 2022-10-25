CREATE DATABASE db_filmes;

use db_filmes;

CREATE TABLE tb_categorias(
	id int PRIMARY KEY AUTO_INCREMENT,
  	titulo varchar(120) NOT NULL,
  	imagePath varchar(255) NOT NULL
);

CREATE TABLE tb_filmes(
  	id int PRIMARY KEY AUTO_INCREMENT NOT NULL,
  	descricao varchar(110) NOT NULL,
  	duracao varchar(23) NOT NULL,
	ano varchar(7) NOT NULL,
  	indicacao varchar(20) NOT NULL,
  	imagePath varchar(150) NOT NULL,  	
  	categoriaId int NOT NULL
);

//----------------------------------------------------------------------------------------------------

INSERT INTO tb_categorias(titulo, imagePath) VALUES("Terror", "../../assets/images/dracula.png");

INSERT INTO tb_filmes (descricao, duracao, ano, indicacao, imagePath, categoriaId)
VALUES ("Rogai por nós", "1h 39m", "2021", "14 anos", "../../assets/images/movies/rogai.jpg", 1);

//----------------------------------------------------------------------------------------------------

ALTER TABLE tb_filmes ADD CONSTRAINT fk_categ FOREIGN KEY(categoriaId) REFERENCES tb_categorias(id);