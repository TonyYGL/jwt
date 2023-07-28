INSERT INTO t_user (id, username, password, is_del) VALUES (1, 'tony', 'tony123', 0);


INSERT INTO t_setting (id, setting_key, setting_value, is_del) VALUES (1, 'jwtSalt', 'kqjdoiajdkqpsialpdlwoaicnklspqpwmskakkqjdoiajdkqpsialpdlwoaicnklspqpwmskak', 0);
INSERT INTO t_setting (id, setting_key, setting_value, is_del) VALUES (2, 'jwtExpirationTime', '3600000', 0); --jwt token一小時過期