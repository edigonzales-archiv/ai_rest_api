INSERT INTO ai_rest_api.canton (fosnr, code, aname, activated) VALUES
    (1, 'ZH', 'Zürich', FALSE),
    (2, 'BE', 'Bern', FALSE),
    (3, 'LU', 'Luzern', FALSE),
    (4, 'UR', 'Uri', FALSE),
    (5, 'SZ', 'Schwyz', FALSE),
    (6, 'OW', 'Obwalden', FALSE),
    (7, 'NW', 'Nidwalden', FALSE),
    (8, 'GL', 'Glarus', FALSE),
    (9, 'ZG', 'Zug', FALSE),
    (10, 'FR', 'Freiburg', FALSE),
    (11, 'SO', 'Solothurn', TRUE),
    (12, 'BS', 'Basel-Stadt', FALSE),
    (13, 'BL', 'Basel-Landschaft', FALSE),
    (14, 'SH', 'Schaffhausen', FALSE),
    (15, 'AR', 'Appenzell Ausserrhoden', FALSE),
    (16, 'AI', 'Appenzell Innerrhoden', FALSE),
    (17, 'SG', 'St. Gallen', FALSE),
    (18, 'GR', 'Graubünden', FALSE),
    (19, 'AG', 'Aargau', FALSE),
    (20, 'TG', 'Thurgau', FALSE),
    (21, 'TI', 'Tessin', FALSE),
    (22, 'VD', 'Waadt', FALSE),
    (23, 'VS', 'Wallis', FALSE),
    (24, 'NE', 'Neuenburg', FALSE),
    (25, 'GE', 'Genf', FALSE),
    (26, 'JU', 'Jura', FALSE),
    (27, 'LI', 'Liechtenstein', FALSE);


UPDATE ai_rest_api.canton SET activated = FALSE
WHERE code = 'ZH';
