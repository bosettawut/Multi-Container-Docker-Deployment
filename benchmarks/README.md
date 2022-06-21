# instructions on how to run the benchmark

pip install locust <br />
locust -H {url} -f {python file} -u {number of users} -r {spawn rate} {Class of that python file}

### /api/paste
locust -H http://localhost -f paste.py -u 100 -r 10 Paste

### /api/1
locust -H http://localhost -f id.py -u 100 -r 10 Id

### /api/recents
locust -H http://localhost -f recent.py -u 100 -r 10 Recent
