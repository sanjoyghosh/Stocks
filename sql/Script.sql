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



ALTER TABLE `Stocks`.`EarningsData` DROP PRIMARY KEY;

DROP TABLE `Stocks`.`EarningsData`;

CREATE TABLE `Stocks`.`EarningsData` (
	`id` INT NOT NULL,
	`stockId` INT NOT NULL,
	`EarningsDate` DATE NOT NULL,
	`today` DATE NOT NULL,
	`price` FLOAT NOT NULL,
	`yahooPriceTarget` FLOAT NOT NULL,
	`marketwatchPriceTarget` FLOAT NOT NULL,
	`price1YearLow` FLOAT NOT NULL,
	`price1YearHigh` FLOAT NOT NULL,
	`marketCap` INT NOT NULL,
	`yahooAnalystOpinionThisWeek` FLOAT NOT NULL,
	`yahooAnalystOpinionLastWeek` FLOAT NOT NULL,
	`marketwatchAnalystOpinion` FLOAT NOT NULL,
	`yahooNumberAnalysts` INT NOT NULL,
	`yahooNumberAnalystsStrongBuy` INT NOT NULL,
	`yahooNumberAnalystsBuy` INT NOT NULL,
	`yahooNumberAnalystsHold` INT NOT NULL,
	`yahooNumberAnalystsUnderperform` INT NOT NULL,
	`yahooNumberAnalystsSell` INT NOT NULL,
	`marketwatchNumberAnalysts` INT NOT NULL,
	`marketwatchNumberAnalystsStrongBuy` INT NOT NULL,
	`marketwatchNumberAnalystsBuy` INT NOT NULL,
	`marketwatchNumberAnalystsHold` INT NOT NULL,
	`marketwatchNumberAnalystsUnderperform` INT NOT NULL,
	`marketwatchNumberAnalystsSell` INT NOT NULL,
	PRIMARY KEY (`id`)
);


