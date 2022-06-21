from locust import HttpUser, task

class Recent(HttpUser):
    @task
    def median_of_500(self):
        _ = self.client.post(url="/api/recents")