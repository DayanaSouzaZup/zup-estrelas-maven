create database carro;

create table descricao_Carro (
placa varchar(30) not null primary key,
cor varchar(30) not null,
fabricante varchar(30) not null,
modelo varchar(30) not null );

insert into descricao_carro values 
('EIO - 3356', 'Preto', 'GM', 'Corsa'),
('SWE - 8754', 'Azul', 'BMW', 'X5'),
('ASC - 1234', 'Branco', 'VW', 'Voyage'),
('FRE - 6543', 'Prata', 'Fiat', 'Palio');

select * from descricao_carro