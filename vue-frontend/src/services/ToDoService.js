import axios from "axios";

const TODO_API_BASE_URL =
  "https://vue-springboot-backend.herokuapp.com/api/";
// "http://localhost:8081/api/";

class ToDoService {
  getToDoList() {
    return axios.get(`${TODO_API_BASE_URL}todolist`);
  }

  addToDo(toDoItem) {
    return axios
      .post(`${TODO_API_BASE_URL}todoadd`, toDoItem)
      .then((res) =>
        console.log(
          `Task created, Status Code: ${res.status}`
        )
      )
      .catch((err) => console.log(err));
  }
}

export default new ToDoService();
