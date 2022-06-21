from locust import HttpUser, task
import random

ran = random.randint(1,100)
class Id(HttpUser):
    @task
    def median_of_500(self):
        _ = self.client.get(f"/api/{ran}")