CREATE DATABASE IF NOT EXISTS post_management;
USE post_management;

CREATE TABLE Users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(20) DEFAULT 'user',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE Categories (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL UNIQUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE Posts (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    content TEXT NOT NULL,
    author_id INT,
    category_id INT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_author
        FOREIGN KEY (author_id)
        REFERENCES Users(id)
        ON DELETE CASCADE,

    CONSTRAINT fk_category
        FOREIGN KEY (category_id)
        REFERENCES Categories(id)
        ON DELETE SET NULL
);

INSERT INTO Users (username, email, password, role)
VALUES 
('admin', 'admin@gmail.com', '123456', 'admin'),
('user1', 'user1@gmail.com', '123456', 'user');

INSERT INTO Categories (name)
VALUES 
('Technology'),
('Education'),
('AI');

INSERT INTO Posts (title, content, author_id, category_id)
VALUES 
('Learn Java OOP', 'This is a post about Java OOP', 1, 1),
('SQL Basics', 'This is a post about SQL', 2, 2),
('AI in 2026', 'AI is growing rapidly', 1, 3);

SELECT p.id, p.title, u.username, c.name AS category
FROM Posts p
JOIN Users u ON p.author_id = u.id
LEFT JOIN Categories c ON p.category_id = c.id;

SELECT * FROM Posts
WHERE author_id = 1;

UPDATE Posts
SET content = 'Updated content for Java OOP'
WHERE id = 1;

DELETE FROM Posts
WHERE id = 3;
