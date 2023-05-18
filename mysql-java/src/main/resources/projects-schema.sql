DROP TABLE IF EXISTS material;
DROP TABLE IF EXISTS step;
DROP TABLE IF EXISTS project_category;
DROP TABLE IF EXISTS category;
DROP TABLE IF EXISTS project;

CREATE TABLE project (
	project_id INT AUTO_INCREMENT NOT NULL,
	project_name VARCHAR(128) NOT NULL,
	estimated_hours DECIMAL(7,2),
	actual_hours DECIMAL(7,2),
	difficulty INT,
	notes TEXT,
	PRIMARY KEY (project_id)
);

CREATE TABLE category (
	category_id INT AUTO_INCREMENT NOT NULL,
	category_name VARCHAR(128) NOT NULL,
	PRIMARY KEY (category_id)
);

CREATE TABLE project_category (
	project_id INT NOT NULL,
	category_id INT NOT NULL,
	FOREIGN KEY (project_id) REFERENCES project (project_id) ON DELETE CASCADE,
	FOREIGN KEY (category_id) REFERENCES category (category_id) ON DELETE CASCADE,
	UNIQUE KEY (project_id, category_id)
);

CREATE TABLE step (
	step_id INT AUTO_INCREMENT NOT NULL,
	project_id INT NOT NULL,
	step_text TEXT NOT NULL,
	step_order INT NOT NULL,
	PRIMARY KEY (step_id),
	FOREIGN KEY (project_id) REFERENCES project (project_id) ON DELETE CASCADE
);

CREATE TABLE material (
	material_id INT AUTO_INCREMENT NOT NULL,
	project_id INT NOT NULL,
	material_name VARCHAR(128) NOT NULL,
	num_required INT,
	cost DECIMAL(7,2),
	PRIMARY KEY (material_id),
	FOREIGN KEY (project_id) REFERENCES project (project_id) ON DELETE CASCADE
);

INSERT INTO project (project_name, estimated_hours, actual_hours, difficulty, notes) VALUES ('Hang a door', 4.5, 3.5, 4, 'use door hangers from Home Depot');
INSERT INTO material (project_id, material_name, num_required, cost) VALUES (1, 'door hangers', 2, 3.75);
INSERT INTO material (project_id, material_name, num_required, cost) VALUES (1, 'screws', 20, 4.75);
INSERT INTO step (project_id, step_text, step_order) VALUES (1, 'Align hangers on opening side of door', 1);
INSERT INTO step (project_id, step_text, step_order) VALUES (1, 'Screw hangers into frame', 2);
INSERT INTO category (category_id, category_name) VALUES (1, 'Doors & Windows');
INSERT INTO category (category_id, category_name) VALUES (2, 'Repairs');
INSERT INTO category (category_id, category_name) VALUES (3, 'Gardening');
INSERT INTO project_category (project_id, category_id) VALUES (1, 1);
INSERT INTO project_category (project_id, category_id) VALUES (1, 2);

INSERT INTO project (project_name, estimated_hours, actual_hours, difficulty, notes) VALUES ('Change car oil', 4.5, 3.5, 4, 'make sure to buy correct amount/type of oil');
INSERT INTO material (project_id, material_name, num_required, cost) VALUES (2, 'synthetic oil', 1, 30.25);
INSERT INTO step (project_id, step_text, step_order) VALUES (2, 'drain old oil into container', 1);
INSERT INTO step (project_id, step_text, step_order) VALUES (2, 'replace oil drain plug', 2);
INSERT INTO step (project_id, step_text, step_order) VALUES (2, 'add new oil in engine', 3);
INSERT INTO category (category_id, category_name) VALUES (4, 'Auto');
INSERT INTO project_category (project_id, category_id) VALUES (2, 2);
INSERT INTO project_category (project_id, category_id) VALUES (2, 4);
