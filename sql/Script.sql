--<ScriptOptions statementTerminator=";"/>

ALTER TABLE `Earnings`.`Stock` DROP PRIMARY KEY;

ALTER TABLE `Earnings`.`Stock` DROP INDEX `Earnings`.`symbol_UNIQUE`;

DROP TABLE `Earnings`.`Stock`;

CREATE TABLE `Earnings`.`Stock` (
	`id` INT NOT NULL,
	`name` VARCHAR(128) NOT NULL,
	`symbol` VARCHAR(48) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE UNIQUE INDEX `symbol_UNIQUE` ON `Earnings`.`Stock` (`symbol` ASC);



ALTER TABLE `Earnings`.`EarningsData` DROP PRIMARY KEY;

DROP TABLE `Earnings`.`EarningsData`;

CREATE TABLE `Earnings`.`EarningsData` (
	`id` INT NOT NULL,
	`stockId` INT NOT NULL,
	`earningsDate` DATE NOT NULL,
	`today` DATE NOT NULL,
	`price` FLOAT NOT NULL,
	`priceTarget` FLOAT NOT NULL,
	`price1YearLow` FLOAT NOT NULL,
	`price1YearHigh` FLOAT NOT NULL,
	`marketCap` INT NOT NULL,
	`yahooAnalystOpinionThisWeek` FLOAT NOT NULL,
	`yahooAnalystOpinionLastWeek` FLOAT NOT NULL,
	`yahooNumberAnalysts` INT NOT NULL,
	`yahooNumberAnalystsStrongBuy` INT NOT NULL,
	`yahooNumberAnalystsBuy` INT NOT NULL,
	`yahooNumberAnalystsHold` INT NOT NULL,
	`yahooNumberAnalystsUnderperform` INT NOT NULL,
	`yahooNumberAnalystsSell` INT NOT NULL,
	PRIMARY KEY (`id`)
);

ALTER TABLE `Earnings`.`EarningsData` ADD PRIMARY KEY (`id`);


