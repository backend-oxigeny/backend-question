insert into Usuario(nome, email, senha,img) values('julia', 'julia@julia.com', 'julia123','img.com.br')
insert into Usuario(nome, email, senha,img) values('newt', 'newt@newt.com', 'newt123','img.com.br')

insert into Pergunta(title,question,usuario_id) values('eu me preocupo','como vai vcs?',1)
insert into Pergunta(title,question,usuario_id) values('eu sou maluco','como eu faço uma api?',2)


insert into Resposta(answer, pergunta_id,usuario_id) values('estou bem!', 1,2)
insert into Resposta(answer, pergunta_id,usuario_id) values('tudo joia.', 1,2)
insert into Resposta(answer, pergunta_id,usuario_id) values('tem que praticar muito', 1,1)
