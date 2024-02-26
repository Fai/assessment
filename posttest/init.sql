-- Drop tables if already exist
DROP TABLE IF EXISTS users CASCADE;
DROP TABLE IF EXISTS lotteries CASCADE;
DROP TABLE IF EXISTS user_ticket CASCADE;

-- Create tables
CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE lotteries (
    id SERIAL PRIMARY KEY,
    price INTEGER NOT NULL,
    amount INTEGER NOT NULL
);

CREATE TABLE user_ticket (
    id SERIAL PRIMARY KEY,
    user_id INT NOT NULL,
    lottery_id INT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (lottery_id) REFERENCES lotteries(id)
);

