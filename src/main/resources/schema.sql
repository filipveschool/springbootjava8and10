CREATE TABLE if not exists Students (
  id         INTEGER IDENTITY PRIMARY KEY,
  name       VARCHAR(64) NOT NULL,
  gender     character   not null,
  percentage float       NOT NULL,
  primary key (id)
);

CREATE TABLE if not exists Teachers (
  id               INTEGER IDENTITY PRIMARY KEY,
  name             VARCHAR(64)  NOT NULL,
  gender           character    not null,
  isActive         boolean default true,
  additionalSkills varchar(255),
  primary key (id)
);