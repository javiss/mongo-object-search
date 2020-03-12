#! /bin/bash
echo "starting3"
mongoimport --jsonArray  -u "hal9000" -p "imafraidicantdothat" --authenticationDatabase "admin" --host mongo --db doodle --collection polls '/mongo-seed/init.json'
