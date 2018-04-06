/*
OPERACIONES DE CRUD
*/
-- Listar materiales

SELECT `id`, `nombre`, `precio` FROM `material` ORDER BY `id` DESC LIMIT 500;


-- Busqueda de materiales

SELECT `id`, `nombre`, `precio` FROM `material` WHERE `nombre` LIKE '%a%' ORDER BY `id` DESC LIMIT 500;



-- Lectura (read) Detalle

SELECT id`, `nombre`, precio`FROM `material` WHERE `id`= 8;

-- Modificaciones (Update)

UPDATE `material` SET `nombre`="cerveza" WHERE `id` = 8;
 

--Eliminar (Delete)

DELETE FROM `material` WHERE `id` = 8;


--Insertar (Create)

INSERT INTO `material` (`nombre`, `precio`) VALUES ('cerveza tostada', '2');


