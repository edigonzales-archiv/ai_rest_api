# Cantons

## /cantons

| Method        | Action              | Status code  | Formats   | Default format |
| ------------- | ------------------- | ------------ | --------- | -------------- |
| GET           | List all cantons    | 200          | XML, JSON |                |
| POST          | Create a new canton | 201          | XML, JSON |                |
| PUT           |                     | 405          |           |                |
| DELETE        |                     | 405          |           |                |
| POST          | Create a new canton | 201          | XML, JSON |   


### List all cantons (XML output)
```
curl -v -XGET http://localhost:8080/aggregationsinfrastruktur/rest/cantons/
```

### List all cantons (JSON output)
```
curl -v -H "Accept: application/json" -XGET http://localhost:8080/aggregationsinfrastruktur/rest/cantons/
```

### Create a new canton
```
curl -v -H "Content-type: application/xml" -d "<canton><code>ZH</code></canton>" -XPOST http://localhost:8080/aggregationsinfrastruktur/rest/cantons/
```




fubar
