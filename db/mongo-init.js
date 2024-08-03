db.createUser({
    user: process.env.MONGO_USER,
    pwd: process.env.MONGO_PASSWORD,
    roles: [
        {
            role: 'readWrite',
            db: process.env.MONGO_INITDB_DATABASE,
        },
    ],
});

db = new Mongo().getDB(process.env.MONGO_INITDB_DATABASE);

db.createCollection('test', { capped: false });
db.test.insert([
    { "item": 1 },
    { "item": 2 },
    { "item": 3 },
    { "item": 4 },
    { "item": 5 }
]);