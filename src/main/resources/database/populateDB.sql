INSERT INTO users (name, email, phone, password) VALUES
('Максим', 'm.krylov@asntl.ru', '+7 (977) 676-64-00', '$2a$10$eRySwooxOFVRVbmSxttd6OTkhthZKKvwoxk6NjqXfAsAB0DThW58m'),
('Ириша', 'waaaaah@yandex.ru', '+7 (977) 677-44-00', '$2a$10$eRySwooxOFVRVbmSxttd6OTkhthZKKvwoxk6NjqXfAsAB0DThW58m');

INSERT INTO tasks (name, description, producer) VALUES
('Test','ТЕстовая задача, которая записывается автоматически при создании базы(populateDB.sql)',1);