ALTER TABLE users ADD COLUMN lastname VARCHAR(50) NOT NULL default 'UNKNOWN';
ALTER TABLE users RENAME COLUMN username TO firstname;