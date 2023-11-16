INSERT INTO finca (nombre, direccion, hectareas, leche ) VALUES ('Lolita','Avenida 1',1000.0, 0.0);


INSERT INTO usuarios (username, password,  enabled, role) VALUES ('trabajador','$2a$10$iqlmJIMdAr/ISOZqUVHtuO.1/CWBcj9hVcT0E7/vtp1FjrUxG6g0K',true, 'TRABAJADOR');
INSERT INTO trabajador (nombre, apellido, cedula, correo, cargo, fecha, finca_id, usuario_id) VALUES ('Brayan','Duque','12345678','abcd@gmail.com','EMPLEADO','2000-01-01',1,1);

INSERT INTO usuarios (username, password,  enabled, role) VALUES ('admin','$2a$10$Qh5I7eqNWYAttYr/J6kobeaXje0r17/iHxcH/ALJfXc5bBrvuIF1O',true,'ADMIN');
INSERT INTO trabajador (nombre, apellido, cedula,correo, cargo, fecha, finca_id, usuario_id) VALUES ('Oscar','Garces','1126598160','abcef@gmail.com','ADMINISTRADOR','2000-01-01',1,2);

INSERT INTO usuarios (username, password, enabled, role) VALUES ('veterinario','$2a$10$C3Uln5uqnzx/GswADURJGOIdBqYrly9731fnwKDaUdBkt/M3qvtLq',true, 'VETERINARIO');
INSERT INTO trabajador (nombre, apellido, cedula, correo, cargo, fecha, finca_id, usuario_id) VALUES ('Alejandro','Castano','12534543','abc@gmail.com','VETERINARIO','2000-01-01',1,3);



INSERT INTO vaca (nombre, raza, finca_id) VALUES ('Lola','Brahama', 1);
INSERT INTO vaca (nombre, raza, finca_id) VALUES ('Manuela','Gyr', 1);
INSERT INTO vaca (nombre, raza, finca_id) VALUES ('Antonia','Cebu', 1);
INSERT INTO vaca (nombre, raza, finca_id) VALUES ('Florencia','Foster', 1);

INSERT INTO vacuna (nombre, tipo) VALUES ('Ebola','C');
INSERT INTO vacuna (nombre, tipo) VALUES ('Antrax','A');






