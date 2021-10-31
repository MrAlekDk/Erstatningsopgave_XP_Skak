INSERT INTO members (id,name,birthday,phoneNr,email,rank,login_id)
VALUES
(100,'Alexander','1998-07-13','42772069','alex030t@stud.kea.dk',10,1),
(101,'Anne','1981-01-10','12398745','anneNissen@gmail.com',-5,2),
(102,'Peter','1994-03-03','32167845','peter@gmail.com',4,3),
(103,'Kurt','1972-10-25','78998728','kurtVestergaard@gmail.com',50,4),
(104,'Ingeborg','1960-06-11','14862954','ingeborgSophiesen@gmail.com',-10,5),
(105,'Lars','1984-12-24','90846101','LarsPedersen@gmail.com',2,6);

INSERT INTO payments(payment_id,lastpd)
VALUES
(100,'2019-10-25'),
(101,'2020-10-25'),
(102,'2021-10-25'),
(103,'2020-10-25'),
(104,'2020-10-29'),
(105,'2020-10-25');

INSERT INTO tournaments(id,name,price,date)
VALUES
(400,'Ringkøbing skaktournering',1200,'2022-01-24'),
(401,'Roskilde skakprix',50000,'2022-06-24');
