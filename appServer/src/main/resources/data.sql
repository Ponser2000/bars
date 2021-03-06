DELETE
FROM contracts;
ALTER SEQUENCE GLOBAL_SEQ RESTART WITH 100000;

INSERT INTO contracts (date_create, revision, date_update)
VALUES ('2020-01-30 10:00:00', 0, '2020-01-30 10:00:00'),
       ('2020-01-30 13:00:00', 2, '2020-02-15 09:00:00'),
       ('2020-01-30 20:00:00', 10, '2020-11-30 20:00:00'),
       ('2020-01-31 09:00:00', 10, '2020-12-14 08:00:00'),
       ('2020-01-31 10:00:00', 3, '2020-06-21 10:00:00'),
       ('2020-01-31 13:00:00', 2, '2020-02-23 13:00:00'),
       ('2020-01-31 20:00:00', 8, '2020-10-15 17:00:00'),
       ('2020-01-31 14:00:00', 1, '2020-02-10 14:00:00'),
       ('2020-01-31 21:00:00', 0, '2020-01-31 21:00:00'),
       ('2021-01-31 11:00:00', 5, '2021-11-30 12:00:00'),
       ('2021-02-12 10:00:00', 2, '2021-05-31 08:00:00'),
       ('2021-05-23 13:00:00', 4, '2021-08-11 12:00:00'),
       ('2021-06-24 08:00:00', 3, '2021-08-30 17:00:00'),
       ('2021-11-21 14:30:00', 1, '2021-11-22 10:00:00'),
       ('2021-12-03 15:35:00', 0, '2021-12-03 15:35:00'),
       ('2021-12-01 12:00:00', 0, '2021-12-01 12:00:00');