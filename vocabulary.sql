-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Хост: 127.0.0.1
-- Время создания: Май 09 2015 г., 00:55
-- Версия сервера: 5.5.25
-- Версия PHP: 5.3.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- База данных: `vocabulary`
--

-- --------------------------------------------------------

--
-- Структура таблицы `englishvocabulary`
--

CREATE TABLE IF NOT EXISTS `englishvocabulary` (
`id_eng` int(11) NOT NULL,
  `word` varchar(200) NOT NULL,
  `id_rus` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `englishvocabulary`
--

INSERT INTO `englishvocabulary` (`id_eng`, `word`, `id_rus`) VALUES
(1, 'Hello', 1);

-- --------------------------------------------------------

--
-- Структура таблицы `russianvocabulary`
--

CREATE TABLE IF NOT EXISTS `russianvocabulary` (
`id_rus` int(11) NOT NULL,
  `word` varchar(200) NOT NULL,
  `id_eng` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `russianvocabulary`
--

INSERT INTO `russianvocabulary` (`id_rus`, `word`, `id_eng`) VALUES
(1, 'Привет', 1),
(3, 'Здравствуй', 1);

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `englishvocabulary`
--
ALTER TABLE `englishvocabulary`
 ADD PRIMARY KEY (`id_eng`);

--
-- Индексы таблицы `russianvocabulary`
--
ALTER TABLE `russianvocabulary`
 ADD PRIMARY KEY (`id_rus`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `englishvocabulary`
--
ALTER TABLE `englishvocabulary`
MODIFY `id_eng` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT для таблицы `russianvocabulary`
--
ALTER TABLE `russianvocabulary`
MODIFY `id_rus` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
