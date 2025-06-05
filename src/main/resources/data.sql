INSERT into users(username,password,enabled)VALUES
('admin','$2a$10$e0MYzXyjpJS7Pd0RVvHwHeOX5Bl1UMQ9UsZsNveJRULB/tFMWwJta',true);

INSERT into authorities(username,authority)VALUES
('admin','ROLE_ADMIN');
