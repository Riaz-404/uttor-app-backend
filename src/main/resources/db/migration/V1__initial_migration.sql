CREATE TABLE question
(
    id            UUID         NOT NULL,
    created_at    TIMESTAMP WITHOUT TIME ZONE,
    updated_at    TIMESTAMP WITHOUT TIME ZONE,
    deleted_at    TIMESTAMP WITHOUT TIME ZONE,
    title         VARCHAR(255) NOT NULL,
    body          VARCHAR(255),
    question_user UUID,
    CONSTRAINT pk_question PRIMARY KEY (id)
);

CREATE TABLE question_topic
(
    question_id UUID NOT NULL,
    topic_id    UUID NOT NULL
);

CREATE TABLE topic
(
    id         UUID         NOT NULL,
    created_at TIMESTAMP WITHOUT TIME ZONE,
    updated_at TIMESTAMP WITHOUT TIME ZONE,
    deleted_at TIMESTAMP WITHOUT TIME ZONE,
    name       VARCHAR(255) NOT NULL,
    CONSTRAINT pk_topic PRIMARY KEY (id)
);

CREATE TABLE users
(
    id         UUID NOT NULL,
    created_at TIMESTAMP WITHOUT TIME ZONE,
    updated_at TIMESTAMP WITHOUT TIME ZONE,
    deleted_at TIMESTAMP WITHOUT TIME ZONE,
    username   VARCHAR(255),
    email      VARCHAR(255),
    bio        VARCHAR(255),
    CONSTRAINT pk_users PRIMARY KEY (id)
);

ALTER TABLE question
    ADD CONSTRAINT FK_QUESTION_ON_QUESTION_USER FOREIGN KEY (question_user) REFERENCES users (id);

ALTER TABLE question_topic
    ADD CONSTRAINT fk_quetop_on_question FOREIGN KEY (question_id) REFERENCES question (id);

ALTER TABLE question_topic
    ADD CONSTRAINT fk_quetop_on_topic FOREIGN KEY (topic_id) REFERENCES topic (id);