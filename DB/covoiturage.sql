-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  lun. 14 juin 2021 à 16:17
-- Version du serveur :  10.4.10-MariaDB
-- Version de PHP :  5.6.40

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `covoiturage`
--

-- --------------------------------------------------------

--
-- Structure de la table `covoiturage`
--

DROP TABLE IF EXISTS `covoiturage`;
CREATE TABLE IF NOT EXISTS `covoiturage` (
  `idc` bigint(20) NOT NULL AUTO_INCREMENT,
  `date_arr` varchar(255) DEFAULT NULL,
  `date_depart` varchar(255) DEFAULT NULL,
  `heur_arr` varchar(255) DEFAULT NULL,
  `heur_depart` varchar(255) DEFAULT NULL,
  `ville_arr` varchar(255) DEFAULT NULL,
  `ville_depart` varchar(255) DEFAULT NULL,
  `id_user` bigint(20) DEFAULT NULL,
  `prix` float DEFAULT NULL,
  PRIMARY KEY (`idc`),
  KEY `FKarqfccqkwp0hn1eyqtkerp0tj` (`id_user`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `roles`
--

DROP TABLE IF EXISTS `roles`;
CREATE TABLE IF NOT EXISTS `roles` (
  `id_role` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id_role`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `id_user` bigint(20) NOT NULL AUTO_INCREMENT,
  `password` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `email_verification_status` bit(1) NOT NULL,
  `full_name` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `user_id` varchar(255) NOT NULL,
  PRIMARY KEY (`id_user`),
  UNIQUE KEY `UK6dotkott2kjsp8vw4d0m25fb7` (`email`),
  UNIQUE KEY `UK_6efs5vmce86ymf5q7lmvn2uuf` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `user_roles`
--

DROP TABLE IF EXISTS `user_roles`;
CREATE TABLE IF NOT EXISTS `user_roles` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FKh8ciramu9cc9q3qcqiv4ue8a6` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `ville`
--

DROP TABLE IF EXISTS `ville`;
CREATE TABLE IF NOT EXISTS `ville` (
  `idc` bigint(20) NOT NULL AUTO_INCREMENT,
  `name_vile` varchar(255) DEFAULT NULL,
  `covoiturage_idc` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`idc`),
  KEY `FK2ypn53n0t3ilsuso9nggrloat` (`covoiturage_idc`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `voiture`
--

DROP TABLE IF EXISTS `voiture`;
CREATE TABLE IF NOT EXISTS `voiture` (
  `matricule` varchar(255) NOT NULL,
  `typev` varchar(255) DEFAULT NULL,
  `color` varchar(255) DEFAULT NULL,
  `id_user` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`matricule`),
  KEY `FK707fcp103wr3txmommofx6gak` (`id_user`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `covoiturage`
--
ALTER TABLE `covoiturage`
  ADD CONSTRAINT `FKarqfccqkwp0hn1eyqtkerp0tj` FOREIGN KEY (`id_user`) REFERENCES `users` (`id_user`);

--
-- Contraintes pour la table `user_roles`
--
ALTER TABLE `user_roles`
  ADD CONSTRAINT `FKh8ciramu9cc9q3qcqiv4ue8a6` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id_role`),
  ADD CONSTRAINT `FKhfh9dx7w3ubf1co1vdev94g3f` FOREIGN KEY (`user_id`) REFERENCES `users` (`id_user`);

--
-- Contraintes pour la table `ville`
--
ALTER TABLE `ville`
  ADD CONSTRAINT `FK2ypn53n0t3ilsuso9nggrloat` FOREIGN KEY (`covoiturage_idc`) REFERENCES `covoiturage` (`idc`);

--
-- Contraintes pour la table `voiture`
--
ALTER TABLE `voiture`
  ADD CONSTRAINT `FK707fcp103wr3txmommofx6gak` FOREIGN KEY (`id_user`) REFERENCES `users` (`id_user`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
