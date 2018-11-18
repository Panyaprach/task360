# TASK360
The TASK360 is the RESTful API use to store the resources for a simple 'to do' task list. This project depends on the following stack,
+ Spring Boot
+ MySQL
+ Docker (Docker-Compose)

All requests available on `localhost:8080`. All API access is over `http`. All data received as `json`.

This guide walks you build the docker image for running a Spring Boot Application. This may take a long time depends on your internet connection.

### Table of Contents
**[Preparing Environment](#preparing-environment)**<br>
**[Getting Started](#getting-started)**<br>
**[Endpoints](#endpoints)**<br>
**[Sample Model](#sample-model)**<br>

#### Preparing Environment
You will also need [Docker](https://www.docker.com/). 
See https://docs.docker.com/installation/#installation for details on setting Docker up for your machine. 
Before proceeding further, verify you can run `docker-compose` commands from the shell.

#### Getting Started
First, clone this repository to your machine.
```bash
git clone https://github.com/Panyaprach/task360.git
```
Second, change into project directory.
```bash
cd task360
```
Finally, run the project with docker-compose.
```bash
docker-compose up
```
Then, go check your application is available on http://localhost:8080/
> **Note:** Don't worry if you found error occurring in Spring Boot Application. You just need to wait until MySQL container available. The container will refresh itself. 

#### Endpoints

METHOD | PATH | DESCRIPTION | POSSIBLE RESPONSE
--- | --- | --- | ---
*GET* | tasks | view all tasks | `200` when success
*GET* | tasks/{id} | find a single task by id | `200` when success, `400` when failed
*POST* | tasks | create a new task | `201` when success, `400` when failed
*PUT* | tasks/{id} | edit a task | `204` when success, `400` when failed
*PATCH* | tasks/{id}/status | change a task status | `204` when success, `400` when failed
*DELETE* | tasks/{id} | delete a task by id | `204` when success, `400` when failed

Because of the task status had only two status, So the `PATCH` request for set a task status does not need a request body.

#### Sample Model
This is the sample json model when you need to use `POST` or `PUT` request. example below,
```json
{
  "id" : 1,
  "subject" : "required",
  "detail" : "the status string accept only 2 case sensitive values are `PENDING` and `DONE`",
  "status" : "DONE"
}
```
+ `id` : number (can contain long type)
+ `subject` : string (required can not be null)
+ `detail` : string
+ `status` : string (accept only 2 case sensitive string are `PENDING` and `DONE`)
