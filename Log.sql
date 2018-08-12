CREATE TABLE `log` (
`id` int(11) NOT NULL AUTO_INCREMENT,
`trama_in` varchar(200) NOT NULL,
`trama_out` varchar(200) DEFAULT NULL,
`usuario` varchar(50) NOT NULL,
`fecha` varchar(20) NOT NULL,
PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=14 DEFAULT CHARSET=latin1
	