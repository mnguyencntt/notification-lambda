
-- Person --
DROP TABLE `Person`;
CREATE TABLE `Person` (
  `id` VARCHAR(255) NOT NULL,

  `firstName` VARCHAR(255) NULL,
  `lastName` VARCHAR(2555) NULL,
  `address` VARCHAR(2555) NULL,
  `city` VARCHAR(2555) NULL,
  PRIMARY KEY (`id`));

INSERT INTO `Person` (id, firstName, lastName, address, city)
VALUES  ('1', 'Minh', 'Nguyen', '140145', 'Singapore');
INSERT INTO `Person` (id, firstName, lastName, address, city)
VALUES  ('2', 'Minh', 'Nguyen', '140145', 'Singapore');

SELECT * FROM `Person`;


-- Person --
DROP TABLE `Notification`;
CREATE TABLE `Notification` (
  `id` VARCHAR(255) NOT NULL,

  `receiverUserId` VARCHAR(255) NULL,
  `subject` VARCHAR(255) NULL,
  `contentBody` VARCHAR(1000) NULL,
  `notificationType` VARCHAR(255) NULL,
  `amount` VARCHAR(255) NULL,
  `status` VARCHAR(255) NULL,
  `message` VARCHAR(255) NULL,
  `request` VARCHAR(1000) NULL,

  `createdAt` VARCHAR(255) NULL,
  `createdBy` VARCHAR(255) NULL,
  `updatedAt` VARCHAR(255) NULL,
  `updatedBy` VARCHAR(255) NULL,
  PRIMARY KEY (`id`));

INSERT INTO `Notification` (id, receiverUserId, subject, contentBody, notificationType, amount, status, message, request, createdAt, createdBy, updatedAt, updatedBy)
VALUES  ('1', 'UIB12345', 'Notification OrderId OID12345', 'Minh Nguyen Testing Content Body', 'EMAIL', '1', '000', 'Sent Success', '', '', '', '', '');
INSERT INTO `Notification` (id, receiverUserId, subject, contentBody, notificationType, amount, status, message, request, createdAt, createdBy, updatedAt, updatedBy)
VALUES  ('2', 'UIB12345', 'Notification OrderId OID12345', 'Minh Nguyen Testing Content Body', 'EMAIL', '1', '000', 'Sent Success', '', '', '', '', '');

SELECT * FROM `Notification`;
