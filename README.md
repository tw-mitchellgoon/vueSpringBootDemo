# To Do List - Vue/SpringBoot full stack demo

Simple To Do list, try it [here!](https://vuespring-todo.netlify.app/)

### Tech Stack

- Frontend: VueJS
- Backend: Spring Boot, JPA
- Deployed to: Netlify (Frontend), Heroku (Backend)

## Frontend - Vue.JS

[Frontend App URL](https://vuespring-todo.netlify.app/)

To run it locally:
```
cd vue-frontend
yarn install
npm run serve
```

## Backend - SpringBoot

Backend API endpoint - https://vue-springboot-backend.herokuapp.com/api

Append the following to API endpoint for the following requests:

- **/todolist** - Fetch all to do items (GET)
- **/todoadd** - Add a new to do item to list (POST)

To run it locally:
Compile JAR via Maven in IDE, then to run backend:

```
cd spring-backend/target
java -jar (JAR file here)
```
