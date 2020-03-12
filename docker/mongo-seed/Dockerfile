FROM mongo

COPY initw.json /init.json
CMD mongoimport --db local --collection polls --type json --file /init.json --jsonArray
