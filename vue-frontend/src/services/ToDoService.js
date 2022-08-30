import axios from "axios";

const TODO_API_BASE_URL = "http://localhost:8080/api/";

class ToDoService {
  getToDoList() {
    return axios.get(`${TODO_API_BASE_URL}todolist`);
  }

  addToDo(toDoItem) {
    return axios
      .post(`${TODO_API_BASE_URL}todoadd`, toDoItem)
      .then((res) => console.log(res))
      .catch((err) => console.log(err));
  }
}

export default new ToDoService();
