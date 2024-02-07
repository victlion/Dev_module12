INSERT INTO Client (name) VALUES
    ('Client1'),
    ('Client2'),
    ('Client3'),
    ('Client4'),
    ('Client5'),
    ('Client6'),
    ('Client7'),
    ('Client8'),
    ('Client9'),
    ('Client10');

-- Вставка данных для таблицы Planet
INSERT INTO Planet (id, name) VALUES
    ('MARS', 'Mars'),
    ('VEN', 'Venus'),
    ('JUP', 'Jupiter'),
    ('SAT', 'Saturn'),
    ('EAR', 'Earth');

-- Вставка данных для таблицы Ticket
-- Предположим, что client_id, from_planet_id, и to_planet_id связаны с уже существующими данными в таблицах Client и Planet
INSERT INTO Ticket (created_at, client_id, from_planet_id, to_planet_id) VALUES
    ('2024-02-05 12:00:00', 1, 'MARS', 'VEN'),
    ('2024-02-06 14:30:00', 2, 'JUP', 'SAT'),
    ('2024-02-07 10:45:00', 3, 'VEN', 'MARS'),
    ('2024-02-08 18:20:00', 4, 'SAT', 'JUP'),
    ('2024-02-09 08:15:00', 5, 'MARS', 'JUP'),
    ('2024-02-10 16:30:00', 6, 'JUP', 'VEN'),
    ('2024-02-11 09:00:00', 7, 'VEN', 'JUP'),
    ('2024-02-12 20:45:00', 8, 'SAT', 'MARS'),
    ('2024-02-13 11:30:00', 9, 'MARS', 'SAT'),
    ('2024-02-14 14:00:00', 10, 'EAR', 'JUP');