CREATE TABLE blogs (
                       id BIGSERIAL PRIMARY KEY,
                       title VARCHAR(100) NOT NULL,
                       content TEXT NOT NULL,
                       author_id BIGINT NOT NULL,
                       likes INTEGER NOT NULL DEFAULT 0,
                       created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                       updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

                       CONSTRAINT fk_blogs_author
                           FOREIGN KEY (author_id)
                               REFERENCES users(id)
                               ON DELETE CASCADE
);