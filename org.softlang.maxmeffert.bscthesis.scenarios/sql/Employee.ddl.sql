CREATE TABLE `Employee` (
  `id` int(11) NOT NULL,
  `age` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `salary` double NOT NULL,
  `department_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK14tijxqry9ml17nk86sqfp561` (`department_id`),
  CONSTRAINT `FK14tijxqry9ml17nk86sqfp561` FOREIGN KEY (`department_id`) REFERENCES `Department` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;