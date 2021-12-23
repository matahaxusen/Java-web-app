-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema mysql80_i_pickandbuy
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `mysql80_i_pickandbuy` ;

-- -----------------------------------------------------
-- Schema mysql80_i_pickandbuy
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mysql80_i_pickandbuy` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `mysql80_i_pickandbuy` ;

-- -----------------------------------------------------
-- Table `mysql80_i_pickandbuy`.`clients`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mysql80_i_pickandbuy`.`clients` (
  `name` VARCHAR(45) NOT NULL,
  `surname` VARCHAR(45) NOT NULL,
  `email` VARCHAR(90) NOT NULL,
  `pass` VARCHAR(45) NOT NULL,
  `city` VARCHAR(45) NOT NULL,
  `image` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`email`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `mysql80_i_pickandbuy`.`products`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mysql80_i_pickandbuy`.`products` (
  `id_product` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(65) NOT NULL,
  `category` VARCHAR(45) NOT NULL,
  `description` VARCHAR(500) NOT NULL,
  `image` VARCHAR(45) NOT NULL,
  `value` VARCHAR(45) NOT NULL,
  `owner` VARCHAR(45) NOT NULL,
  `state` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`id_product`),
  INDEX `owner_idx` (`owner` ASC) VISIBLE,
  CONSTRAINT `owner`
    FOREIGN KEY (`owner`)
    REFERENCES `mysql80_i_pickandbuy`.`clients` (`email`))
ENGINE = InnoDB
AUTO_INCREMENT = 23
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `mysql80_i_pickandbuy`.`bank`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mysql80_i_pickandbuy`.`bank` (
  `id_transaction` INT NOT NULL AUTO_INCREMENT,
  `buyer` VARCHAR(90) NOT NULL,
  `seller` VARCHAR(90) NOT NULL,
  `value` VARCHAR(45) NOT NULL,
  `product_id` INT NOT NULL,
  `product` VARCHAR(50),
  `date` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`id_transaction`),
  INDEX `buyer_idx` (`buyer` ASC, `seller` ASC) VISIBLE,
  INDEX `products_idx` (`product_id` ASC) VISIBLE,
  INDEX `seller_idx` (`seller` ASC) VISIBLE,
  CONSTRAINT `buyer`
    FOREIGN KEY (`buyer`)
    REFERENCES `mysql80_i_pickandbuy`.`clients` (`email`),
  CONSTRAINT `seller`
    FOREIGN KEY (`seller`)
    REFERENCES `mysql80_i_pickandbuy`.`clients` (`email`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- INSERT INTO `mysql80_i_pickandbuy`.`clients`
-- -----------------------------------------------------

INSERT INTO `mysql80_i_pickandbuy`.`clients` (`name`,`surname`,`email`,`pass`,`city`,`image`) VALUES ('PAULA', 'ALVAREZ REY','100366670@alumnos.uc3m.es','paula','Madrid', '100366670');
INSERT INTO `mysql80_i_pickandbuy`.`clients` (`name`,`surname`,`email`,`pass`,`city`,`image`) VALUES ('ORNELLA', 'BOLAÑOS ESCOBAR','100348718@alumnos.uc3m.es','ornella','Leon', '100348718');
INSERT INTO `mysql80_i_pickandbuy`.`clients` (`name`,`surname`,`email`,`pass`,`city`,`image`) VALUES ('ALEXANDRA ELENA', 'BONIS','100350472@alumnos.uc3m.es','alexandra','Madrid', '100350472');
INSERT INTO `mysql80_i_pickandbuy`.`clients` (`name`,`surname`,`email`,`pass`,`city`,`image`) VALUES ('DANIEL', 'CRESPO GARRIDO','100383445@alumnos.uc3m.es','daniel','Leon', '100383445');
INSERT INTO `mysql80_i_pickandbuy`.`clients` (`name`,`surname`,`email`,`pass`,`city`,`image`) VALUES ('PEDRO', 'DE LA TORRE DIAZ','100330636@alumnos.uc3m.es','pedro','Madrid', '100330636');
INSERT INTO `mysql80_i_pickandbuy`.`clients` (`name`,`surname`,`email`,`pass`,`city`,`image`) VALUES ('KHAOULA', 'EL MOURTAQI SAYED','100386293@alumnos.uc3m.es','khaoula','Madrid', '100386293');
INSERT INTO `mysql80_i_pickandbuy`.`clients` (`name`,`surname`,`email`,`pass`,`city`,`image`) VALUES ('CLAUDIA', 'FERNANDEZ BUSTO','100386204@alumnos.uc3m.es','claudia','Guadalajara', '100386204');
INSERT INTO `mysql80_i_pickandbuy`.`clients` (`name`,`surname`,`email`,`pass`,`city`,`image`) VALUES ('CRISTINA EUGENIA', 'GONZALEZ VILLASANTE','100366534@alumnos.uc3m.es','cristina','Sevilla', '100366534');
INSERT INTO `mysql80_i_pickandbuy`.`clients` (`name`,`surname`,`email`,`pass`,`city`,`image`) VALUES ('JAVIER', 'GRAU PRIETO','100348744@alumnos.uc3m.es','javier','Madrid', '100348744');
INSERT INTO `mysql80_i_pickandbuy`.`clients` (`name`,`surname`,`email`,`pass`,`city`,`image`) VALUES ('JUAN', 'LOBATO CAMACHO','100386292@alumnos.uc3m.es','juan','Madrid', '100386292');
INSERT INTO `mysql80_i_pickandbuy`.`clients` (`name`,`surname`,`email`,`pass`,`city`,`image`) VALUES ('JAIME', 'LOPEZ LANZAROT','100348921@alumnos.uc3m.es','jaime','Guadalajara', '100348921');
INSERT INTO `mysql80_i_pickandbuy`.`clients` (`name`,`surname`,`email`,`pass`,`city`,`image`) VALUES ('JOSE ANTONIO', 'MARTOS SANCHEZ','100383309@alumnos.uc3m.es','jose','Barcelona', '100383309');
INSERT INTO `mysql80_i_pickandbuy`.`clients` (`name`,`surname`,`email`,`pass`,`city`,`image`) VALUES ('ZHENGYI', 'ZHOU','100366562@alumnos.uc3m.es','zhengyi','Barcelona', '100366562');
INSERT INTO `mysql80_i_pickandbuy`.`clients` (`name`,`surname`,`email`,`pass`,`city`,`image`) VALUES ('RICARDO', 'ROLDÁN DONAIRE','100303759@alumnos.uc3m.es','ricardo','Madrid', '100303759');

-- -----------------------------------------------------
-- INSERT INTO `mysql80_i_pickandbuy`.`products`
-- -----------------------------------------------------

INSERT INTO `mysql80_i_pickandbuy`.`products` (`title`,`category`,`description`,`image`,`value`,`owner`,`state`) VALUES ('chaqueta vaquera','clothing','Chaqueta vaquera Lee original talla M pequeña, sisa de pecho 43 cms, altura 53 cms','i2240481912.webp','10','100383309@alumnos.uc3m.es','disponible');
INSERT INTO `mysql80_i_pickandbuy`.`products` (`title`,`category`,`description`,`image`,`value`,`owner`,`state`) VALUES ('AIRPODS V2 SIN CASI USO','electronics','Abiertos para ver que funcionan en su día y guardados en el cajon, ya que me regalaron los beats Studio. Tengo todo original la caja el cable de carga los dos auriculares y la caja de carga. Se venden por no usar IMPOLUTO. Regalo de funda de silicona','i2180072665.webp','110','100303759@alumnos.uc3m.es','disponible');
INSERT INTO `mysql80_i_pickandbuy`.`products` (`title`,`category`,`description`,`image`,`value`,`owner`,`state`) VALUES ('IPhone X 256GB IMPOLUTO','electronics','Lo vendo por que me han regalado el IPhone 12 Pro Max, siempre con funda y cristal templado. Salud de batería 81%','i2005850248.webp','465','100350472@alumnos.uc3m.es','disponible');
INSERT INTO `mysql80_i_pickandbuy`.`products` (`title`,`category`,`description`,`image`,`value`,`owner`,`state`) VALUES ('Chaqueta unisex','clothing','Chaqueta unisex pone talla 16 pero son más bien para niño o niña de 11 años de contextura delgada con forro por dentro, en buen estado como se ve en las fotos','i1828313583.webp','4.50','100366534@alumnos.uc3m.es','disponible');
INSERT INTO `mysql80_i_pickandbuy`.`products` (`title`,`category`,`description`,`image`,`value`,`owner`,`state`) VALUES ('Zapatillas Yves Saint Laurent pelo leopardo altas','clothing','Muy buen estado, usadas 2 o 3 veces, originales. No dudes en preguntar','i1840087761.webp','140','100366670@alumnos.uc3m.es','disponible');
INSERT INTO `mysql80_i_pickandbuy`.`products` (`title`,`category`,`description`,`image`,`value`,`owner`,`state`) VALUES ('Plancha de pelo','electronics','Plancha Rowenta blanca Para recoger en barrio de Begoña o Usera','i2236403953.webp','30','100386293@alumnos.uc3m.es','disponible');
INSERT INTO `mysql80_i_pickandbuy`.`products` (`title`,`category`,`description`,`image`,`value`,`owner`,`state`) VALUES ('Bicicleta carretera bh carbón classic','movility','Vendo bicicleta de carretera Bh carbón Classic talla L en perfectas condiciones. Componentes: Juegos de llantas carbono hi-tense. Cambios y frenos shimano 105. Platos y tija campagnolo.','i2221977107.webp','768','100350472@alumnos.uc3m.es','disponible');
INSERT INTO `mysql80_i_pickandbuy`.`products` (`title`,`category`,`description`,`image`,`value`,`owner`,`state`) VALUES ('Patinete eléctrico','movility','Prácticamente nuevo, usado 4 veces contadas, 2 velocidades, lo vendo con sillín incluido, se puede desmontar para ir con o sin el, luz frontal y trasera, fácil de guardar','i2299913397.webp','220','100330636@alumnos.uc3m.es','disponible');
INSERT INTO `mysql80_i_pickandbuy`.`products` (`title`,`category`,`description`,`image`,`value`,`owner`,`state`) VALUES ('Ciclomotor 50cc Peugeot Elystar','movility','Se vende Peugeot Elystar 50cc en buen estado de motor , tienes 21.280 kilómetros . Debido a una caída se rompió la manilla de freno y las tapas de la zona izquierda , pero la moto funciona perfectamente. Hay que cambiarla la batería y tiene la itv caducada de este mes de julio','i2038335862.webp','1200','100303759@alumnos.uc3m.es','disponible');
INSERT INTO `mysql80_i_pickandbuy`.`products` (`title`,`category`,`description`,`image`,`value`,`owner`,`state`) VALUES ('Libro de inglés (6 test) . Cambridge English C1','books','Libro con 6 test para preparación del examen de inglés C1 o Advance de la Univerdad de Cambridge. 2da edición. Lo compré para preparar el examen y al final, nunca lo llegué a usar. No se aceptan cambios por otros artículos.','i2297985639.webp','25','100366534@alumnos.uc3m.es','disponible');
INSERT INTO `mysql80_i_pickandbuy`.`products` (`title`,`category`,`description`,`image`,`value`,`owner`,`state`) VALUES ('Lote de 3 libros','books','Lote de 3 libros de Atila, Marco Polo y Anibal','i2300198274.webp','12.50','100330636@alumnos.uc3m.es','disponible');
INSERT INTO `mysql80_i_pickandbuy`.`products` (`title`,`category`,`description`,`image`,`value`,`owner`,`state`) VALUES ('2°, 3°,4° y 5° libro de la diversión de Martina','books','Están como nuevos.Estan como si fueras a una tienda y los estan recién comprados','i2302559221.webp','25','100303759@alumnos.uc3m.es','disponible');
INSERT INTO `mysql80_i_pickandbuy`.`products` (`title`,`category`,`description`,`image`,`value`,`owner`,`state`) VALUES ('Libro Flora de Madrid','books','Autor: Javier Grijalbo Cervantes iSBN:9788409119974 ','i2269661961.webp','18','100303759@alumnos.uc3m.es','disponible');
INSERT INTO `mysql80_i_pickandbuy`.`products` (`title`,`category`,`description`,`image`,`value`,`owner`,`state`) VALUES ('Abrigo acolchado Bimba y Lola','clothing','Acolchado nuevo a estrenar comprado está temporada en Bimba y Lola. Es de color verde con capucha extraíble con pelito marrón. Talla L que valdría también para M','i2300683332.webp','85','100366562@alumnos.uc3m.es','disponible');
INSERT INTO `mysql80_i_pickandbuy`.`products` (`title`,`category`,`description`,`image`,`value`,`owner`,`state`) VALUES ('Xiaomi, Mi Band 3','electronics','Pulsera Xiaomi Mi Band 3, color negro, en perfecto estado de presentación y de funcionamiento, con su caja original y su cargador y pulsera negra original. Pantalla táctil OLED de 0.78 pulgadas 120×80 píxeles. Batería: 110 mAh. Acelerómetro, pulsómetro, contador de calorías Impermeabilidad hasta 50 metros','i1883124651.webp','20','100350472@alumnos.uc3m.es','disponible');
INSERT INTO `mysql80_i_pickandbuy`.`products` (`title`,`category`,`description`,`image`,`value`,`owner`,`state`) VALUES ('Mamiya ZE Quartz cámara fotos','electronics','Mamiya ZE Quartz cámara de fotos con maletín. objetivos 28 - 50 y 135 mm. conjunto fotográfico para coleccionistas y amantes de la fotografía','i2304072491.webp','385','100348744@alumnos.uc3m.es','disponible');
INSERT INTO `mysql80_i_pickandbuy`.`products` (`title`,`category`,`description`,`image`,`value`,`owner`,`state`) VALUES ('Juego Ahora caigo','games','Juego de mesa Ahora caigo. Muy buen estado. Tiene todas las piezas y las instrucciones para jugar. Aún tiene dos tacos de tarjetas con el precinto puesto. Más juegos en mi perfil. Hago envíos. Zona de recogida Fuencarral, junto a Cardenal Herrera Oria','i2299770037.webp','15','100348718@alumnos.uc3m.es','disponible');
INSERT INTO `mysql80_i_pickandbuy`.`products` (`title`,`category`,`description`,`image`,`value`,`owner`,`state`) VALUES ('Cajas juegos Playstation 2','games','Se venden cajas vacías de varios juegos de la PlayStation 2. Precio por unidad','i2299473084.webp','2','100366534@alumnos.uc3m.es','disponible');
INSERT INTO `mysql80_i_pickandbuy`.`products` (`title`,`category`,`description`,`image`,`value`,`owner`,`state`) VALUES ('Juego de petanca','games','Juego de petanca','i2290668099.webp','10','100383445@alumnos.uc3m.es','disponible');
INSERT INTO `mysql80_i_pickandbuy`.`products` (`title`,`category`,`description`,`image`,`value`,`owner`,`state`) VALUES ('Juego Nintendo','games','Imagina ser veterinaria para nintendo 3DS','i733159594.webp','7.50','100386292@alumnos.uc3m.es','disponible');
INSERT INTO `mysql80_i_pickandbuy`.`products` (`title`,`category`,`description`,`image`,`value`,`owner`,`state`) VALUES ('Bang! El Duelo','games','Juego de mesa Bang! para dos personas. Bien cuidado.','i2252633237.webp','13','100348718@alumnos.uc3m.es','disponible');

INSERT INTO `mysql80_i_pickandbuy`.`bank` (`buyer`,`seller`,`value`,`product_id`,`product`,`date`) VALUES ('100330636@alumnos.uc3m.es','100348718@alumnos.uc3m.es','3250','333','Hyosung 600cc','1995-01-03');