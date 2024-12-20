INSERT INTO roles (name) VALUES ('ROLE_ADMIN'), ('ROLE_GUEST');

INSERT INTO users(email, name, password) VALUES ('admin','admin','$2a$10$k9644mshajjDvMhU8p76.u4sgOFuINZDkZ/csNgzFY99W1diZjBuC'); 

INSERT INTO user_roles(user_id, role_id) values(1, 1);

INSERT INTO posts (content, created_on, short_description, title, updated_on, url, created_by) 
VALUES 
('Content Goes Here', '2024-12-11', 'An overview of Java variables and their types.', 'Java Variables', '2024-12-11', 'java-variables', 1),
('Content Goes Here', '2024-12-11', 'Introduction to the basics of Spring Boot.', 'Spring Boot Basics', '2024-12-11', 'spring-boot-basics', 1),
('Content Goes Here', '2024-12-11', 'Understanding RESTful APIs and their usage.', 'RESTful APIs', '2024-12-11', 'restful-apis', 1),
('Content Goes Here', '2024-12-11', 'A guide to using Hibernate ORM for database operations.', 'Hibernate ORM', '2024-12-11', 'hibernate-orm', 1),
('Content Goes Here', '2024-12-11', 'Creating dynamic web pages with Thymeleaf templates.', 'Thymeleaf Templates', '2024-12-11', 'thymeleaf-templates', 1);
