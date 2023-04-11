INSERT
INTO
  departments
  (name)
VALUES
  ('Ventas'),('Recursos Humanos'),('I&D'),('Marketing'),('Producción');


INSERT
INTO
  employees
  (name, last_name, photo, position_, phone, email, location, dni, salary, joining_date, birth_date,department_id)
VALUES
  ('Perico','Lospa Lotes', './photos/default.png', 'Currante','600123456','perico@lospa.com','Barcelona','12345678Z',1234.56,'2020-04-27','1987-07-05',1),
  ('Mihaela','Gheorghiu','./photos/MihaelaGheorghiu.jpg', 'Currante','600123456','perico@lospa.com','Barcelona','12345678Z',1234.56,'2020-04-27','1987-07-05',2),
  ('Gustavo','Ardaya', './photos/GustavoArdaya.jpg', 'Currante','600123456','perico@lospa.com','Barcelona','12345678Z',1234.56,'2020-04-27','1987-07-05',3),
  ('Daniel','Gallego' ,'./photos/DanielGallego.png', 'Currante','600123456','perico@lospa.com','Barcelona','12345678Z',1234.56,'2020-04-27', '1987-07-05',2),
  ('Jaume','Vidal' ,'./photos/JaumeVidal.png', 'Currante','600123456','perico@lospa.com','Barcelona','12345678Z',1234.56, '2020-04-27','1989-01-01',5),
  	('Anna Ludovika', 'Nieto Navarro', 'https://th.bing.com/th/id/R.3e6639b601e07e09e6b5c9382ea7f8ce?rik=7ca%2bYuJThoOfmw&riu=http%3a%2f%2fwww.accelpt.net%2fimages%2fslider%2fperson+(1).png&ehk=CVN2VY8L%2f6IBOJrEf%2b%2bG8umpds4Npn6PIPoGXVq2EA8%3d&risl=&pid=ImgRaw&r=0', 'Directora de ventas', '668943169', 'ananieto@gmail.com', 'Barcelona', '52834512Q', '2000', '2014-7-12', '1989-5-20',2),
  	('Diego Armando', 'Delgado Bueno', 'https://splitleasing-danmark.dk/wp-content/uploads/2021/04/NK-200x200.png', 'Encargado 1', '674328598', 'diegodelgado@gmail.com', 'Barcelona', 'Y7753236L', 1500, '2020-9-20', '2000-11-3',1),
  	('Minodora Eustaquia', 'Lafuente Diego', 'https://www.pensioennavigator.nl/wp-content/uploads/2018/01/vrouw.png', 'Encargado 2', '699453421', 'm_lafuente12@gmail.com', 'Badalona', '67845327L', '1500', '2016-5-15', '1980-10-9',1),
  	('Ferran Ramsés', 'Garcia Marin', 'https://www.levantinadeparquets.com/wp-content/uploads/2018/02/image-6-232x300.png', 'Mozzo almacen', '682924356', 'ferrangarcia@gmail.com', 'Sabadell', 'X9310591F', '800', '2022-12-6', '2001-7-2',2),
  	('George Jordan', 'Edwards Bray', 'https://historia.nationalgeographic.com.es/medio/2019/12/11/leonardo-da-vinci_527e74ea_300x300.jpg', 'Interno', '651414879', 'George_Jordan@gmail.com', 'Viladecans', '52086563G', '1342', '2014-10-2', '1982-8-20',2),
  	('Roberto George', 'Gomez Bolaños', 'https://www.undiacomohoy.com.mx/imagen/escala/2020/7/a1250/roberto-gomez-bolanos-chespirito-mexico-mx.jpg', 'Comunity Manager', '648953124', 'chespirito@gmail.com', 'Sabadell', '32492800X', '2100', '2021-10-12', '1995-2-15',2),
  	('Carlos Roberto', 'Estevez Templeton', 'https://images.live.dumontnext.de/live_95c5028d-5703-4823-ae2b-7e544636c9c8.jpg?w=862&auto=format&q=75&format=auto&s=0999fc9f10e4299ab84dc55cf57d4296', 'Seguridad', '612348975', 'tigerblood69@gmail.com', 'Cornella', 'Y9250771R', '1000', '2014-2-28', '1975-9-3',2),
  	('Enzo Gabriel', 'da Mata Almeida', 'https://i.pinimg.com/236x/32/2b/c1/322bc19596137e83316226b726de15c8--mr-bean-rowan.jpg', 'Líder Soluciones', '653540514', 'Enzo_Gabriel@gmail.com', 'Barcelona', 'Y8203720W', '1303', '2016-9-21', '1961-7-1',2),
  	('Diego Marcelo', 'Lopes da Cunha', 'https://sevilla.abc.es/personajes/admin/uploads/Arnold_Schwarzenegger.jpg', 'Programer Senior', '695137557', 'Diego_Marcelo@gmail.com', 'Hospitalet de Llobregat', '44895269M', '2763', '2022-2-19', '1963-4-12',4),
  	('Carolina Alana', 'Pires Cavalcanti', 'https://www.informador.mx/__export/1506064415808/sites/elinformador/img/historico/11/1028117.jpg_1970638775.jpg', 'Director Marca', '694385062', 'Carolina_Alana@gmail.com', 'Badalona', 'Z2245131Z', '1915', '2014-10-2', '1987-6-5',5),
  	('João Felipe', 'da Cunha Correia', 'https://cdn.shopify.com/s/files/1/1600/9673/files/jamesbond-sean_connery_large.png', 'Corporativo', '679269590', 'João_Felipe@gmail.com', 'Tarrasa', 'X7770128S', '2791', '2022-2-3', '1994-6-8',3),
  	('Pietra Amanda', 'Sales Martins', 'https://sevilla.abc.es/personajes/admin/uploads/angelina_jolie.jpg', 'Seguridad Interna', '662545698', 'Pietra_Amanda@gmail.com', 'Sabadell', '93099492T', '1571', '2016-6-4', '1978-6-25',2),
  	('Miss Kelly Jessica', 'Grant Sandoval', 'https://cdn2.chicmagazine.com.mx/uploads/media/2020/09/01/zendaya-antes-y-despues-de.jpg', 'Jefe de Investigación', '684158014', 'Miss_Kelly_Jessica@gmail.com', 'Lérida', 'Y5625580R', '2740', '2015-4-28', '1969-6-14',5),
  	('Yago Agustín', 'Redondo Tamarit', 'https://fototrending.com/wp-content/uploads/imagenes-mas-famosas-de-la-historia.jpg', 'Marketing Producto', '658426813', 'Yago_Agustín@gmail.com', 'Tarragona', '08754661X', '2122', '2018-3-30', '1991-4-18',4),
  	('Isaura Antonia', 'Ferreras Sanabria', 'https://sm.ign.com/t/ign_es/screenshot/default/the-15-best-sci-fi-movie-soundtracks-y6w6640_zp64.1280.jpg', 'Implementación Nacional', '683146728', 'Isaura_Antonia@gmail.com', 'Mataró', 'Y4117928E', '1473', '2017-10-12', '1996-11-21',2),
  	('Gonzalo Alfonso', 'Roman Pons', 'https://academiaplay.es/wp-content/uploads/2016/10/Sigmund-Freud.jpg', 'Implementación Regional', '686805969', 'Gonzalo_Alfonso@gmail.com', 'Santa Coloma de Gramanet', 'Z2270354Y', '1868', '2023-4-30', '1991-10-13',2),
  	('Teodosio Ernestino', 'Gomis Rebollo', 'https://academiaplay.es/wp-content/uploads/2016/10/Karl-Marx.jpg', 'Respuestas Distrito', '664970571', 'Teodosio_Ernestino@gmail.com', 'Reus', '01270038R', '2524', '2016-4-11', '1965-7-13',5),
  	('María del Carmen y Encarnación', 'Blanes Raya', 'https://images.everyeye.it/img-notizie/blonde-marilyn-monroe-svelata-identita-vero-padre-segreto-star-v3-580419.jpg', 'Respuestas Centrales', '671357348', 'Ma_Carmen_Encarna@gmail.com', 'Gerona', '21574895K', '1665', '2021-7-7', '1982-8-20',2),
  	('Brenda Kathleen', 'Johnson Gonzales', 'https://s1.eestatic.com/2017/09/27/actualidad/actualidad_249985847_48310625_864x486.jpg', 'Respuestas Globales', '676917665', 'Brenda_Kathleen@gmail.com', 'San Cugat del Vallés', '01697966Z', '1784', '2019-8-21', '1972-8-31',2),
  	('James Brandon', 'Black Berry', 'https://academiaplay.es/wp-content/uploads/2016/10/Nikola-Tesla.jpg', 'Aplicaciones', '691583489', 'James_Brandon@gmail.com', 'Cornellá de Llobregat', 'X0307995W', '2421', '2016-12-6', '1960-5-22',1),
  	('Destiny Final', 'Anderson Bennett', 'https://static.wikia.nocookie.net/finaldestination/images/4/4f/Wendy-FD3.png', 'Operaciones Cliente', '672028626', 'final_destiny@gmail.com', 'San Baudilio de Llobregat', '19412499Q', '2489', '2016-8-10', '1986-2-14',2);

