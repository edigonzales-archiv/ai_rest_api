INSERT INTO ai_rest_api.canton (fosnr, code, aname, activated) VALUES
    (1, 'ZH', 'Zürich', FALSE),
    (8, 'GL', 'Glarus', TRUE),
    (11, 'SO', 'Solothurn', TRUE);



UPDATE ai_rest_api.canton SET activated = FALSE
WHERE code = 'ZH';
