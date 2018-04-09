USE omelete_db;

INSERT INTO Users(username,email,password)
    VALUES ("user1", "user1@gmail.com", "pass"),
      ("user2", "user2@gmail.com", "pass"),
      ("user3", "user3@gmail.com", "pass");

INSERT INTO Rest_Pro(user_id, name, logo, location, phone_number, description)
    VALUES(1,"Mortons","image for logo", "2222 NW pkwy, San Antonio TX 78261","555-5555", "A famous classic steakhouse"),
      (2,"Cru", "image for logo", "300 Navarro St., San Antonio TX 78992", "666-6666", "Cru is the shit, give it a try"),
      (3,"HopDoddy", "image for logo", "500 w 6th st, San Antonio TX 78901","777-7777", "Hop to it");

INSERT INTO Jobs(rest_id, title, description)
    VALUES(1, "Dishwasher", "Washin dishes yo"),
      (1,"Sous Chef", "Kitchen Bitch"),
      (2,"Server", "Servin it up"),
      (3,"Line Cook", "Flippin burgers");

INSERT INTO Categories(type)
    VALUES("Bar"),("Steakhouse"),("Grill"),("Brazilian"),("American"),("Ethnic");

INSERT INTO Rest_Cat(rest_id, cat_id)
    VALUES(1,2),(1,3),(1,4),(2,1),(2,3),(2,4),(2,6),(3,2);
