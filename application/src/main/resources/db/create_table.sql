CREATE TABLE IF NOT EXISTS companies (
    ID CHAR(36) NOT NULL,
    NAME VARCHAR(100) NOT NULL,
    SITE VARCHAR(100) NOT NULL,
    EMAIL VARCHAR(100) NOT NULL,
    DESCRIPTION VARCHAR(200) NULL,
    FOUNDATION  DATE NULL,
    SCORE CHAR(1) NULL,
    CREATED_AT DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    UPDATED_AT DATETIME NULL
)
