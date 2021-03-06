CREATE TABLE `user_loan_plan_material`
(
    `id`         int(11) NOT NULL AUTO_INCREMENT,
    `name`       varchar(100) NOT NULL,
    `lender_age` int(11) NOT NULL,
    `id_card`    varchar(100) NOT NULL,
    `gender`     varchar(20)  NOT NULL,
    `income`     decimal      NOT NULL,
    `created_at` DATETIME     NOT NULL,
    `updated_at` DATETIME     NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `house_material`
(
    `id`                    int(11) NOT NULL AUTO_INCREMENT,
    `house_age`             int(11) NOT NULL,
    `loan_plan_material_id` int(11) NULL,
    `house_price`           decimal NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `together_lender`
(
    `id`                      int(11) NOT NULL AUTO_INCREMENT,
    `together_lender_name`    varchar(100) NOT NULL,
    `together_lender_id_card` varchar(100) NOT NULL,
    `loan_plan_material_id`   int(11) NULL,
    `together_lender_income`  decimal      NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4
