CREATE DATABASE IF NOT EXISTS post_management;
USE post_management;

CREATE TABLE Users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role ENUM('admin','editor','user') DEFAULT 'user',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE Languages (
    id INT AUTO_INCREMENT PRIMARY KEY,
    code VARCHAR(10) UNIQUE, -- en, vi, ja
    name VARCHAR(50)
);

CREATE TABLE Categories (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE Posts (
    id INT AUTO_INCREMENT PRIMARY KEY,
    author_id INT,
    category_id INT,
    status ENUM('draft','published') DEFAULT 'draft',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

    FOREIGN KEY (author_id) REFERENCES Users(id) ON DELETE CASCADE,
    FOREIGN KEY (category_id) REFERENCES Categories(id) ON DELETE SET NULL
);

CREATE TABLE Post_Translations (
    id INT AUTO_INCREMENT PRIMARY KEY,
    post_id INT,
    language_id INT,
    title VARCHAR(255),
    content TEXT,

    UNIQUE(post_id, language_id),

    FOREIGN KEY (post_id) REFERENCES Posts(id) ON DELETE CASCADE,
    FOREIGN KEY (language_id) REFERENCES Languages(id)
);

CREATE TABLE Tags (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) UNIQUE
);

CREATE TABLE Post_Tags (
    post_id INT,
    tag_id INT,
    PRIMARY KEY (post_id, tag_id),

    FOREIGN KEY (post_id) REFERENCES Posts(id) ON DELETE CASCADE,
    FOREIGN KEY (tag_id) REFERENCES Tags(id) ON DELETE CASCADE
);

CREATE TABLE Comments (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    post_id INT,
    content TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    FOREIGN KEY (user_id) REFERENCES Users(id) ON DELETE CASCADE,
    FOREIGN KEY (post_id) REFERENCES Posts(id) ON DELETE CASCADE
);

CREATE TABLE AI_Logs (
    id INT AUTO_INCREMENT PRIMARY KEY,
    post_id INT,
    action_type ENUM('translate','summarize','generate'),
    input_text TEXT,
    output_text TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    FOREIGN KEY (post_id) REFERENCES Posts(id) ON DELETE CASCADE
);

-- Users
INSERT INTO Users (username, email, password, role) VALUES
('admin','admin@gmail.com','123456','admin'),
('user1', 'user1@gmail.com', '123456', 'user');

-- Languages
INSERT INTO Languages (code, name) VALUES
('vi','Vietnamese'),
('en','English');

-- Categories
INSERT INTO Categories (name) VALUES
('Technology'),
('AI');

-- Posts
INSERT INTO Posts (author_id, category_id, status) VALUES
(1,1,'published'),
(2,2,'published');

-- Translations
INSERT INTO Post_Translations (post_id, language_id, title, content) VALUES
(1,1,'Học Java','Nội dung Java'),
(1,2,'Learn Java','Java content'),
(2,1,'AI tương lai','AI đang phát triển'),
(2,2,'AI Future','AI is growing');

-- Tags
INSERT INTO Tags (name) VALUES ('Java'), ('AI');

-- Mapping
INSERT INTO Post_Tags VALUES (1,1),(2,2);

SELECT p.id, pt.title, l.code
FROM Posts p
JOIN Post_Translations pt ON p.id = pt.post_id
JOIN Languages l ON pt.language_id = l.id;

SELECT pt.title, pt.content
FROM Post_Translations pt
JOIN Languages l ON pt.language_id = l.id
WHERE l.code = 'en';

SELECT pt.title, u.username, c.name AS category
FROM Posts p
JOIN Users u ON p.author_id = u.id
JOIN Categories c ON p.category_id = c.id
JOIN Post_Translations pt ON p.id = pt.post_id
JOIN Languages l ON pt.language_id = l.id
WHERE l.code = 'vi';

SELECT u.username, COUNT(p.id) total_posts
FROM Users u
LEFT JOIN Posts p ON u.id = p.author_id
GROUP BY u.username;

SELECT pt.title
FROM Posts p
JOIN Post_Tags ptg ON p.id = ptg.post_id
JOIN Tags t ON ptg.tag_id = t.id
JOIN Post_Translations pt ON p.id = pt.post_id
WHERE t.name = 'AI';

SELECT pt.title
FROM Posts p
JOIN Post_Translations pt ON p.id = pt.post_id
JOIN Languages l ON pt.language_id = l.id
WHERE l.code = 'en'
ORDER BY p.created_at DESC
LIMIT 1;