CREATE TABLE Student (
  id         INTEGER IDENTITY PRIMARY KEY,
  name       VARCHAR(64) NOT NULL,
  gender     character default true,
  percentage float       NOT NULL
);