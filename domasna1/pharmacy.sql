CREATE TABLE Pharmacy (
    ID INTEGER AUTO_INCREMENT NOT NULL,
    Name VARCHAR (255) NOT NULL,
    Lat DECIMAL (9, 6) NOT NULL,
    Lon DECIMAL (9, 6) NOT NULL,
    Settlement VARCHAR (255),
    Municipality VARCHAR (255),
    City VARCHAR (255) DEFAULT 'Skopje',
    PostalCode INTEGER DEFAULT 1000,
    Country VARCHAR (255) DEFAULT 'Macedonia'
    PRIMARY KEY (ID)
)