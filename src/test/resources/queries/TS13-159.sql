select * from books;

select id,name,author from books
where name = 'Clean Code' and author='Robert C.Martin'
order by id desc;

select id,name,author from books
where name = 'Clean Code'
order by id desc;

select name, author,year from books where name='Chordeiles minor';