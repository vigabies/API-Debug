Create table Aluno(
   id bigint not null primary key auto_increment,
   nomealuno varchar(150),
   curso_id int not null
);

insert into aluno(nomealuno, curso_id) values ('Rogério', 4);
insert into aluno(nomealuno, curso_id) values ('Maria', 1);
insert into aluno(nomealuno, curso_id) values ('Joana', 1);
insert into aluno(nomealuno, curso_id) values ('José', 3);
insert into aluno(nomealuno, curso_id) values ('Ana Clara', 4);
insert into aluno(nomealuno, curso_id) values ('Betania', 2);