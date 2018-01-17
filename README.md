# My project's README
```
# Login Curl Cmd
curl client:secret@localhost:8080/oauth/token -d grant_type=password -d username=user -d password=pwd
curl -vu barco:ballistic 'http://localhost:9191/api/oauth/token?username=nabeel.amd93@gmail.com&password=ballistic&grant_type=password'
# Refresh_token Curl Cmd
curl -vu barco:ballistic 'http://localhost:9191/api/oauth/token?grant_type=refresh_token&refresh_token=<refresh_token>'
# Logout Curl Cmd
curl -i -H "Authorization: Bearer <access_token>" http://localhost:9191/api/oauth/logout
# Access Secure Curl Cmd
curl -i -H "Authorization: Bearer <access_token>" http://localhost:9191/api/secure
curl -i X POST -H "Authorization: Bearer <access_token>" http://localhost:9191/api/qr-code/generate-qr
curl -i X GET -H "Authorization: Bearer <access_token>" http://localhost:9191/api/qr-code/decode-qr
# No Secure method access Curl Cmd           
curl -i -X POST  http://localhost:9191/api/oauth/register
curl -i -X GET  http://localhost:9191/api/oauth/lost/password
curl -i -X POST  http://localhost:9191/api/oauth/reset/password
curl -i -X POST  http://localhost:9191/api/oauth/activated
# Example of Creating Request Curl Cmd
curl -i -X GET http://rest-api.io/items
curl -i -X GET http://rest-api.io/items/5069b47aa892630aae059584
curl -i -X DELETE http://rest-api.io/items/5069b47aa892630aae059584
curl -i -X POST -H 'Content-Type: application/json' -d '{"name": "New item", "year": "2009"}' http://rest-api.io/items
curl -i -X PUT -H 'Content-Type: application/json' -d '{"name": "Updated item", "year": "2010"}' http://rest-api.io/items/5069b47aa892630aae059584
```
