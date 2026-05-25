-- Run in PostgreSQL (database: exeta) to add test users for Swagger.
-- Example: psql -U postgres -d exeta -f db/seed-users.sql
--
-- Password for both users: password123

INSERT INTO users (email, firstname, lastname, password, role)
VALUES (
    'demo@example.com',
    'Demo',
    'User',
    '$2b$10$j6xEdIN2X5Ciqppu0RByR.iWZmdE1bWGh9JmhA4CAZBYfrfGXYvzi',
    'USER'
)
ON CONFLICT (email) DO NOTHING;

INSERT INTO users (email, firstname, lastname, password, role)
VALUES (
    'admin@example.com',
    'Admin',
    'User',
    '$2b$10$j6xEdIN2X5Ciqppu0RByR.iWZmdE1bWGh9JmhA4CAZBYfrfGXYvzi',
    'ADMIN'
)
ON CONFLICT (email) DO NOTHING;
