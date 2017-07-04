-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: 25-Nov-2015 às 18:20
-- Versão do servidor: 10.0.17-MariaDB
-- PHP Version: 5.5.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `leagues`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `campeoes`
--

CREATE TABLE `campeoes` (
  `nome` varchar(255) NOT NULL,
  `funcao` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `campeoes`
--

INSERT INTO `campeoes` (`nome`, `funcao`) VALUES
('Anivia', 'Mage'),
('Garen', 'Tank'),
('Lucian', 'AD Carry'),
('Teste', 'Carry');

-- --------------------------------------------------------

--
-- Estrutura da tabela `campeonato`
--

CREATE TABLE `campeonato` (
  `nome` varchar(255) NOT NULL,
  `paisOrigem` varchar(255) DEFAULT NULL,
  `localEvento_nome` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `campeonato_jogo`
--

CREATE TABLE `campeonato_jogo` (
  `Campeonato_nome` varchar(255) NOT NULL,
  `jogos_numero` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `campeonato_midia`
--

CREATE TABLE `campeonato_midia` (
  `Campeonato_nome` varchar(255) NOT NULL,
  `midias_nome` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `campeonato_pessoa`
--

CREATE TABLE `campeonato_pessoa` (
  `Campeonato_nome` varchar(255) NOT NULL,
  `funcionarios_nome` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `campeonato_times`
--

CREATE TABLE `campeonato_times` (
  `Campeonato_nome` varchar(255) NOT NULL,
  `times_nome` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `equipamento`
--

CREATE TABLE `equipamento` (
  `nome` varchar(255) NOT NULL,
  `marca` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `equipamento`
--

INSERT INTO `equipamento` (`nome`, `marca`) VALUES
('Mouse Razer', 'Razer'),
('Siberia V2', 'SteelSeries');

-- --------------------------------------------------------

--
-- Estrutura da tabela `jogo`
--

CREATE TABLE `jogo` (
  `numero` int(11) NOT NULL,
  `campeonato_nome` varchar(255) DEFAULT NULL,
  `time1_nome` varchar(255) DEFAULT NULL,
  `time2_nome` varchar(255) DEFAULT NULL,
  `vencedor_nome` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `localevento`
--

CREATE TABLE `localevento` (
  `nome` varchar(255) NOT NULL,
  `capacidade` int(11) NOT NULL,
  `endereco` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `localevento`
--

INSERT INTO `localevento` (`nome`, `capacidade`, `endereco`) VALUES
('Arena Mercedes', 40000, 'Alemanha.....');

-- --------------------------------------------------------

--
-- Estrutura da tabela `midia`
--

CREATE TABLE `midia` (
  `nome` varchar(255) NOT NULL,
  `descricao` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `midia`
--

INSERT INTO `midia` (`nome`, `descricao`) VALUES
('AzubuTV', 'Exibe os Videos dos Jogos'),
('teste123', 'uasdfisdhdif'),
('Youtube', 'gayuegasuegye');

-- --------------------------------------------------------

--
-- Estrutura da tabela `patrocinador`
--

CREATE TABLE `patrocinador` (
  `nome` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `patrocinador`
--

INSERT INTO `patrocinador` (`nome`) VALUES
('Patrocinador 1'),
('Razer'),
('SteelSeries');

-- --------------------------------------------------------

--
-- Estrutura da tabela `pessoa`
--

CREATE TABLE `pessoa` (
  `DTYPE` varchar(31) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `idade` int(11) NOT NULL,
  `paisOrigem` varchar(255) DEFAULT NULL,
  `rota` varchar(255) DEFAULT NULL,
  `funcao` varchar(255) DEFAULT NULL,
  `time_nome` varchar(255) DEFAULT NULL,
  `timeAnterior_nome` varchar(255) DEFAULT NULL,
  `timeAtual_nome` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `pessoa`
--

INSERT INTO `pessoa` (`DTYPE`, `nome`, `idade`, `paisOrigem`, `rota`, `funcao`, `time_nome`, `timeAnterior_nome`, `timeAtual_nome`) VALUES
('Jogador', 'Alex "Gordox" Menezes', 25, 'brasileiro', 'Caçador', NULL, 'Time teste', NULL, NULL),
('Jogador', 'Flavio "Lates" Abrahão', 23, 'Frances', 'topo', NULL, 'Time de Estrelas', NULL, NULL),
('Staff', 'Joao', 23, 'Brasileiro', NULL, 'Tecnico de SOm', NULL, NULL, NULL),
('Jogador', 'nomezinho', 23, 'hsduasfi', 'top', NULL, 'Time teste', NULL, NULL),
('Jogador', 'shaudhasu', 12, 'sahhsausah', 'wqieoqw', NULL, 'Time teste', NULL, NULL),
('Coach', 'Tecnico Teste', 0, NULL, NULL, NULL, NULL, NULL, 'Time de Estrelas');

-- --------------------------------------------------------

--
-- Estrutura da tabela `pessoa_campeoes`
--

CREATE TABLE `pessoa_campeoes` (
  `Pessoa_nome` varchar(255) NOT NULL,
  `campeoesMaisJogados_nome` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `pessoa_campeoes`
--

INSERT INTO `pessoa_campeoes` (`Pessoa_nome`, `campeoesMaisJogados_nome`) VALUES
('nomezinho', 'Anivia'),
('nomezinho', 'Garen'),
('nomezinho', 'Lucian'),
('Alex "Gordox" Menezes', 'Garen'),
('Alex "Gordox" Menezes', 'Lucian');

-- --------------------------------------------------------

--
-- Estrutura da tabela `pessoa_equipamento`
--

CREATE TABLE `pessoa_equipamento` (
  `Pessoa_nome` varchar(255) NOT NULL,
  `equips_nome` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `pessoa_equipamento`
--

INSERT INTO `pessoa_equipamento` (`Pessoa_nome`, `equips_nome`) VALUES
('Alex "Gordox" Menezes', 'Mouse Razer');

-- --------------------------------------------------------

--
-- Estrutura da tabela `times`
--

CREATE TABLE `times` (
  `nome` varchar(255) NOT NULL,
  `treinador_nome` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `times`
--

INSERT INTO `times` (`nome`, `treinador_nome`) VALUES
('Time de Estrelas', NULL),
('Time teste', NULL);

-- --------------------------------------------------------

--
-- Estrutura da tabela `times_patrocinador`
--

CREATE TABLE `times_patrocinador` (
  `Times_nome` varchar(255) NOT NULL,
  `patrocinadores_nome` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `times_patrocinador`
--

INSERT INTO `times_patrocinador` (`Times_nome`, `patrocinadores_nome`) VALUES
('Time de Estrelas', 'Patrocinador 1'),
('Time de Estrelas', 'Razer');

-- --------------------------------------------------------

--
-- Estrutura da tabela `times_pessoa`
--

CREATE TABLE `times_pessoa` (
  `Times_nome` varchar(255) NOT NULL,
  `jogadores_nome` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `times_pessoa`
--

INSERT INTO `times_pessoa` (`Times_nome`, `jogadores_nome`) VALUES
('Time de Estrelas', 'Flavio "Lates" Abrahão'),
('Time teste', 'Alex "Gordox" Menezes'),
('Time teste', 'nomezinho'),
('Time teste', 'shaudhasu');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `campeoes`
--
ALTER TABLE `campeoes`
  ADD PRIMARY KEY (`nome`);

--
-- Indexes for table `campeonato`
--
ALTER TABLE `campeonato`
  ADD PRIMARY KEY (`nome`),
  ADD KEY `FK_n8pxe9rhbdwh2v65l8etmmt0b` (`localEvento_nome`);

--
-- Indexes for table `campeonato_jogo`
--
ALTER TABLE `campeonato_jogo`
  ADD UNIQUE KEY `UK_b71fs4q8jsjiwylwduop52gk5` (`jogos_numero`),
  ADD KEY `FK_rw2xgmgd8arj1pia02x8lfih9` (`Campeonato_nome`);

--
-- Indexes for table `campeonato_midia`
--
ALTER TABLE `campeonato_midia`
  ADD UNIQUE KEY `UK_4ombjv9hwuem8o4ivoyfkkapk` (`midias_nome`),
  ADD KEY `FK_ohuc5hnr4lqqre8yag9psg937` (`Campeonato_nome`);

--
-- Indexes for table `campeonato_pessoa`
--
ALTER TABLE `campeonato_pessoa`
  ADD UNIQUE KEY `UK_s05gdq8hvbs2k1cum7pp22y9c` (`funcionarios_nome`),
  ADD KEY `FK_t9y7cnm1x957v2nnqth628epi` (`Campeonato_nome`);

--
-- Indexes for table `campeonato_times`
--
ALTER TABLE `campeonato_times`
  ADD UNIQUE KEY `UK_qqyx7ei0ddkgqtf7csdyhm1yu` (`times_nome`),
  ADD KEY `FK_qisauwdp7v6f7e8qkmuvgx9pl` (`Campeonato_nome`);

--
-- Indexes for table `equipamento`
--
ALTER TABLE `equipamento`
  ADD PRIMARY KEY (`nome`);

--
-- Indexes for table `jogo`
--
ALTER TABLE `jogo`
  ADD PRIMARY KEY (`numero`),
  ADD KEY `FK_d3jw2mnpt5g35h5tff839nfc4` (`campeonato_nome`),
  ADD KEY `FK_f6o0lhgt4f614y5g06piaq06n` (`time1_nome`),
  ADD KEY `FK_46l8dl35rbcm8iwffyrse0i7c` (`time2_nome`),
  ADD KEY `FK_57g4ctdck9evt3wc82c3n6jr5` (`vencedor_nome`);

--
-- Indexes for table `localevento`
--
ALTER TABLE `localevento`
  ADD PRIMARY KEY (`nome`);

--
-- Indexes for table `midia`
--
ALTER TABLE `midia`
  ADD PRIMARY KEY (`nome`);

--
-- Indexes for table `patrocinador`
--
ALTER TABLE `patrocinador`
  ADD PRIMARY KEY (`nome`);

--
-- Indexes for table `pessoa`
--
ALTER TABLE `pessoa`
  ADD PRIMARY KEY (`nome`),
  ADD KEY `FK_3rtpmh58sf5qvdxkomy3kpjet` (`time_nome`),
  ADD KEY `FK_mtmoli6rwa1onpe84y3vkroh5` (`timeAnterior_nome`),
  ADD KEY `FK_da4e8epfe1cogilsl94otay11` (`timeAtual_nome`);

--
-- Indexes for table `pessoa_campeoes`
--
ALTER TABLE `pessoa_campeoes`
  ADD KEY `FK_kdmo7lsk5ib3c65qx7qxgmrjk` (`campeoesMaisJogados_nome`),
  ADD KEY `FK_cl6f8fb6t2tm75ak8egirm4bg` (`Pessoa_nome`);

--
-- Indexes for table `pessoa_equipamento`
--
ALTER TABLE `pessoa_equipamento`
  ADD UNIQUE KEY `UK_364knelorvkdr0vtq2h7qi3ns` (`equips_nome`),
  ADD KEY `FK_nqe6wq1a2k759ychbddhekqe2` (`Pessoa_nome`);

--
-- Indexes for table `times`
--
ALTER TABLE `times`
  ADD PRIMARY KEY (`nome`),
  ADD KEY `FK_s8n0ajpfh1pj8kqeway3m6op6` (`treinador_nome`);

--
-- Indexes for table `times_patrocinador`
--
ALTER TABLE `times_patrocinador`
  ADD UNIQUE KEY `UK_8dy5ayxgvgf2y6afksyydqkgr` (`patrocinadores_nome`),
  ADD KEY `FK_24ng4yd81n2rckt2iig82uwou` (`Times_nome`);

--
-- Indexes for table `times_pessoa`
--
ALTER TABLE `times_pessoa`
  ADD UNIQUE KEY `UK_6bxch86ha4j7i06j50drikdie` (`jogadores_nome`),
  ADD KEY `FK_m5bgq185xhj4afjcgblks42j3` (`Times_nome`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `jogo`
--
ALTER TABLE `jogo`
  MODIFY `numero` int(11) NOT NULL AUTO_INCREMENT;
--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `campeonato`
--
ALTER TABLE `campeonato`
  ADD CONSTRAINT `FK_n8pxe9rhbdwh2v65l8etmmt0b` FOREIGN KEY (`localEvento_nome`) REFERENCES `localevento` (`nome`);

--
-- Limitadores para a tabela `campeonato_jogo`
--
ALTER TABLE `campeonato_jogo`
  ADD CONSTRAINT `FK_b71fs4q8jsjiwylwduop52gk5` FOREIGN KEY (`jogos_numero`) REFERENCES `jogo` (`numero`),
  ADD CONSTRAINT `FK_rw2xgmgd8arj1pia02x8lfih9` FOREIGN KEY (`Campeonato_nome`) REFERENCES `campeonato` (`nome`);

--
-- Limitadores para a tabela `campeonato_midia`
--
ALTER TABLE `campeonato_midia`
  ADD CONSTRAINT `FK_4ombjv9hwuem8o4ivoyfkkapk` FOREIGN KEY (`midias_nome`) REFERENCES `midia` (`nome`),
  ADD CONSTRAINT `FK_ohuc5hnr4lqqre8yag9psg937` FOREIGN KEY (`Campeonato_nome`) REFERENCES `campeonato` (`nome`);

--
-- Limitadores para a tabela `campeonato_pessoa`
--
ALTER TABLE `campeonato_pessoa`
  ADD CONSTRAINT `FK_s05gdq8hvbs2k1cum7pp22y9c` FOREIGN KEY (`funcionarios_nome`) REFERENCES `pessoa` (`nome`),
  ADD CONSTRAINT `FK_t9y7cnm1x957v2nnqth628epi` FOREIGN KEY (`Campeonato_nome`) REFERENCES `campeonato` (`nome`);

--
-- Limitadores para a tabela `campeonato_times`
--
ALTER TABLE `campeonato_times`
  ADD CONSTRAINT `FK_qisauwdp7v6f7e8qkmuvgx9pl` FOREIGN KEY (`Campeonato_nome`) REFERENCES `campeonato` (`nome`),
  ADD CONSTRAINT `FK_qqyx7ei0ddkgqtf7csdyhm1yu` FOREIGN KEY (`times_nome`) REFERENCES `times` (`nome`);

--
-- Limitadores para a tabela `jogo`
--
ALTER TABLE `jogo`
  ADD CONSTRAINT `FK_46l8dl35rbcm8iwffyrse0i7c` FOREIGN KEY (`time2_nome`) REFERENCES `times` (`nome`),
  ADD CONSTRAINT `FK_57g4ctdck9evt3wc82c3n6jr5` FOREIGN KEY (`vencedor_nome`) REFERENCES `times` (`nome`),
  ADD CONSTRAINT `FK_d3jw2mnpt5g35h5tff839nfc4` FOREIGN KEY (`campeonato_nome`) REFERENCES `campeonato` (`nome`),
  ADD CONSTRAINT `FK_f6o0lhgt4f614y5g06piaq06n` FOREIGN KEY (`time1_nome`) REFERENCES `times` (`nome`);

--
-- Limitadores para a tabela `pessoa`
--
ALTER TABLE `pessoa`
  ADD CONSTRAINT `FK_3rtpmh58sf5qvdxkomy3kpjet` FOREIGN KEY (`time_nome`) REFERENCES `times` (`nome`),
  ADD CONSTRAINT `FK_da4e8epfe1cogilsl94otay11` FOREIGN KEY (`timeAtual_nome`) REFERENCES `times` (`nome`),
  ADD CONSTRAINT `FK_mtmoli6rwa1onpe84y3vkroh5` FOREIGN KEY (`timeAnterior_nome`) REFERENCES `times` (`nome`);

--
-- Limitadores para a tabela `pessoa_campeoes`
--
ALTER TABLE `pessoa_campeoes`
  ADD CONSTRAINT `FK_cl6f8fb6t2tm75ak8egirm4bg` FOREIGN KEY (`Pessoa_nome`) REFERENCES `pessoa` (`nome`),
  ADD CONSTRAINT `FK_kdmo7lsk5ib3c65qx7qxgmrjk` FOREIGN KEY (`campeoesMaisJogados_nome`) REFERENCES `campeoes` (`nome`);

--
-- Limitadores para a tabela `pessoa_equipamento`
--
ALTER TABLE `pessoa_equipamento`
  ADD CONSTRAINT `FK_364knelorvkdr0vtq2h7qi3ns` FOREIGN KEY (`equips_nome`) REFERENCES `equipamento` (`nome`),
  ADD CONSTRAINT `FK_nqe6wq1a2k759ychbddhekqe2` FOREIGN KEY (`Pessoa_nome`) REFERENCES `pessoa` (`nome`);

--
-- Limitadores para a tabela `times`
--
ALTER TABLE `times`
  ADD CONSTRAINT `FK_s8n0ajpfh1pj8kqeway3m6op6` FOREIGN KEY (`treinador_nome`) REFERENCES `pessoa` (`nome`);

--
-- Limitadores para a tabela `times_patrocinador`
--
ALTER TABLE `times_patrocinador`
  ADD CONSTRAINT `FK_24ng4yd81n2rckt2iig82uwou` FOREIGN KEY (`Times_nome`) REFERENCES `times` (`nome`),
  ADD CONSTRAINT `FK_8dy5ayxgvgf2y6afksyydqkgr` FOREIGN KEY (`patrocinadores_nome`) REFERENCES `patrocinador` (`nome`);

--
-- Limitadores para a tabela `times_pessoa`
--
ALTER TABLE `times_pessoa`
  ADD CONSTRAINT `FK_6bxch86ha4j7i06j50drikdie` FOREIGN KEY (`jogadores_nome`) REFERENCES `pessoa` (`nome`),
  ADD CONSTRAINT `FK_m5bgq185xhj4afjcgblks42j3` FOREIGN KEY (`Times_nome`) REFERENCES `times` (`nome`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
