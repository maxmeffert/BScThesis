CREATE TABLE `Department` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `company_id` int(11) DEFAULT NULL,
  `manager_id` int(11) DEFAULT NULL,
  `superDepartment_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK574somh2okhg2lwdahfdw9hq0` (`company_id`),
  KEY `FK4376fbuulxj5ovpxrvb32l9d1` (`manager_id`),
  KEY `FK6td2bn6t9d1emtl28485r2ph4` (`superDepartment_id`),
  CONSTRAINT `FK4376fbuulxj5ovpxrvb32l9d1` FOREIGN KEY (`manager_id`) REFERENCES `Employee` (`id`),
  CONSTRAINT `FK574somh2okhg2lwdahfdw9hq0` FOREIGN KEY (`company_id`) REFERENCES `Company` (`id`),
  CONSTRAINT `FK6td2bn6t9d1emtl28485r2ph4` FOREIGN KEY (`superDepartment_id`) REFERENCES `Department` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;