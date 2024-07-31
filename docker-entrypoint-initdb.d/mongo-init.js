db = db.getSiblingDB('shorter-url-db');
db.createUser(
  {
    user: 'user',
    pwd: 'password',
    roles: [{ role: 'readWrite', db: 'shorter-url-db' }],
  },
);
db.createCollection('users');