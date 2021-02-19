# gitlog
A program that shows git logs to a rest api

## Config
* Config File Name: application.properties
```
workspace={PATH}
port=80
```
#### port
Web Port (default: 8080)

### API LIST
* /api/repos
* /api/branch?repo={REPO-NAME}
* /api/logs?repo={REPO-NAME}
