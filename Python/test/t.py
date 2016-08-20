from celery import Celery

app = Celery(backend='amqp',broker='amqp://')

@app.task
def add(x,y):
	return x+y