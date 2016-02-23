CREATE TABLE users (
  id INTEGER PRIMARY KEY,
  name VARCHAR(30),
  email  VARCHAR(50)
);

CREATE TABLE events (
  name VARCHAR(30) PRIMARY KEY ,
  rating VARCHAR(10),
  eventDate DATE,
  auditorium VARCHAR(30)
);

CREATE TABLE auditoriums (
name VARCHAR(30) PRIMARY KEY,
vipSeats VARCHAR(30),
seatNumber INTEGER
);

CREATE TABLE counters (
name VARCHAR(30),
count INTEGER
);