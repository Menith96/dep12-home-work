CREATE TABLE customer (
                          id VARCHAR(15) PRIMARY KEY,
                          name VARCHAR(100) NOT NULL,
                          address VARCHAR(500) NOT NULL
);

CREATE TABLE customer_contact (
                                  customer_id VARCHAR(15),
                                  contact VARCHAR(500),
                                  PRIMARY KEY (contact),
                                  FOREIGN KEY (customer_id) REFERENCES customer(id)
);
CREATE TABLE user (
                      username VARCHAR(100) PRIMARY KEY,
                      name VARCHAR(200) NOT NULL,
                      password VARCHAR(200) NOT NULL
);
CREATE TABLE `order` (
                       id VARCHAR(15) PRIMARY KEY,
                       customer_id VARCHAR(15),
                       date DATE NOT NULL,
                       username VARCHAR(100),
                       CONSTRAINT fk_customer FOREIGN KEY (customer_id) REFERENCES customer(id),
                       CONSTRAINT fk_user FOREIGN KEY (username) REFERENCES user(username)
);
CREATE TABLE item (
                      code VARCHAR(50) PRIMARY KEY,
                      price DECIMAL(10,2) NOT NULL,
                      name VARCHAR(255) NOT NULL,
                      stock INT
);
CREATE TABLE order_details (
                               order_id VARCHAR(15),
                               item_code VARCHAR(50),
                               discount INT NOT NULL,
                               price DECIMAL(10,2) NOT NULL,
                               CONSTRAINT pk_order_details PRIMARY KEY (order_id, item_code),
                               CONSTRAINT fk_order FOREIGN KEY (order_id) REFERENCES `order`(id),
                               CONSTRAINT fk_item FOREIGN KEY (item_code) REFERENCES item(code)
);
