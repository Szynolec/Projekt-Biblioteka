-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Czas generowania: 29 Sty 2023, 19:03
-- Wersja serwera: 10.4.25-MariaDB
-- Wersja PHP: 7.4.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `swing`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `klient`
--

CREATE TABLE `klient` (
  `Imie` varchar(20) DEFAULT NULL,
  `Nazwisko` varchar(20) DEFAULT NULL,
  `Adres` varchar(40) DEFAULT NULL,
  `Nr_telefonu` varchar(9) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Zrzut danych tabeli `klient`
--

INSERT INTO `klient` (`Imie`, `Nazwisko`, `Adres`, `Nr_telefonu`) VALUES
('Paweł', 'Iskierzyn', 'Zaborów', '421431233'),
('Janusz', 'Tracz', 'Rzeszów ul. 3 Maja 23', '143123543'),
('Adam', 'Małysz', 'Dunaj 123', '432954023'),
('Anna', 'Dygna', 'Rzeszów ulica Litewska 32', '796505324'),
('Stefan', 'Sałek', 'Malawa 540', '659934043');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `ksiazki`
--

CREATE TABLE `ksiazki` (
  `Autor` varchar(30) DEFAULT NULL,
  `Tytul` varchar(20) DEFAULT NULL,
  `Wydawnictwo` varchar(30) DEFAULT NULL,
  `Status` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Zrzut danych tabeli `ksiazki`
--

INSERT INTO `ksiazki` (`Autor`, `Tytul`, `Wydawnictwo`, `Status`) VALUES
('Jan Brzechwa', 'Akademia Pana Kleksa', 'Era', 'Dostepna'),
('Adam Mickiewicz', 'Reduta Ordona', 'Świat Książki', 'Dostepna'),
('Adam Mickiewicz', 'Dziady', 'Czytelnik', 'Wypozyczona'),
('Aleksander Fredro', 'Zemsta', 'Wolno', 'Wypozyczona'),
('Aleksander Kamiński', 'Kamienie Na Szaniec', 'Astrum', 'Wypozyczona'),
('Charles Dickens', 'Opowieść wigilijna', 'Era', 'Dostepna'),
('Henryk Sienkiewicz', 'Latarnik', 'Czytaj', 'Dostepna'),
('Julisz Słowacki', 'Balladyna', 'Ksiazka', 'Dostepna'),
('Stefan Żeromski', 'Syzyfowe Prace', 'Skrzat', 'Dostepne'),
('Sławomir Mrożek', 'Artysta', 'Literackie', 'Dostepna');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `pracownicy`
--

CREATE TABLE `pracownicy` (
  `Imie` varchar(20) DEFAULT NULL,
  `Nazwisko` varchar(20) DEFAULT NULL,
  `Login` varchar(20) DEFAULT NULL,
  `Haslo` varchar(20) DEFAULT NULL,
  `Nr_telefonu` int(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Zrzut danych tabeli `pracownicy`
--

INSERT INTO `pracownicy` (`Imie`, `Nazwisko`, `Login`, `Haslo`, `Nr_telefonu`) VALUES
('Janusz', 'Malec', 'JMal', 'maslo123', 143043123),
('Andrzej', 'Bąk', 'Bonks', 'kwd123', 876543265),
('Bartłomiej', 'Kowalski', 'Kowal', '123', 431654123),
('Halina', 'Nowak', 'HN12', 'projekt', 764255443),
('Jan', 'Walenty', 'Prac23', '543938', 543234543);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `wypozyczenia`
--

CREATE TABLE `wypozyczenia` (
  `Imie_Klienta` varchar(20) DEFAULT NULL,
  `Nazwisko_Klienta` varchar(20) DEFAULT NULL,
  `Tytul` varchar(20) DEFAULT NULL,
  `Data_Zwrotu` date DEFAULT NULL,
  `Kara` varchar(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Zrzut danych tabeli `wypozyczenia`
--

INSERT INTO `wypozyczenia` (`Imie_Klienta`, `Nazwisko_Klienta`, `Tytul`, `Data_Zwrotu`, `Kara`) VALUES
('Anna', 'Dygna', 'Zemsta', '2023-01-01', '20zl'),
('Anna', 'Dygna', 'Dziady', '2023-04-01', NULL),
('Paweł', 'Iskierszyn', 'Kamienie Na Szaniec', '2023-01-01', '20zl');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
