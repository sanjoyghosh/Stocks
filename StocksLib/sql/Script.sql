ALTER TABLE `Stocks`.`Stock` DROP PRIMARY KEY;

ALTER TABLE `Stocks`.`Stock` DROP INDEX `Stock`.`symbol_UNIQUE`;

DROP TABLE `Stocks`.`Stock`;

CREATE TABLE `Stocks`.`Stock` (
	`id` INT NOT NULL,
	`name` VARCHAR(128) NOT NULL,
	`symbol` VARCHAR(48) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE UNIQUE INDEX `symbol_UNIQUE` ON `Stocks`.`Stock` (`symbol` ASC);



--<ScriptOptions statementTerminator=";"/>

ALTER TABLE `Stocks`.`AnalystOpinionYahoo` DROP PRIMARY KEY;

DROP TABLE `Stocks`.`AnalystOpinionYahoo`;

CREATE TABLE `Stocks`.`AnalystOpinionYahoo` (
	`id` INT NOT NULL,
	`stockId` INT NOT NULL,
	`createdDate` INT NOT NULL,
	`meanRecommendationThisWeek` FLOAT NOT NULL,
	`meanRecommendationLastWeek` FLOAT NOT NULL,
	`changeMeanRecommendation` FLOAT NOT NULL,
	`meanTarget` FLOAT NOT NULL,
	`medianTarget` FLOAT NOT NULL,
	`highTarget` FLOAT NOT NULL,
	`lowTarget` FLOAT NOT NULL,
	`numberOfBrokers` INT NOT NULL,
	`strongBuyCurrentMonth` INT NOT NULL,
	`strongBuyLastMonth` INT NOT NULL,
	`strongBuyTwoMonthsAgo` INT NOT NULL,
	`strongBuyThreeMonthsAgo` INT NOT NULL,
	`buyCurrentMonth` INT NOT NULL,
	`buyLastMonth` INT NOT NULL,
	`buyTwoMonthsAgo` INT NOT NULL,
	`buyThreeMonthsAgo` INT NOT NULL,
	`holdCurrentMonth` INT NOT NULL,
	`holdLastMonth` INT NOT NULL,
	`holdTwoMonthsAgo` INT NOT NULL,
	`holdThreeMonthsAgo` INT NOT NULL,
	`underperformCurrentMonth` INT NOT NULL,
	`underperformLastMonth` INT NOT NULL,
	`underperformTwoMonthsAgo` INT NOT NULL,
	`underperformThreeMonthsAgo` INT NOT NULL,
	`sellCurrentMonth` INT NOT NULL,
	`sellLastMonth` INT NOT NULL,
	`sellTwoMonthsAgo` INT NOT NULL,
	`sellThreeMonthsAgo` INT NOT NULL,
	PRIMARY KEY (`id`)
);

--<ScriptOptions statementTerminator=";"/>

DROP TABLE `Stocks`.`EarningsDate`;

CREATE TABLE `Stocks`.`EarningsDate` (
	`id` INT NOT NULL,
	`stockId` INT NOT NULL,
	`earningsDate` INT NOT NULL,
	`earningsReleaseTimeAbbrev` INT NOT NULL,
	PRIMARY KEY (`id`)
);

USE `Stocks`;
CREATE 
     OR REPLACE ALGORITHM = UNDEFINED 
    DEFINER = `root`@`localhost` 
    SQL SECURITY DEFINER
VIEW `stocksearningsdate` AS
    (SELECT 
        `a`.`symbol` AS `symbol`,
        `a`.`name` AS `name`,
        `c`.`meanRecommendationThisWeek` AS `meanRecommendationThisWeek`,
        `c`.`numberOfBrokers` AS `numberOfBrokers`,        
        `b`.`earningsDate` AS `earningsDate`,
        `b`.`earningsReleaseTimeEnum` AS `earningsReleaseTimeEnum`
    FROM
        ((`stock` `a`
        JOIN `earningsdate` `b`)
        JOIN `analystopinionyahoo` `c`)
    WHERE
        ((`a`.`id` = `b`.`stockId`)
            AND (`a`.`id` = `c`.`stockId`)));

CREATE TABLE `Stocks`.`QuoteYahoo` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `stockId` INT NOT NULL,
  `price` FLOAT NOT NULL,
  `previousClose` FLOAT NOT NULL,
  `open` FLOAT NOT NULL,
  `oneYearTarget` FLOAT NULL,
  `dayRangeLow` FLOAT NOT NULL,
  `dayRangeHigh` FLOAT NOT NULL,
  `fiftyTwoWeekRangeLow` FLOAT NOT NULL,
  `fiftyTwoWeekRangeHigh` FLOAT NOT NULL,
  `volume` INT NOT NULL,
  `threeMonthAverageVolume` INT NOT NULL,
  `marketCap` BIGINT NOT NULL,
  PRIMARY KEY (`id`));
