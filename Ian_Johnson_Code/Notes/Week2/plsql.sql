-- Let's make a new table describing basketball players.

CREATE TABLE player (
    player_id NUMBER(10) PRIMARY KEY,
    name VARCHAR2(200) NOT NULL,
    attempts NUMBER(10) NOT NULL, -- The number of attempts made.
    made NUMBER(10) NOT NULL, -- The number of successful shots.
    shooting_percentage NUMBER(10) NOT NULL -- This is not a good column (it's a functional dependency), but we'll use it for an example.
);

INSERT INTO player VALUES(0, 'Mean Mike', 1000, 300, 30);
INSERT INTO player VALUES(1, 'Steph Curry', 10000, 9000, 90);
INSERT INTO player VALUES(2, 'Dunking Adams', 100, 99, 99);

-- Let's write a function that will calculate the shooting percentage for us.
CREATE OR REPLACE FUNCTION calc_shoot_avg(att NUMBER, made NUMBER) RETURN NUMBER IS percentage NUMBER(10);
BEGIN
    percentage := made / att * 100;
    RETURN percentage;
END;
/

INSERT INTO player VALUES(3, 'Bugs Bunny', 8742, 5637, 99); -- The percentage is wrong!
-- So let's update the percentage:
UPDATE player
SET shooting_percentage = calc_shoot_avg(player.attempts, player.made)
WHERE player.player_id = 3;

-- If we want to be able to insert players more easily, let's do some more stuff:
CREATE SEQUENCE seq_player_id MINVALUE 0 START WITH 4 INCREMENT BY 1;

CREATE OR REPLACE PROCEDURE insert_player(name VARCHAR2, attempts NUMBER, made NUMBER) IS -- Could also be AS.
BEGIN
    INSERT INTO player VALUES (
        seq_player_id.NEXTVAL,
        name,
        attempts,
        made,
        calc_shoot_avg(attempts, made)
    );
END;
/

EXEC insert_player('Kobe', 1999, 400);

SELECT * FROM player;