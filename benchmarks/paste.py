import json
from locust import HttpUser, task

class Paste(HttpUser):

    @task
    def median_of_500(self):
        payload = {
            'title': 'hi',
            'content': 'hello'
        }
        headers = {'content-type': 'application/json'}
        response = self.client.post("/api/paste", data=json.dumps(payload), headers=headers)

