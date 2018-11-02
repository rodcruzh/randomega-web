-- postgres post randomega 01

CREATE TABLE blog_category (
    id_blog_category bigint	CONSTRAINT pk_blog_category PRIMARY KEY,
    name varchar(100) NOT NULL,
    description varchar(250),
    acronym varchar(20),
    active bool	NOT NULL
);

CREATE TABLE blog_entry (
    id_blog_entry bigint CONSTRAINT pk_blog_entry PRIMARY KEY,
    title varchar(100) NOT NULL,
    subtitle varchar(250),
    date_published timestamp NOT NULL,
    author varchar(100) NOT NULL,
    visits integer,
    image bytea,
    contents text NOT NULL,
    id_image varchar(100)
);

CREATE TABLE blog_category_entry (
    id_blog_category_entry bigint CONSTRAINT pk_blog_categ_entry PRIMARY KEY,
    id_blog_category bigint	NOT NULL,
    id_blog_entry bigint NOT NULL
);

ALTER TABLE blog_category_entry
ADD CONSTRAINT fk_blog_categ_entry_01 FOREIGN KEY (id_blog_category) REFERENCES blog_category (id_blog_category);
ALTER TABLE blog_category_entry
ADD CONSTRAINT fk_blog_categ_entry_02 FOREIGN KEY (id_blog_entry) REFERENCES blog_entry (id_blog_entry);
