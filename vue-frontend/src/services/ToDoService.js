import axios from "axios";

const TODO_API_BASE_URL =
  "http://localhost:8080/api/todolist";

class ToDoService {
  getToDoList() {
    return axios.get(TODO_API_BASE_URL);
  }
}

export default new ToDoService();
