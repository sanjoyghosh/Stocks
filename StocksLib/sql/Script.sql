CREATE TABLE `Earnings`.`Stock` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`createdDate` INT NOT NULL,
	`name` VARCHAR(128) NOT NULL,
	`symbol` VARCHAR(48) NOT NULL,
	PRIMARY KEY (`id`)
);
CREATE UNIQUE INDEX `symbol_UNIQUE` ON `Earnings`.`Stock` (`symbol` ASC);

CREATE TABLE `Earnings`.`AnalystOpinionYahoo` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`createdDate` INT NOT NULL,
	`stockId` INT NOT NULL,
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

CREATE TABLE `Earnings`.`EarningsDate` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`createdDate` INT NOT NULL,	
	`stockId` INT NOT NULL,
	`earningsDate` INT NOT NULL,
	`earningsReleaseTimeEnum` INT NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Earnings`.`QuoteYahoo` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`createdDate` INT NOT NULL,	
	`stockId` INT NOT NULL,
	`price` FLOAT NOT NULL,
	`previousClose` FLOAT NULL,
	`open` FLOAT NULL,
	`oneYearTarget` FLOAT NULL,
	`dayRangeLow` FLOAT NULL,
	`dayRangeHigh` FLOAT NULL,
	`fiftyTwoWeekRangeLow` FLOAT NULL,
	`fiftyTwoWeekRangeHigh` FLOAT NULL,
	`volume` INT NULL,
	`threeMonthAverageVolume` INT NULL,
	`marketCap` BIGINT NULL,
	PRIMARY KEY (`id`)
);


USE `Earnings`;
CREATE 
     OR REPLACE ALGORITHM = UNDEFINED 
    DEFINER = `root`@`localhost` 
    SQL SECURITY DEFINER
VIEW `StocksEarningsDate` AS
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
