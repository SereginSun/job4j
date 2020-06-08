CREATE TABLE users (
	id SERIAL PRIMARY KEY,
	name VARCHAR(30)
);

CREATE TABLE meetings (
	id SERIAL PRIMARY KEY,
	name VARCHAR(100)
);

CREATE TABLE users_meetings (
	id_user INT REFERENCES users(id),
	id_meeting INT REFERENCES meetings(id),
	status varchar(7) CONSTRAINT status_options CHECK (status IN ('confirm', 'cancel')),
	PRIMARY KEY(id_user, id_meeting)
);

INSERT INTO users (name) VALUES ('Charles'), ('Bryan'), ('Peter'), ('Christopher'), ('Oliver');

INSERT INTO meetings (name) VALUES ('quarterly meeting'), ('technical meeting'), ('unscheduled meeting');

INSERT INTO users_meetings (id_user, id_meeting, status)
VALUES (1, 1, 'confirm'), (2, 1, 'cancel'), (3, 1, 'cancel'), (4, 1, 'confirm'), (5, 1, 'confirm'),
(1, 2, 'cancel'), (2, 2, 'confirm'), (3, 2, 'confirm'), (4, 2, 'cancel'), (5, 2, 'cancel');

--Write a request that will receive a list of all meetings and the amount of confirmed participants.
SELECT m.name, count(u_m.status)
FROM meetings AS m
JOIN users_meetings AS u_m ON m.id = u_m.id_meeting
WHERE u_m.status = 'confirm'
GROUP BY m.name;

--Write a request that will receive a list of all meetings where there was not a single confirming participant.
SELECT m.name
FROM meetings AS m
WHERE (
	SELECT count (*) FROM users_meetings
	WHERE id_meeting = m.id AND status = 'confirm'
	) = 0;